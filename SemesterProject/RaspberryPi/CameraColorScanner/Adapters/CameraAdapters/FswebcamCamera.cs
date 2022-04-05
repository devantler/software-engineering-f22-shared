using System;
using System.Diagnostics;
using System.IO;
using System.Threading.Tasks;
using CameraColorScanner.Helpers;
using SixLabors.ImageSharp;
using SixLabors.ImageSharp.PixelFormats;
using Image = SixLabors.ImageSharp.Image;

namespace CameraColorScanner.Adapters.CameraAdapters
{
    public class FswebcamCamera : ICamera
    {
        public async Task<Image<Rgba32>> GetImage()
        {
            Image<Rgba32> img = null;
            await using var memStream = new MemoryStream();
            try
            {
                var fileName = Path.GetTempPath() + StringHelper.RandomString(5) + ".jpeg";
                
                //Create a process that creates a temporary file, then takes an image into that file 
                var process = new Process
                {
                    StartInfo = new ProcessStartInfo
                    {
                        FileName = "fswebcam",
                        Arguments = $"-r 1280x1024 --no-banner --jpeg 95 -S 5 -F 5 {fileName}",
                        UseShellExecute = false,
                        RedirectStandardOutput = true,
                        CreateNoWindow = true
                    }
                };
                process.Start();
                await process.WaitForExitAsync();
                
                //Read the image from the file
                img = Image.Load<Rgba32>(fileName);

            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                throw;
                img = Image.Load<Rgba32>("/app/image.bmp");
            }
            return img;
        }
    }
}