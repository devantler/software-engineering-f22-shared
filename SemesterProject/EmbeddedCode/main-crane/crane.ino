#include "Stepper.h"
#include "Arduino.h"
#include "crane_elevation.h"

// Pins
const int magnetPin = 2;
const int stepperMotorPin1 = 35, stepperMotorPin2 = 32, stepperMotorPin3 = 33, stepperMotorPin4 = 25;

// Other variables
const int stepsPerRevolution = 20200;
int currentAngle = 0;


Stepper revolutionStepper(stepsPerRevolution, stepperMotorPin1, stepperMotorPin2, stepperMotorPin3, stepperMotorPin4);

void setupCrane()
{
  revolutionStepper.setSpeed(4);
  setupElevationControls();
  pinMode(magnetPin, OUTPUT);
}

void gotoAngle(int angle)
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

  moveDegrees(degreesToMove);
  currentAngle = angle;
  delay(100);
  digitalWrite(8, LOW);
  digitalWrite(9, LOW);
  digitalWrite(10, LOW);
  digitalWrite(11, LOW);
}

void toggleMagnet(int powerOn)
{
  if (powerOn == 1)
  {
    digitalWrite(magnetPin, HIGH);
  }
  else
  {
    digitalWrite(magnetPin, LOW);
  }
}

void moveDegrees(int degrees)
{
  if (degrees < -100 || degrees > 100)
  {
    int splitDegrees = degrees / 3;
    revolutionStepper.step(splitDegrees * 112);
    revolutionStepper.step(splitDegrees * 112);
    revolutionStepper.step((degrees - (2 * splitDegrees)) * 112);
  }
  else
  {
    int stepsToGo = degrees * 112;
    revolutionStepper.step(stepsToGo);
  }
}

void toggleElevation(int direction)
{
  if (direction == 1)
  {
    raise();
  }
  else
  {
    lower();
  }
}
