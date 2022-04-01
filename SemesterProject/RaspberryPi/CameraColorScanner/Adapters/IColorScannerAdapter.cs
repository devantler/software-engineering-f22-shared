using System.Threading.Tasks;

namespace CameraColorScanner.Adapters
{

    public interface IColorScannerAdapter
    {
        Task<Color> GetColor();

        enum Color
        {
            RED,
            GREEN,
            BLUE
        }
    }
}