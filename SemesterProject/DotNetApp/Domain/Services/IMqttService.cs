using System.Threading.Tasks;

namespace Domain.Services
{
    public interface IMqttService
    {
        Task SendMessage(string topic, string message);
    }
}