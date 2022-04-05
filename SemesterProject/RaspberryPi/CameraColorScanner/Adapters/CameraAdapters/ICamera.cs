using System.Threading.Tasks;
using SixLabors.ImageSharp;
using SixLabors.ImageSharp.PixelFormats;

namespace CameraColorScanner.Adapters.CameraAdapters
{
    public interface ICamera
    {
        Task<Image<Rgba32>> GetImage();
    }
}