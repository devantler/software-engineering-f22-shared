namespace Domain
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

        public class Disc
        {
            private static string parentName = "disc";

            public static string Slot = $"{parentName}/zone";
            public static string Moving = $"{parentName}/moving";
        }
    }
}