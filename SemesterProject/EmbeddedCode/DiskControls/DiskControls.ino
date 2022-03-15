#include "disk.h"
#include "../Common/mqtt.h"
#include "../Common/wifi.h"

const int ZONES[] = { 0, 45, 90, 135, 180, 225, 270, 315 };

void callback(char* topic, byte *message, unsigned int length)
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
    gotoAngle(ZONES[messageTemp.toInt()]); // Zone 0 is the first zone
  }
}

char *topics[] = {
    (char*)"disk/zone",
    };

int topicSize = 1;

void setup()
{
  Serial.begin(9600);
  while (!Serial)
  {
  };
  Serial.println("Serial connected");
  initWiFi();
  setupMqtt();
  setupDisk();
}

void loop()
{
  mqttLoop("disk");
  delay(1000);
}
