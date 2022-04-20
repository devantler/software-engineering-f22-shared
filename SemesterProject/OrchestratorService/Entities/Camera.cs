using Mqtt;

namespace Entities;

public class Camera
{
    private readonly string _name;
	private readonly IMqttService _mqttService;
	private readonly List<string> _colors;
    public Camera(string name, List<string> colors, IMqttService mqttService){
        _name = name;
        _colors = colors;
        _mqttService = mqttService;
    }

    public string Scan()
    {
        _mqttService.SendMessage(MqttTopics.Camera(_name).Scan, "1");
        while (_mqttService.GetMessage(MqttTopics.Camera(_name).Scanning) == "1")
        {
            Task.Delay(100);
        }
        return _mqttService.GetMessage(MqttTopics.Camera(_name).Color) ?? Scan();
    }

    public string GetName()
    {
        return _name;
    }
}
