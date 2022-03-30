using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Linq;
using CameraColorScanner.Services;
using OpenCvSharp;
using Microsoft.Extensions.Configuration;
using OpenCvSharp.Extensions;
using System.Threading.Tasks;
using Microsoft.Extensions.DependencyInjection;
using OpenCvSharp.Aruco;
using SixLabors.ImageSharp.Advanced;
using SixLabors.ImageSharp.Formats.Png;
using SixLabors.ImageSharp.Processing;

namespace CameraColorScanner.Adapters;

public class CameraScannerAdapter : IColorScannerAdapter
{
    private readonly MqttService _mqttService;
    private readonly VideoCapture _capture;
    private readonly Mat _frame;
    private readonly IConfiguration _cameraConfig;

    public CameraScannerAdapter(MqttService mqttService, IConfiguration configuration)
    {
        _mqttService = mqttService;
        _frame = new Mat();
        _capture = new VideoCapture(0);
        _cameraConfig = configuration.GetRequiredSection("Camera");
    }

    public async Task<IColorScannerAdapter.Color> GetColor()
    {
        _capture.Open(0);
        while (!_capture.IsOpened())
        {
            await Task.Delay(200);
        }

        _capture.Read(_frame);
        var image = _frame.ToBitmap();
        image = await CropImage(image);
        return await GetAverageColor(image);
    }

    private async Task<IColorScannerAdapter.Color> GetAverageColor(Bitmap image)
    {
        var counts = await CountColors(image);
        var majorityColor = counts.OrderByDescending(i => i.Value).First();
        IColorScannerAdapter.Color.TryParse((string?)majorityColor.Key.ToUpper(), out IColorScannerAdapter.Color returnValue);
        return returnValue;
    }

    private async Task<ConcurrentDictionary<string, int>> CountColors(Bitmap image)
    {
        //TODO: Parralelize
        ConcurrentDictionary<string, int> counts = new();
        counts["Black"] = 0;
        counts["Red"] = 0;
        counts["Green"] = 0;
        counts["Blue"] = 0;
        counts["White"] = 0;

        Parallel.For(0, image.Width, (x) =>
        {
            for (int y = 0; y < image.Height; y++)
            {
                var pixel = image.GetPixel(x, y);
                if (pixel.GetBrightness() < 0.2)
                {
                    counts["Black"]++;
                    continue;
                }

                if (pixel.GetBrightness() > 0.8f)
                {
                    counts["White"]++;
                    continue;
                }

                if (pixel.GetSaturation() < 0.25)
                    continue;

                switch (pixel.GetHue())
                {
                    case < 30f:
                        counts["Red"]++;
                        continue;
                    case < 150f:
                        counts["Green"]++;
                        continue;
                    case < 270f:
                        counts["Blue"]++;
                        continue;
                }
            }
        });

        return counts;
    }


    private async Task<Bitmap> CropImage(Bitmap image)
    {
        var cropSection = _cameraConfig.GetRequiredSection("crop");
        var crop = new SixLabors.ImageSharp.Rectangle(
            cropSection.GetValue<int>("x"),
            cropSection.GetValue<int>("y"),
            cropSection.GetValue<int>("width"),
            cropSection.GetValue<int>("height")
        );
        SixLabors.ImageSharp.Image garbageImage;
        using (var memstream = new MemoryStream())
        {
            image.Save(memstream, ImageFormat.Png);
            memstream.Seek(0, SeekOrigin.Begin);
            garbageImage = await SixLabors.ImageSharp.Image.LoadAsync(memstream);
        }

        garbageImage.Mutate(ctx => ctx.Crop(crop));
        using (var memstream = new MemoryStream())
        {
            var encoder = garbageImage.GetConfiguration().ImageFormatsManager.FindEncoder(PngFormat.Instance);
            await garbageImage.SaveAsync(memstream, encoder);
            memstream.Seek(0, SeekOrigin.Begin);
            return new System.Drawing.Bitmap(memstream);
        }
    }
}