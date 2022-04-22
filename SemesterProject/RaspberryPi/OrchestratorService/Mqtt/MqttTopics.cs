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
            public string Name { get; }

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
            public string Name { get; }

            public DiskTopic(string name)
            {
                Name = name;
            }

            public string Slot { get => $"{Name}/slot"; }

            public string Moving { get => $"{Name}/moving"; }
        }

        public static CameraTopic Camera(string name)
        {
            return new CameraTopic(name);
        }

        public class CameraTopic
        {
            public string Name { get; }

            public CameraTopic(string name)
            {
                Name = name;
            }

            public string Scan { get => $"{Name}/command"; }

            public string Color { get => $"{Name}/result"; }

            public string Scanning { get => $"{Name}/scanning"; }
        }
    }
}
