using Mqtt;

namespace Entities;

public class Camera
{
	private readonly IMqttService _mqttService;
	private readonly List<string> _colors;
    public Camera(List<string> colors, IMqttService mqttService){
        _colors = colors;
        _mqttService = mqttService;
    }

    public string Scan()
    {
        //Scanner stuff
        return string.Empty;
    }
}
