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
        //Scanner stuff
        return string.Empty;
    }

    public string GetName()
    {
        return _name;
    }
}
