namespace Mqtt
{
    public class MqttTopics
    {
        public class Crane
        {
            private static string parentName = "crane";

            public static string Angle = $"{parentName}/angle";
            public static string Elevation = $"{parentName}/elevation";
            public static string Moving = $"{parentName}/moving";
            public static string Magnet = $"{parentName}/magnet";
        }

        public class Disk
        {
            private static string parentName = "disk";

            public static string Zone = $"{parentName}/zone";
        }
    }
}
