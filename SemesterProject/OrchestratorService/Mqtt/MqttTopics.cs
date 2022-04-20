namespace Mqtt
{
    public static class MqttTopics
    {
        public static class Crane
        {
            const string parentName = "crane";
            public const string Angle = $"{parentName}/angle";
            public const string Elevation = $"{parentName}/elevation";
            public const string Moving = $"{parentName}/moving";
            public const string Magnet = $"{parentName}/magnet";
        }

        public static class Disk
        {
            public const string parentName = "disk";
            public const string Slot = $"{parentName}/slot";
            public const string Zone = $"{parentName}/zone";
            public const string Moving = $"{parentName}/moving";
        }
    }
}
