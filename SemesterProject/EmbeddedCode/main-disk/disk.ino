#include "Stepper.h"
#include "Arduino.h"

const int stepsPerRevolution = 512; // TODO: the same as with crane motor? Also, is the moveDegrees() correct?
int currentAngle = 0;

const int PIN1 = 32;
const int PIN2 = 33;
const int PIN3 = 25;
const int PIN4 = 26;


Stepper revolutionStepper(stepsPerRevolution, PIN1, PIN2, PIN3, PIN4);

void setupDisk()
{
  revolutionStepper.setSpeed(20);
}

void gotoAngle(int angle)
{
//  if (angle > 359)
//  {
//    Serial.print("Angle is too large: " + angle);
//    return;
//  }
//  if (angle < 0)
//  {
//    Serial.print("Angle is negative: " + angle);
//    return;
//  }
  angle = angle % 360
  int degreesToMove = (angle - currentAngle);

  moveDegreesDisk(degreesToMove);
  currentAngle = angle;
  delay(100);
  disableTurning();
}

// degrees between two angles
void moveDegreesDisk(int degrees)
{
  int stepsToGo = floor(degrees * 1.42);
  revolutionStepper.step(stepsToGo);
}

void disableTurning()
{
  digitalWrite(PIN1, LOW);
  digitalWrite(PIN2, LOW);
  digitalWrite(PIN3, LOW);
  digitalWrite(PIN4, LOW);
}
