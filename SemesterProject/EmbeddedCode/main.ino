#include "crane.h"
#include "disk.h"
#include "Common/mqtt.h"
#include "Common/wifi.h"

char *topics[] = {
    (char*)"crane/angle",
    (char*)"crane/elevation",
    (char*)"crane/magnet",
    (char*)"disk/zone"
    };

int topicSize;
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

  if (topicTemp == "crane/angle")
  {
    gotoAngle(messageTemp.toInt());
  }
  else if (topicTemp == "crane/magnet")
  {
    toggleMagnet(messageTemp.toInt());
  }
  else if (topicTemp == "crane/elevation")
  {
    publish((char*)"crane/moving", (char*)"1");
    toggleElevation(messageTemp.toInt());
    publish((char*)"crane/moving", (char*)"0");
  }
  else if (topicTemp == "disk/zone")
  {
    gotoAngle(ZONES[messageTemp.toInt()]); // Zone 0 is the first zone
  }
}

void setup()
{
  Serial.begin(9600);
  while (!Serial)
  {
  };
  Serial.println("Serial connected");
  initWiFi();
  setupMqtt();
  setupCrane();
  setupDisk();
}

void loop()
{
  topicSize = 3;
  mqttLoop("crane");

  topicSize = 1;
  mqttLoop("disk");

  delay(1000);
}
