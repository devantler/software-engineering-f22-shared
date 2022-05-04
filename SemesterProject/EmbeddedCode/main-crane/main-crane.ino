#include "crane.h"
#include "mqtt.h"
#include "wifi.h"

char *topics[] = {
    (char *)"crane1/angle",
    (char *)"crane1/elevation",
    (char *)"crane1/magnet",
    (char *)"crane1/moving",
    (char *)"crane1/p",
    (char *)"crane1/i",
    (char *)"crane1/d",
};

double p = 0.35;
double i = 0.80;
double d = 0;
int topicSize = 7;

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
    publish(topics[3], (char*)"Moving");
    gotoAngle(messageTemp.toInt());
    publish(topics[3], (char*)"Stopped");
  }
  else if (topicTemp == topics[1])
  {
    publish(topics[3], (char*)"Moving");
    toggleElevation(messageTemp.toInt());
    publish(topics[3], (char*)"Stopped");
  }
  else if (topicTemp == topics[2])
  {
    publish(topics[3], (char*)"Moving");
    toggleMagnet(messageTemp.toInt());
    publish(topics[3], (char*)"Stopped");
  }else if (topicTemp == topics[4]){
    p = messageTemp.toDouble();
    setTunings(p,i,d);
  }else if (topicTemp == topics[5]){
    i = messageTemp.toDouble();
    setTunings(p,i,d);
  }else if (topicTemp == topics[6]){
    d = messageTemp.toDouble();
    setTunings(p,i,d);
  }
}

void setup()
{
  Serial.begin(115200);
//  while (!Serial)
//  {
//    // Waiting until serial is connected
//  };
  Serial.println("Serial connected");
  initWiFi();
  setupMqtt();
  setupCrane();
  publish(topics[3], (char*)"Stopped");
 }

void loop()
{
  mqttLoop((char *)"crane");

  delay(100);
}
