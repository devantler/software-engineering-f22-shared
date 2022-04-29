#include "disk.h"
#include "mqtt.h"
#include "wifi.h"

char *topics[] = {
    (char *)"disk1/zone",
    (char *)"disk1/moving",};

int topicSize = 1;


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

    if (topicTemp == topics[0])
    {
        publish(topics[1], (char*)"Moving");
        gotoZone(messageTemp.toInt());
        publish(topics[1], (char*)"Stopped");
    }
}

void setup()
{
    Serial.begin(115200);
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
