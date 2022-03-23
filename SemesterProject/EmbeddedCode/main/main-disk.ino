#include "disk.h"
#include "mqtt.h"
#include "wifi.h"

char *topics[] = {
    (char *)"disk/zone"};

int topicSize = 1;
const int ZONES[] = {0, 45, 90, 135, 180, 225, 270, 315};

void callback(char *topic, byte *message, unsigned int length)
{
    String topicTemp = String(topic);
    String messageTemp;

    for (int i = 0; i < length; i++)
    {
        messageTemp += (char)message[i];
    }
    Serial.println("Received:");
    Serial.println(messageTemp);
    Serial.println("On topic:");
    Serial.println(topicTemp);

    if (topicTemp == "disk/zone")
    {
        gotoAngle(ZONES[messageTemp.toInt()]);
    }
}

void setup()
{
    Serial.begin(9600);
    while (!Serial)
    {
        //Waiting until serial is connected
    };
    Serial.println("Serial connected");
    initWiFi();
    setupMqtt();
    setupDisk();
}

void loop()
{
    mqttLoop((char *)"disk");

    delay(1000);
}
