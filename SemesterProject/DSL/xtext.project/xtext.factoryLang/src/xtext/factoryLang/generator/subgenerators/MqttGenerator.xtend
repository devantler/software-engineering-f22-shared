package xtext.factoryLang.generator.subgenerators

import org.eclipse.xtext.generator.IFileSystemAccess2

class MqttGenerator {

	def static generate(IFileSystemAccess2 fsa) {
		generateMqttTopics(fsa)
		generateIMqttService(fsa)
		generateMqttService(fsa)
	}

	protected def static void generateMqttService(IFileSystemAccess2 fsa) {
		fsa.generateFile(
			'OrchestratorService/Mqtt/MqttService.cs',
			'''
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
				
				namespace Mqtt
				{
				    public class MqttService : IMqttService
				    {
				        private const string ClientId = "OrchestratorService";
				        private const string Ip = "192.168.10.1";
				        private const int Port = 1883;
				
				        private readonly IManagedMqttClient _mqttClient;
				        private readonly Dictionary<string, string> messages = new Dictionary<string, string>();
				
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
				            _mqttClient.ApplicationMessageReceivedHandler = new MqttApplicationMessageReceivedHandlerDelegate(OnMessageReceived);
				
				            // Starts a connection with the Broker
				            _mqttClient.StartAsync(options).GetAwaiter().GetResult();
				        }
				
				        private void OnMessageReceived(MqttApplicationMessageReceivedEventArgs obj)
				        {
				        	var topic = obj.ApplicationMessage.Topic;
				        	messages[topic] = Encoding.Default.GetString(obj.ApplicationMessage.Payload);
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
			'''
		)
	}

	protected def static void generateIMqttService(IFileSystemAccess2 fsa) {
		fsa.generateFile(
			'OrchestratorService/Mqtt/IMqttService.cs',
			'''
				using System.Threading.Tasks;
				
				namespace Mqtt
				{
				    public interface IMqttService
				    {
				        Task SendMessage(string topic, string message);
				        string? GetMessage(string topic);
				    }
				}
			'''
		)
	}

	protected def static void generateMqttTopics(IFileSystemAccess2 fsa) {
		fsa.generateFile(
			'OrchestratorService/Mqtt/MqttTopics.cs',
			'''
				namespace Mqtt
				{
				    public static class MqttTopics
				    {
				        public static class Crane
				        {
				            public static string Angle(string craneName)
				            {
				                return $"{craneName}/angle";
				            }
				
				            public static string Elevation(string craneName)
				            {
				                return $"{craneName}/elevation";
				            }
				
				            public static string Moving(string craneName)
				            {
				                return $"{craneName}/moving";
				            }
				
				            public static string Magnet(string craneName)
				            {
				                return $"{craneName}/magnet";
				            }
				        }
				
				        public static class Disk
				        {
				            public static string Slot(string diskName)
				            {
				                return $"{diskName}/slot";
				            }
				
				            public static string Zone(string diskName)
				            {
				                return $"{diskName}/zone";
				            }
				
				            public static string Moving(string diskName)
				            {
				                return $"{diskName}/moving";
				            }
				        }
				
				        public static class Camera
				        {
				            public static string Scan(string cameraName)
				            {
				                return $"{cameraName}/scan";
				            }
				
				            public static string Scanning(string cameraName)
				            {
				                return $"{cameraName}/scanning";
				            }
				        }
				    }
				}
			'''
		)
	}
}
