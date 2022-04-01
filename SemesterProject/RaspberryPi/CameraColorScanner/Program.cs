using System;
using System.Threading.Tasks;
using CameraColorScanner.Adapters;
using CameraColorScanner.Services;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

namespace CameraColorScanner;

class Program
{
    static Task Main(string[] args)
    {
        Console.WriteLine("Program Starting");
        return CreateHostBuilder(args).Build().RunAsync();
    }

    static IHostBuilder CreateHostBuilder(string[] args) =>
        Host.CreateDefaultBuilder(args)
            .ConfigureServices((_, services) =>
            {
                services.AddScoped<ICamera, FileCamera>();
                services.AddSingleton<IColorScannerAdapter, CameraScannerAdapter>();
                services.AddHostedService<MqttService>();
                services.Add(ServiceDescriptor.Singleton<IColorScannerAdapter, CameraScannerAdapter>());
            })
            .ConfigureAppConfiguration((hostingContext, configuration) =>
            {
                configuration.Sources.Clear();

                var env = hostingContext.HostingEnvironment;

                configuration
                    .AddEnvironmentVariables()
                    .AddJsonFile("appsettings.json", optional: true, reloadOnChange: true)
                    .AddJsonFile($"appsettings.{env.EnvironmentName}.json", optional: true, reloadOnChange: true);


                var configurationRoot = configuration.Build();
            });
}