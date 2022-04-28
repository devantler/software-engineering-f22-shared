#ifndef disk_h
#define disk_h

#include "Arduino.h"

void setupDisk();
void gotoAngle(int angle);
void toggleMagnet(int powerOn);
void toggleElevation(int elevation);
#endif
