//From: https://randomnerdtutorials.com/esp32-mqtt-publish-subscribe-arduino-ide/
#ifndef mqtt_h
#define mqtt_h

#include "Arduino.h"

void setupMqtt(function* callback);
void reconnect(char* clientID);
void subscribe(char* topic);
void publish(char* topic, char* message);
#endif