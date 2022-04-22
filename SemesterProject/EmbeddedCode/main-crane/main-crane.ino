#include "crane.h"
#include "mqtt.h"
#include "wifi.h"

char *topics[] = {
    (char *)"crane1/angle",
    (char *)"crane1/elevation",
    (char *)"crane1/magnet",
    (char *)"crane1/moving",
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
    publish(topics[3], (char *)"Moving");
    gotoAngle(messageTemp.toInt());
    publish(topics[3], (char *)"Stopped");
  }
  else if (topicTemp == topics[1])
  {
    publish(topics[3], (char *)"Moving");
    toggleElevation(messageTemp.toInt());
    publish(topics[3], (char *)"Stopped");
  }
  else if (topicTemp == topics[2])
  {
    int toggleVal = messageTemp.toInt();
    if(toggleVal == 1)
    {
      Serial.println("Magnet on");
    }
    else
    {
      Serial.println("Magnet off");
    }
    toggleMagnet(toggleVal);
  }
}

void setup()
{
  Serial.begin(9600);
  while (!Serial)
  {
    // Waiting until serial is connected
  };
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
