#include "Stepper.h"
#include "Arduino.h"

const int stepsPerRevolution = 20200;

int currentAngle = 0;
int magnetPin = 10;

Stepper myStepper(stepsPerRevolution, 33, 32, 35, 34);

void setupCrane()
{
  myStepper.setSpeed(4);
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

void toggleMagnet(int power){
  if(power == 1){
    digitalWrite(magnetPin, HIGH);
  }else{
    digitalWrite(magnetPin, LOW);
  }
}

void moveDegrees(int degrees){
  if(degrees < -100 || degrees > 100){
    int splitDegrees = degrees / 3;
    myStepper.step(splitDegrees * 112);
    myStepper.step(splitDegrees * 112);
    myStepper.step((degrees - (2*splitDegrees)) * 112);
  }else{
    int stepsToGo = degrees * 112;
    myStepper.step(stepsToGo);
  }
}
