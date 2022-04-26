#include "crane.h"
#include "mqtt.h"
#include "wifi.h"

char *topics[] = {
    (char *)"crane/angle",
    (char *)"crane/elevation",
    (char *)"crane/magnet",
    (char *)"crane/moving",
};

int topicSize = 3;

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
    publish(topics[3], "Moving");
    gotoAngle(messageTemp.toInt());
    publish(topics[3], "Stopped");
  }
  else if (topicTemp == topics[1]])
  {
    publish(topics[3], "Moving");
    toggleMagnet(messageTemp.toInt());
    publish(topics[3], "Stopped");
  }
  else if (topicTemp == topics[2])
  {
    publish(topics[3], "Moving");
    toggleElevation(messageTemp.toInt());
    publish(topics[3], "Stopped");
  }
}

void setup()
{
  Serial.begin(9600);
//  while (!Serial)
//  {
//    // Waiting until serial is connected
//  };
  Serial.println("Serial connected");
  initWiFi();
  setupMqtt();
  setupCrane();
}

void loop()
{
  mqttLoop((char *)"crane");

  delay(1000);
}
