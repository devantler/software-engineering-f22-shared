using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;
using MQTTnet;
using MQTTnet.Client.Connecting;
using MQTTnet.Client.Disconnecting;
using MQTTnet.Client.Options;
using MQTTnet.Client.Receiving;
using MQTTnet.Extensions.ManagedClient;

namespace Domain.Services
{
    public class MqttService : IMqttService
    {
        private const string ClientId = "DotNetApp";
        private const string Ip = "192.168.10.1";
        private const int Port = 1883;

        private IManagedMqttClient _mqttClient;
        private Dictionary<string, string> messages = new Dictionary<string, string>();
        
        public MqttService()
        {
            // Creates a new client
            MqttClientOptionsBuilder builder = new MqttClientOptionsBuilder()
                .WithClientId(ClientId)
                .WithTcpServer(Ip, Port);

            // Create client options objects
            ManagedMqttClientOptions options = new ManagedMqttClientOptionsBuilder()
                .WithAutoReconnectDelay(TimeSpan.FromSeconds(60))
                .WithClientOptions(builder.Build())
                .Build();

            // Creates the client object
            _mqttClient = new MqttFactory().CreateManagedMqttClient();

            // Set up handlers
            _mqttClient.ConnectedHandler = new MqttClientConnectedHandlerDelegate(OnConnected);
            _mqttClient.DisconnectedHandler = new MqttClientDisconnectedHandlerDelegate(OnDisconnected);
            _mqttClient.ConnectingFailedHandler = new ConnectingFailedHandlerDelegate(OnConnectingFailed);
            _mqttClient.ApplicationMessageReceivedHandler =
                new MqttApplicationMessageReceivedHandlerDelegate(OnMessageReceived);
            
            // Starts a connection with the Broker
            _mqttClient.StartAsync(options).GetAwaiter().GetResult();
        }

        private void OnMessageReceived(MqttApplicationMessageReceivedEventArgs obj)
        {
            var topic = obj.ApplicationMessage.Topic;
            var message = Encoding.Default.GetString(obj.ApplicationMessage.Payload);
            if (messages.ContainsKey(topic))
            {
                messages[topic] = message;
            }
            else
            {
                messages.Add(topic, message);
            }
        }

        public string? GetMessage(string topic)
        {
            messages.TryGetValue(topic, out var msg);
            return msg;
        }

        public async Task SendMessage(string topic, string message)
        {
            var mqttMessage = new MqttApplicationMessage()
            {
                Topic = topic,
                Payload = Encoding.ASCII.GetBytes(message)
            };
            await _mqttClient.PublishAsync(mqttMessage);
        }

        private void OnConnected(MqttClientConnectedEventArgs obj)
        {
            Console.WriteLine("Successfully connected.");
        }

        private void OnConnectingFailed(ManagedProcessFailedEventArgs obj)
        {
            Console.WriteLine("Couldn't connect to broker.");
        }

        private void OnDisconnected(MqttClientDisconnectedEventArgs obj)
        {
            Console.WriteLine("Successfully disconnected.");
        }
        
    }
}