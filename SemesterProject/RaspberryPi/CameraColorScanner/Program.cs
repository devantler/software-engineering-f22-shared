using System.Threading.Tasks;
using CameraColorScanner.Adapters;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

namespace CameraColorScanner;

class Program
{
    static Task Main(string[] args)
    {
        return CreateHostBuilder(args).Build().RunAsync();
    }

    static IHostBuilder CreateHostBuilder(string[] args) =>
        Host.CreateDefaultBuilder(args)
            .ConfigureServices((_, services) =>
            {
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