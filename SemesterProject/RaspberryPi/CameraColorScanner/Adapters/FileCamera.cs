using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Threading.Tasks;
using SixLabors.ImageSharp;
using SixLabors.ImageSharp.Advanced;
using SixLabors.ImageSharp.Formats.Png;
using Image = SixLabors.ImageSharp.Image;

namespace CameraColorScanner.Adapters
{
    public class FileCamera : ICamera
    {
        public async Task<Bitmap> GetImage()
        {
            await using var memStream = new MemoryStream();
            var img = Image.Load("/app/image.bmp");
            await img.SaveAsync(memStream, img.GetConfiguration().ImageFormatsManager.FindEncoder(PngFormat.Instance));
            memStream.Seek(0, SeekOrigin.Begin);
            return new Bitmap(memStream);
        }
    }
}