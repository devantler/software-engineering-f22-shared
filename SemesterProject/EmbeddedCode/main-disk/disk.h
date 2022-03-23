#ifndef crane_h
#define crane_h

#include "Arduino.h"

void setupDisk();
void gotoAngleDisk(int angle);
void toggleMagnet(int powerOn);
void toggleElevation(int elevation);
#endif
