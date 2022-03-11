#include "crane.h"
#include "mqtt.h"
#include "wifi.h"

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
  else if (topicTemp = "crane/elevation")
  {
    publish((char*)"crane/moving", (char*)"1");
    toggleElevation(messageTemp.toInt());
    publish((char*)"crane/moving", (char*)"0");
  }
}

char *topics[] = {
    (char*)"crane/angle",
    (char*)"crane/elevation",
    (char*)"crane/magnet"
    };

int topicSize = 3;

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
}

void loop()
{
  mqttLoop();
  delay(1000);
}
