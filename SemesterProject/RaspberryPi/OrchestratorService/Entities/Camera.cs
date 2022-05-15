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

    public async Task<string> Scan()
    {
        await _mqttService.SendMessage(MqttTopics.Camera(_name).Color, "");
        await _mqttService.SendMessage(MqttTopics.Camera(_name).Scan, "GetColor");
        await WaitWhileIdle();
        return _mqttService.GetMessage(MqttTopics.Camera(_name).Color) ?? "RED";
    }

    private async Task WaitWhileIdle(){
        while(IsIdle())
        {
            await Task.Delay(100);
        }
    }

    private bool IsIdle(){
        return string.IsNullOrEmpty(_mqttService.GetMessage(MqttTopics.Camera(_name).Color));
    }

    public string GetName()
    {
        return _name;
    }
}
