#ifndef crane_h
#define crane_h

#include "Arduino.h"

void setupCrane();
void gotoAngle(int angle);
void toggleMagnet(int powerOn);
void toggleElevation(int elevation);
#endif
