using System;
using System.Collections.Concurrent;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Linq;
using Microsoft.Extensions.Configuration;
using System.Threading.Tasks;
using SixLabors.ImageSharp.Advanced;
using SixLabors.ImageSharp.Formats.Png;
using SixLabors.ImageSharp.Processing;

namespace CameraColorScanner.Adapters
{

    public class CameraScannerAdapter : IColorScannerAdapter
    {
        private readonly ICamera _camera;
        private readonly IConfiguration _cameraConfig;

        public CameraScannerAdapter(ICamera camera, IConfiguration configuration)
        {
            _camera = camera;
            _cameraConfig = configuration.GetRequiredSection("Camera");
        }

        public async Task<IColorScannerAdapter.Color> GetColor()
        {
            var image = await _camera.GetImage();
            image = await CropImage(image);
            return GetAverageColor(image);
        }

        private IColorScannerAdapter.Color GetAverageColor(Bitmap image)
        {
            var counts = CountColors(image);
            var majorityColor = counts.OrderByDescending(i => i.Value).First();
            Enum.TryParse((string?) majorityColor.Key.ToUpper(), out IColorScannerAdapter.Color returnValue);
            return returnValue;
        }

        private ConcurrentDictionary<string, int> CountColors(Bitmap image)
        {
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
                    if (pixel.GetBrightness() < 0.2f)
                    {
                        counts["Black"]++;
                        continue;
                    }

                    if (pixel.GetBrightness() > 0.8f)
                    {
                        counts["White"]++;
                        continue;
                    }

                    if (pixel.GetSaturation() < 0.25f)
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
            await using (var memstream = new MemoryStream())
            {
                image.Save(memstream, ImageFormat.Png);
                memstream.Seek(0, SeekOrigin.Begin);
                garbageImage = await SixLabors.ImageSharp.Image.LoadAsync(memstream);
            }

            garbageImage.Mutate(ctx => ctx.Crop(crop));
            await using (var memstream = new MemoryStream())
            {
                var encoder = garbageImage.GetConfiguration().ImageFormatsManager.FindEncoder(PngFormat.Instance);
                await garbageImage.SaveAsync(memstream, encoder);
                memstream.Seek(0, SeekOrigin.Begin);
                return new System.Drawing.Bitmap(memstream);
            }
        }
    }
}