#include "Stepper.h"
#include "Arduino.h"

const int stepsPerRevolution = 20200; // TODO: the same as with crane motor? Also, is the moveDegrees() correct?
int currentAngle = 0;


Stepper revolutionStepper(stepsPerRevolution, 33, 32, 35, 34);

void setupDisk()
{
  revolutionStepper.setSpeed(4);
}

void gotoAngleDisk(int angle)
{
  if (angle > 359)
  {
    Serial.print("Angle is too large: " + angle);
    return;
  }
  if (angle < 0)
  {
    Serial.print("Angle is negative: " + angle);
    return;
  }
  int degreesToMove = (angle - currentAngle);

  moveDegreesDisk(degreesToMove);
  currentAngle = angle;
  delay(100);
  disableTurning();
}

// degrees between two angles
void moveDegreesDisk(int degrees)
{
  int stepsToGo = degrees * 112;
  revolutionStepper.step(stepsToGo);
}

void disableTurning()
{
  digitalWrite(8, LOW);
  digitalWrite(9, LOW);
  digitalWrite(10, LOW);
  digitalWrite(11, LOW);
}
