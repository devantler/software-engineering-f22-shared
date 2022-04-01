using System.Drawing;
using System.Threading.Tasks;

namespace CameraColorScanner.Adapters
{
    public interface ICamera
    {
        Task<Bitmap> GetImage();
    }
}