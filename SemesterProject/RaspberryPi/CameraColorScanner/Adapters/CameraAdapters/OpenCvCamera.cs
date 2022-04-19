using System.IO;
using System.Threading.Tasks;
using OpenCvSharp;
using SixLabors.ImageSharp;
using SixLabors.ImageSharp.PixelFormats;

namespace CameraColorScanner.Adapters.CameraAdapters
{
    public class OpenCvCamera : ICamera
    {
       private Mat _frame = new Mat();
       private VideoCapture _capture = new VideoCapture(0);
       
       public async Task<Image<Rgba32>> GetImage()
       {
           _capture.Open(0);
           while (!_capture.IsOpened())
           {
               await Task.Delay(200);
           }
           
           _capture.Read(_frame);
           var stream = _frame.ToMemoryStream();
           stream.Seek(0, SeekOrigin.Begin);
           return Image.Load<Rgba32>(stream);
       }
    }
}