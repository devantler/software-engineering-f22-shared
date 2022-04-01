using System.Drawing;
using System.Threading.Tasks;

namespace CameraColorScanner.Adapters
{
    public class FileCamera : ICamera
    {
        public Task<Bitmap> GetImage()
        {
            return Task.FromResult((Bitmap) Image.FromFile("/app/image.bmp"));
        }
    }
}