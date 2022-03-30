using System;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using CameraColorScanner.Adapters;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using MQTTnet.Client;
using MQTTnet;
using MQTTnet.Protocol;

namespace CameraColorScanner.Services;

public class MqttService : IHostedService
{
    private readonly IConfiguration _configuration;
    private IConfiguration _mqttConfig;
    private MqttClient _mqttClient;
    private readonly IColorScannerAdapter _colorScanner;

    public MqttService(IConfiguration configuration, IColorScannerAdapter colorScannerAdapter)
    {
        _configuration = configuration;
        _colorScanner = colorScannerAdapter;
    }

    public async Task StartAsync(CancellationToken cancellationToken)
    {
        _mqttConfig = _configuration.GetRequiredSection("MQTT");

        _mqttClient = new MqttFactory().CreateMqttClient();
        var mqttOptionsBuilder = new MqttClientOptionsBuilder()
            .WithClientId(_mqttConfig["ClientId"])
            .WithTcpServer(_mqttConfig["Hostname"], _mqttConfig.GetValue<int>("Port"));
        if (_mqttConfig.GetValue<string?>("Username") != null
            && _mqttConfig.GetValue<string?>("Password") != null)
        {
            mqttOptionsBuilder.WithCredentials(_mqttConfig["Username"], _mqttConfig["Password"]);
        }

        if (_mqttConfig.GetValue<bool>("UseSsl"))
        {
            mqttOptionsBuilder.WithTls();
        }

        await _mqttClient.ConnectAsync(mqttOptionsBuilder.Build(), cancellationToken);

        while (!_mqttClient.IsConnected)
        {
            await Task.Delay(50);
        }

        await _mqttClient.SubscribeAsync(_mqttConfig["CommandTopic"], MqttQualityOfServiceLevel.ExactlyOnce, cancellationToken);
        _mqttClient.ApplicationMessageReceivedAsync += MqttCallback;
    }

    private async Task MqttCallback(MqttApplicationMessageReceivedEventArgs args)
    {
        var topic = args.ApplicationMessage.Topic;
        var message = Encoding.UTF8.GetString(args.ApplicationMessage.Payload);

        if (topic == _mqttConfig["CommandTopic"] && message == "GetColor")
        {
            if (_mqttConfig.GetValue<bool>("PrintDebug"))
            {
                Console.WriteLine("Got message!");
            }
            var scannedColor = await _colorScanner.GetColor();

            var resultTopic = _mqttConfig.GetValue<string>("ResultTopic");
            if (resultTopic == null)
            {
                await SendMessage(
                    _mqttConfig.GetValue<string>("LogTopic", "/log") + "/error",
                    $"Result topic not defined.",
                    true);
            }
            else
            {
                await SendMessage(
                    _mqttConfig.GetValue<string>("ResultTopic")!, //The exclamation-point suppresses null warning
                    scannedColor.ToString(),
                    false);
            }
        }
        else
        {
            if (_mqttConfig.GetValue<bool>("PrintDebug"))
            {
                Console.WriteLine($"Unknown topic: {topic} or command: {message}");
            }
            await SendMessage(
                _mqttConfig.GetValue<string>("LogTopic", "/log") + "/error",
                $"Unknown topic: {topic} or command: {message}",
                true);
        }
    }

    public async Task SendMessage(string topic, string payload, bool retain = false)
    {
        await SendMessage(topic, Encoding.UTF8.GetBytes(payload), retain);
    }

    public async Task SendMessage(string topic, byte[] payload, bool retain = false)
    {
        var mqttMessage = new MqttApplicationMessageBuilder()
            .WithTopic(topic)
            .WithRetainFlag(retain)
            .WithPayload(payload)
            .WithQualityOfServiceLevel(MqttQualityOfServiceLevel.ExactlyOnce);

        await _mqttClient.PublishAsync(mqttMessage.Build(), CancellationToken.None);
    }

    public async Task StopAsync(CancellationToken cancellationToken)
    {
        await _mqttClient.DisconnectAsync();
    }
}
