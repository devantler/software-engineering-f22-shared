namespace CameraColorScanner
{
    public class Configuration
    {
        public class Mqtt
        {
            public static string Hostname = "mqtt";
            public static int Port = 1883;
            public static string ClientId = "CameraColorScanner";
            public static string CommandTopic = "sorter/scanner/1/command";
            public static string ResultTopic = "sorter/scanner/1/result";
            public static string LogTopic = "sorter/scanner/1/log";
            public static bool UseSsl = false;
            public static bool PrintDebug = true;
            public static string? Username = null;
            public static string? Password = null;
        }

        public class Camera
        {
            public class Crop
            {
                public static int x = 320;
                public static int y = 180;
                public static int Width = 640;
                public static int Height = 360;
            }
        }
    }
}