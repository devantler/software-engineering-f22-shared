namespace Mqtt
{
    public interface IMqttService
    {
        Task SendMessage(string topic, string message);
        string GetMessage(string topic);
    }
}
