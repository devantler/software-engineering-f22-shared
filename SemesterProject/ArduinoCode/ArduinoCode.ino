//#include <crane.h>
#include "mqtt.h"
#include "wifi.h"



void callback(char* topic, byte* message, unsigned int length) {
  String messageTemp;
  
  for (int i = 0; i < length; i++) {
    messageTemp += (char)message[i];
  }
  Serial.println("Received:");
  Serial.println(messageTemp);
  Serial.println("On topic:");
  Serial.println(topic);
}

char* topics[] = {
    "crane/angle",
    "crane/elevation",
    "crane/magnet"
};

int topicSize = 3;


void setup()
{
  Serial.begin(9600);
  while(!Serial){};
  Serial.println("Serial connected");
  initWiFi();
  
  setupMqtt();
  //setupStepper();
}

void loop()
{
  mqttLoop();
  //gotoAngle(200);
  //delay(300);
  //gotoAngle(0);
  publish("crane/angle", "10");
  delay(1000);
}
