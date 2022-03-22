using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using MQTTnet.Client;

namespace CameraColorScanner.Services;

public class MqttService
{
    private IConfiguration _configuration;
    public MqttService(IConfiguration configuration)
    {
        _configuration = configuration;
    }
}