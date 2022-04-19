using System.IO;
using System.Threading.Tasks;
using SixLabors.ImageSharp;
using SixLabors.ImageSharp.PixelFormats;
using Image = SixLabors.ImageSharp.Image;

namespace CameraColorScanner.Adapters.CameraAdapters
{
    public class FileCamera : ICamera
    {
        public async Task<Image<Rgba32>> GetImage()
        {
            await using var memStream = new MemoryStream();
            var img = Image.Load<Rgba32>("/app/image.bmp");
            return img;
        }
    }
}