using System;
using System.Linq;

namespace CameraColorScanner.Helpers;

public class LoggingHelper
{
    public enum LoggingLevel
    {
        INFO,
        ERROR
    }

    public static LoggingLevel loggingLevel = LoggingLevel.ERROR;

}

