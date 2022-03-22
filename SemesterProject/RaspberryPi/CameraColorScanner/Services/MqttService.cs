using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using MQTTnet.Client;
using MQTTnet;

namespace CameraColorScanner.Services;

public class MqttService : IHostedService
{
    private IConfiguration _Configuration;

    public MqttService(IConfiguration configuration)
    {
        _Configuration = configuration;
    }

    public Task StartAsync(CancellationToken cancellationToken)
    {
        IConfiguration MQTTCongfig = _Configuration.GetRequiredSection("MQTT");

        var mqttClient = new MqttFactory().CreateMqttClient();
        var mqttOptionsBuilder = new MqttClientOptionsBuilder()
            .WithClientId(MQTTCongfig["ClientId"])
            .WithTcpServer(MQTTCongfig["Hostname"], MQTTCongfig.GetValue<int>("Port"));
        if (MQTTCongfig.GetValue<string?>("Username") != null
            && MQTTCongfig.GetValue<string?>("Password") != null)
        {
            mqttOptionsBuilder.WithCredentials(MQTTCongfig["Username"], MQTTCongfig["Password"]);
        }

        if (MQTTCongfig.GetValue<bool>("UseSsl"))
        {
            mqttOptionsBuilder.WithTls();
        }
        
        mqttClient.ConnectAsync(mqttOptionsBuilder.Build(), cancellationToken).Wait();

        mqttClient.SubscribeAsync(
        return Task.CompletedTask;
    }

    public Task StopAsync(CancellationToken cancellationToken)
    {
        throw new NotImplementedException();
    }
}