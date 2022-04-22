using Mqtt;

namespace Entities;

public class Camera
{
    private readonly string _name;
	private readonly IMqttService _mqttService;
	private readonly List<string> _colors;
	   
	public Camera(string name, List<string> colors, IMqttService mqttService)
	{
		_name = name;
		_colors = colors;
		_mqttService = mqttService;
	}

    public string Scan()
    {
        _mqttService.SendMessage(MqttTopics.Camera(_name).Scan, "GetColor");
        while (_mqttService.GetMessage(MqttTopics.Camera(_name).Scanning) == "true")
        {
            Task.Delay(100);
        }
        return _mqttService.GetMessage(MqttTopics.Camera(_name).Color);
    }

    public string GetName()
    {
        return _name;
    }
}
