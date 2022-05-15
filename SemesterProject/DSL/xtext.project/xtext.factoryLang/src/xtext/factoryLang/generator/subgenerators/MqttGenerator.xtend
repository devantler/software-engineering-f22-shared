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
				using System.Text;
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
				        private readonly Dictionary<string, string> messages = new();
				
				        public MqttService()
				        {
				            MqttClientOptionsBuilder builder = new MqttClientOptionsBuilder()
				                .WithClientId(ClientId)
				                .WithTcpServer(Ip, Port);
				
				            ManagedMqttClientOptions options = new ManagedMqttClientOptionsBuilder()
				                .WithAutoReconnectDelay(TimeSpan.FromSeconds(60))
				                .WithClientOptions(builder.Build())
				                .Build();
				
				            _mqttClient = new MqttFactory().CreateManagedMqttClient();
				
				            _mqttClient.ConnectedHandler = new MqttClientConnectedHandlerDelegate(OnConnected);
				            _mqttClient.DisconnectedHandler = new MqttClientDisconnectedHandlerDelegate(OnDisconnected);
				            _mqttClient.ConnectingFailedHandler = new ConnectingFailedHandlerDelegate(OnConnectingFailed);
				            _mqttClient.ApplicationMessageReceivedHandler = new MqttApplicationMessageReceivedHandlerDelegate(OnMessageReceived);
				            _mqttClient.StartAsync(options).GetAwaiter().GetResult();
				
				            var mqttSubscribeOptions = new MqttFactory().CreateSubscribeOptionsBuilder()
				                .WithTopicFilter(x => x.WithTopic(MqttTopics.Crane("+").Angle))
				                .WithTopicFilter(x => x.WithTopic(MqttTopics.Crane("+").Elevation))
				                .WithTopicFilter(x => x.WithTopic(MqttTopics.Crane("+").Magnet))
				                .WithTopicFilter(x => x.WithTopic(MqttTopics.Crane("+").Moving))
				                .WithTopicFilter(x => x.WithTopic(MqttTopics.Disk("+").Zone))
				                .WithTopicFilter(x => x.WithTopic(MqttTopics.Disk("+").Moving))
				                .WithTopicFilter(x => x.WithTopic(MqttTopics.Camera("+").Color))
				                .WithTopicFilter(x => x.WithTopic(MqttTopics.Camera("+").Scanning))
				                .WithTopicFilter(x => x.WithTopic(MqttTopics.Camera("+").Scan))
				                .WithTopicFilter(x => x.WithTopic(MqttTopics.Utility("intake").WaitForIntake))
				                .Build();
				            _mqttClient.SubscribeAsync(mqttSubscribeOptions.TopicFilters).GetAwaiter().GetResult();
				        }
				
				        private void OnMessageReceived(MqttApplicationMessageReceivedEventArgs obj)
				        {
				            var topic = obj.ApplicationMessage.Topic;
				            if (obj.ApplicationMessage.Payload == null) {
				                messages[topic] = "";
				                return;
				            }
				            messages[topic] = Encoding.Default.GetString(obj.ApplicationMessage.Payload);
				        }
				
				        public string GetMessage(string topic)
				        {
				            messages.TryGetValue(topic, out var msg);
				            return msg ?? "";
				        }
				
				        public async Task SendMessage(string topic, string message)
				        {
				            Console.WriteLine($"Sending message to {topic}: {message}");
				            var mqttMessage = new MqttApplicationMessage()
				            {
				                Topic = topic,
				                Payload = Encoding.ASCII.GetBytes(message)
				            };
				            await _mqttClient.PublishAsync(mqttMessage);
				            if (!messages.TryAdd(topic, message))
				            {
				                messages[topic] = message;
				            }
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
				namespace Mqtt
				{
				    public interface IMqttService
				    {
				        Task SendMessage(string topic, string message);
				        string GetMessage(string topic);
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
				        public static CraneTopic Crane(string name)
				        {
				            return new CraneTopic(name);
				        }
				
				        public class CraneTopic
				        {
				            private string Name { get; }
				
				            public CraneTopic(string name)
				            {
				                Name = name;
				            }
				            public string Angle { get => $"{Name}/angle"; }
				
				            public string Elevation { get => $"{Name}/elevation"; }
				
				            public string Magnet { get => $"{Name}/magnet"; }
				
				            public string Moving { get => $"{Name}/moving"; }
				        }
				
				        public static DiskTopic Disk(string name)
				        {
				            return new DiskTopic(name);
				        }
				
				        public class DiskTopic
				        {
				            private string Name { get; }
				
				            public DiskTopic(string name)
				            {
				                Name = name;
				            }
				
				            public string Zone { get => $"{Name}/zone"; }
				
				            public string Moving { get => $"{Name}/moving"; }
				        }
				
				        public static CameraTopic Camera(string name)
				        {
				            return new CameraTopic(name);
				        }
				
				        public class CameraTopic
				        {
				            private string Name { get; }
				
				            public CameraTopic(string name)
				            {
				                Name = name;
				            }
				
				            public string Scan { get => $"{Name}/command"; }
				
				            public string Color { get => $"{Name}/result"; }
				
				            public string Scanning { get => $"{Name}/scanning"; }
				        }
				
				        public static UtilityTopic Utility(string name)
				        {
				            return new UtilityTopic(name);
				        }
				
				        public class UtilityTopic
				        {
				            private string Name { get; }
				
				            public UtilityTopic(string name)
				            {
				                Name = name;
				            }
				
				            public string WaitForIntake { get => $"{Name}"; }
				        }
				    }
				}
			'''
		)
	}
}
