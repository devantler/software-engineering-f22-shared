using System.Drawing;
using System.Threading.Tasks;
using OpenCvSharp;
using OpenCvSharp.Extensions;

namespace CameraColorScanner.Adapters
{
    public class Camera : ICamera
    {
       private Mat _frame = new Mat();
       private VideoCapture _capture = new VideoCapture(0);

       public async Task<Bitmap> GetImage()
       {
           _capture.Open(0);
           while (!_capture.IsOpened())
           {
               await Task.Delay(200);
           }

           _capture.Read(_frame);
           return _frame.ToBitmap();
       }
    }
}