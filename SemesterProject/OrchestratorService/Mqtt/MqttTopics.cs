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
