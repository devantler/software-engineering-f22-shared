using System;
using System.Collections.Concurrent;
using System.IO;
using System.Linq;
using Microsoft.Extensions.Configuration;
using System.Threading.Tasks;
using CameraColorScanner.Adapters.CameraAdapters;
using SixLabors.ImageSharp;
using SixLabors.ImageSharp.Advanced;
using SixLabors.ImageSharp.ColorSpaces.Conversion;
using SixLabors.ImageSharp.Formats.Png;
using SixLabors.ImageSharp.PixelFormats;
using SixLabors.ImageSharp.Processing;

namespace CameraColorScanner.Adapters
{

    public class CameraScannerAdapter : IColorScannerAdapter
    {
        private readonly ICamera _camera;

        public CameraScannerAdapter(ICamera camera)
        {
            _camera = camera;
        }

        public async Task<IColorScannerAdapter.Color> GetColor()
        {
            var image = await _camera.GetImage();
            image = await CropImage(image);
            return GetAverageColor(image);
        }

        private IColorScannerAdapter.Color GetAverageColor(Image<Rgba32> image)
        {
            var counts = CountColors(image);
            var majorityColor = counts.OrderByDescending(i => i.Value).First();
            Enum.TryParse((string?) majorityColor.Key.ToUpper(), out IColorScannerAdapter.Color returnValue);
            return returnValue;
        }

        private ConcurrentDictionary<string, int> CountColors(Image<Rgba32> image)
        {
            ConcurrentDictionary<string, int> counts = new();
            counts["Black"] = 0;
            counts["Red"] = 0;
            counts["Green"] = 0;
            counts["Blue"] = 0;
            counts["White"] = 0;
            var csc = new ColorSpaceConverter();
            Parallel.For(0, image.Width, (x) =>
            {
                for (int y = 0; y < image.Height; y++)
                {
                    var pixel = image[x, y];
                    var hsl = csc.ToHsl(pixel);
                    if (hsl.L < 0.2f)
                    {
                        counts["Black"]++;
                        continue;
                    }

                    if (hsl.L > 0.8f)
                    {
                        counts["White"]++;
                        continue;
                    }

                    if (hsl.S < 0.25f)
                        continue;

                    switch (hsl.H)
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


        private async Task<Image<Rgba32>?> CropImage(Image<Rgba32> image)
        {
            var crop = new SixLabors.ImageSharp.Rectangle(
                Configuration.Camera.Crop.x,
                Configuration.Camera.Crop.y,
                Configuration.Camera.Crop.Width,
                Configuration.Camera.Crop.Height
            );
            image.Mutate(ctx => ctx.Crop(crop));
            return image;
        }
    }
}