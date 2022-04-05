using System;
using System.Linq;

namespace CameraColorScanner.Helpers;

public class StringHelper
{
    private static Random random = new Random();
    public const string chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static string RandomString(int length)
    {
        return new string(Enumerable.Repeat(chars, length)
            .Select(s => s[random.Next(s.Length)]).ToArray());
    }
}