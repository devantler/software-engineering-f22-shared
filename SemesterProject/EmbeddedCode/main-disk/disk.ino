#include "Stepper.h"
#include "Arduino.h"

int currentAngle = 0;

const int PIN1 = 32;
const int PIN2 = 33;
const int PIN3 = 25;
const int PIN4 = 26;

int zoneCount = 8;
int rpm = 3;
int stepsPerRevolution = 512*8;
int interStepDelay = 1000;//1/((rpm*stepsPerRevolution/(10^6*60))); //Results in microsecond delay

int coilStateLookup[8] = {B01000, B01100, B00100, B00110, B00010, B00011, B00001, B01001};

int currentStep = 0;

void setupDisk(){
  Serial.println("Disk - SetupDisk");
  pinMode(PIN1, OUTPUT);
  pinMode(PIN2, OUTPUT);
  pinMode(PIN3, OUTPUT);
  pinMode(PIN4, OUTPUT);
}

void gotoZone(int zone){
  Serial.println("Disk - Goto Zone: " + String(zone));
  int targetStep = (stepsPerRevolution/zoneCount*zone);
  //int stepsToMove = targetStep - currentStep;
  Serial.println("Disk - targetStep: " + String(targetStep));
  while(targetStep != currentStep){
    stepClockwise();
  }
  //End with disable turning
  disableTurning(); 
}

void disableTurning()
{
  digitalWrite(PIN1, LOW);
  digitalWrite(PIN2, LOW);
  digitalWrite(PIN3, LOW);
  digitalWrite(PIN4, LOW);
}

void stepClockwise(){
  Serial.println("Disk - Step Clockwiser, CurrentStep: " + String(currentStep));
  currentStep++;
  currentStep = currentStep % stepsPerRevolution;
  setOutput((zoneCount-1)-currentStep%zoneCount);
  delayMicroseconds(interStepDelay);
}

//void stepAntiClockwise(){
//  currentStep--;
//  setOutput(currentStep%8);
//}

void setOutput(int out)
{
  digitalWrite(PIN1, bitRead(coilStateLookup[out], 0));
  digitalWrite(PIN2, bitRead(coilStateLookup[out], 1));
  digitalWrite(PIN3, bitRead(coilStateLookup[out], 2));
  digitalWrite(PIN4, bitRead(coilStateLookup[out], 3));
}
