using Mqtt;

namespace Entities;

public class Camera
{
	private readonly List<string> _colors;
	   private IMqttService _mqttService;

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
