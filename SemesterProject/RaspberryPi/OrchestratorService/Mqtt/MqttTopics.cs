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
