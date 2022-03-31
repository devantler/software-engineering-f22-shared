#include "Stepper.h"
#include "Arduino.h"

// Pins
const int stepperMotorPin1 = 32, stepperMotorPin2 = 33, stepperMotorPin3 = 25, stepperMotorPin4 = 26;

// Other variables
const int stepsPerRevolution = 20200;
int currentAngle = 0;


Stepper revolutionStepper(stepsPerRevolution, stepperMotorPin1, stepperMotorPin2, stepperMotorPin3, stepperMotorPin4);

void setup()
{
  revolutionStepper.setSpeed(4);
}

void loop(){
    gotoAngle(0);
    delay(5000);
    gotoAngle(359
    );
    delay(5000);
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
//   digitalWrite(8, LOW);
//   digitalWrite(9, LOW);
//   digitalWrite(10, LOW);
//   digitalWrite(11, LOW);
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
