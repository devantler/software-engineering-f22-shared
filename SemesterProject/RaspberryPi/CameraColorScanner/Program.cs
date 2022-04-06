using System;
using System.Threading.Tasks;
using CameraColorScanner.Adapters;
using CameraColorScanner.Adapters.CameraAdapters;
using CameraColorScanner.Services;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

namespace CameraColorScanner
{

    class Program
    {
        static Task Main(string[] args)
        {
            Console.WriteLine("Program Starting");
            return CreateHostBuilder(args).Build().RunAsync();
        }

        static IHostBuilder CreateHostBuilder(string[] args) =>
            Host.CreateDefaultBuilder(args)
                .ConfigureServices((hostContext, services) =>
                {
                    services.AddScoped<ICamera, FswebcamCamera>();
                    services.AddSingleton<IColorScannerAdapter, CameraScannerAdapter>();
                    services.AddHostedService<MqttService>();
                    services.Add(ServiceDescriptor.Singleton<IColorScannerAdapter, CameraScannerAdapter>());
                });

    }
}