using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Domain.Services;

namespace Domain.Entities
{
    public class Crane
    {
        private Dictionary<string, int> _positions;
        private IMqttService _mqttService;

        public Crane(Dictionary<string, int> positions, IMqttService mqttService)
        {
            _positions = positions;
            _mqttService = mqttService;
        }

        public void AddPosition(string name, int angle)
        {
            _positions.Add(name, angle);
        }

        public async Task Goto(string position)
        {
            await _mqttService.SendMessage(MqttTopics.Crane.Angle, _positions[position].ToString());
        }
        
        public async Task Goto(int position)
        {
            await _mqttService.SendMessage(MqttTopics.Crane.Angle, position.ToString());
        }

        public async Task PickupItem()
        {
            await _mqttService.SendMessage(MqttTopics.Crane.Elevation, "LOW");
            await _mqttService.SendMessage(MqttTopics.Crane.Magnet, "1");
            while (_mqttService.GetMessage(MqttTopics.Crane.Moving) != "0")
            {
                await Task.Delay(100);
            }
            await _mqttService.SendMessage(MqttTopics.Crane.Elevation, "HIGH");
        }
        
        public async Task DropItem()
        {
            await _mqttService.SendMessage(MqttTopics.Crane.Elevation, "LOW");
            while (_mqttService.GetMessage(MqttTopics.Crane.Moving) != "0")
            {
                await Task.Delay(100);
            }
            await _mqttService.SendMessage(MqttTopics.Crane.Magnet, "0");
            await _mqttService.SendMessage(MqttTopics.Crane.Elevation, "HIGH");
        }
    }
}