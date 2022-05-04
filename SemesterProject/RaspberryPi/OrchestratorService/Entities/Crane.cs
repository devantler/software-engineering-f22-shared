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
            await WaitTillIdle();
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Moving, "Running");
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Angle, _positions[positionName].ToString());
            await WaitTillIdle();
        }

        public async Task GoTo(int position)
        {
            await WaitTillIdle();
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Moving, "Running");
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Angle, position.ToString());
            await WaitTillIdle();
        }

        public async Task PickupItem()
        {
            await WaitTillIdle();
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Moving, "Running");
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Elevation, "0");
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Magnet, "1");
            await WaitTillIdle();
            await Task.Delay(2000);
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Moving, "Running");
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Elevation, "1");
            await WaitTillIdle();
        }

        public async Task DropItem()
        {
            await WaitTillIdle();
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Moving, "Running");
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Elevation, "0");
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Magnet, "0");
            await WaitTillIdle();
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Moving, "Running");
            await _mqttService.SendMessage(MqttTopics.Crane(_name).Elevation, "1");
        }

        private async Task WaitTillIdle(){
            while(!IsIdle())
            {
                await Task.Delay(100);
            }
        }
        private bool IsIdle(){
            return _mqttService.GetMessage(MqttTopics.Crane(_name).Moving) == "Stopped" && _mqttService.GetMessage(MqttTopics.Disk(_name).Moving) == "Stopped";
        }

        public string GetName()
        {
            return _name;
        }
    }
}
