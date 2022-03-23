//From: https://randomnerdtutorials.com/esp32-mqtt-publish-subscribe-arduino-ide/
#ifndef mqtt_h
#define mqtt_h

#include "Arduino.h"

void setupMqtt();
void reconnect(char* clientID);
void mqttLoop(char* device);
void publish(char* topic, char* message);
#endif
