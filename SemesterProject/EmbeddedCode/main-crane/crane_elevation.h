#ifndef crane_elevation_h
#define crane_elevation_h
#include "Arduino.h"

void setupElevationControls();
void setTunings(double p, double i, double d);
void raise();
void lower();
#endif
