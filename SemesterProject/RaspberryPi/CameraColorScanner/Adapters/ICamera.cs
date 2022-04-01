using System.Drawing;
using System.Threading.Tasks;
using SixLabors.ImageSharp;
using SixLabors.ImageSharp.PixelFormats;

namespace CameraColorScanner.Adapters
{
    public interface ICamera
    {
        Task<Image<Rgba32>> GetImage();
    }
}