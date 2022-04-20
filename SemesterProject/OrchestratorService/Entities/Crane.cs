using Mqtt;

namespace Entities
{
    public class Crane
    {
        private readonly string _name;
        private readonly Dictionary<string, int> _positions;
        private readonly IMqttService _mqttService;

        public Crane(string name,Dictionary<string, int> positions, IMqttService mqttService)
        {
            _name = name;
            _positions = positions;
            _mqttService = mqttService;
        }

        public void AddPosition(string name, int angle)
        {
            _positions.Add(name, angle);
        }

        public async Task GoTo(string positionName)
        {
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Angle, _positions[positionName].ToString());
        }

        public async Task GoTo(int position)
        {
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Angle, position.ToString());
        }

        public async Task PickupItem()
        {
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Elevation, "LOW");
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Magnet, "1");
            while (_mqttService.GetMessage(MqttTopics.Crane(_name).Moving) != "0")
            {
                await Task.Delay(100);
            }
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Elevation, "HIGH");
        }

        public async Task DropItem()
        {
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Elevation, "LOW");
            while (_mqttService.GetMessage(MqttTopics.Crane(_name).Moving) != "0")
            {
                await Task.Delay(100);
            }
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Magnet, "0");
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Elevation, "HIGH");
        }

        public string GetName()
        {
            return _name;
        }
    }
}
