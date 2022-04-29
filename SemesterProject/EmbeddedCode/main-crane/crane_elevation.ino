//https://github.com/ivanseidel/LinkedList Info about linked list...
#include "crane_elevation.h"
#include <analogWrite.h>
#include <LinkedList.h>
#define M_PI 3.14159265358979323846

const int liftMotorPin1 = 14;
const int liftMotorPin2 = 12;
const int liftMotorEnablePin = 13;
const int photoResistorPin = 34;

const int MAX_MOTOR_POWER = 255;
const int MIN_MOTOR_POWER = 70;

const bool UP = true;
const bool DOWN = false;

int lastPhotoResistorVal = 0;
const int blackThreshold = 800;
const int whiteThreshold = 1200;

float distanceBetweenDiscAndCrane = 225; // in mm
float wheelDiameter = 12.3; //in mm
float wheelCircumference = wheelDiameter * M_PI; // in mm
float wheelStepCount = 12; 
const int stepsToTake = 68;//ceil(distanceBetweenDiscAndCrane / (wheelCircumference / wheelStepCount)); // results in 70 stesp with 225 mm distance between disc and crane

//PID
LinkedList<int> integratorValues;
LinkedList<int> integratorTimes;

const int PROPORTIONAL = 1; //Dingelphyrps
const int INTEGRATION_TIME = 250; //Milliseconds
int lastIntegrationTime = 0;

void setupElevationControls()
{
    pinMode(liftMotorPin1, OUTPUT);
    pinMode(liftMotorPin2, OUTPUT);
    pinMode(liftMotorEnablePin, OUTPUT);
}

void raise()
{
      elevate(UP);
}

void lower()
{
      elevate(DOWN);
}

void elevate(bool direction){
  int stepsTaken = 0;
  int speedSetpoint = 5; //Arbitrary scaling of the end movement speed of the motor
  int lastStepTime = millis();
  int msPerStep = 0;
  LinkedList<int> *integratorValues = new LinkedList<int>();
  LinkedList<int> *integratorTimes = new LinkedList<int>();
  enableMotor(direction, MIN_MOTOR_POWER);
  while(stepsTaken < stepsToTake){
    //process steps
    if(processEncoder()){
      stepsTaken++;
      int newStepTime = millis();
      msPerStep = newStepTime - lastStepTime;
    }
    //run pid
    processMotorSpeed(direction, speedSetpoint, msPerStep);
  }
  disableMotor();
}

void processMotorSpeed(bool direction, int speedSetpoint, int msPerStep){
  //Calculate steps pr seconds
  int stepsPerSecondMeasured = 0;
  if(msPerStep > 0) {
      stepsPerSecondMeasured = floor(1000/msPerStep);
  }
  
  int msSetpoint = map(speedSetpoint, 1, 5, 15, 30);//name should reflect that it is SPEEEEEED
  int error = msSetpoint - stepsPerSecondMeasured;
  
  int integratedError = calculateIntegratedError(error);
  

  //proportional
  int proportionalError = PROPORTIONAL * error;

  // calculateSpeed
  int combinedError = proportionalError + integratedError;
  int finalSpeed = map(combinedError, -100, 100, MIN_MOTOR_POWER, MAX_MOTOR_POWER);
  
  if(finalSpeed > MAX_MOTOR_POWER) {
    finalSpeed = MAX_MOTOR_POWER;
  } else if (finalSpeed < MIN_MOTOR_POWER ) {
    finalSpeed = MIN_MOTOR_POWER;
  }
  Serial.println("Steps per second: " + String(stepsPerSecondMeasured) + ", motor power: " + String(finalSpeed) + " combinedError: " + String(combinedError));
  enableMotor(direction, finalSpeed);
}

int calculateIntegratedError(int error){
  int newIntegrationTime = millis();
  if (newIntegrationTime - lastIntegrationTime >= 20){
    lastIntegrationTime = newIntegrationTime;
    
    integratorValues.add(error);
    integratorTimes.add(lastIntegrationTime);
  }
  while ((newIntegrationTime - integratorTimes.get(0)) < INTEGRATION_TIME) {
    integratorValues.shift();
    integratorTimes.shift();
  }
  int integratedError = 0;
  for (int i = 0; i < integratorValues.size(); i++) {
    integratedError += integratorValues[i];
  }
  return integratedError;
}


void enableMotor(bool direction, uint8_t speed)
{
  if (direction)
  {
      analogWrite(liftMotorEnablePin, speed);
      digitalWrite(liftMotorPin1, LOW);
      digitalWrite(liftMotorPin2, HIGH);
  }
  else
  {
      analogWrite(liftMotorEnablePin, speed);
      digitalWrite(liftMotorPin1, HIGH);
      digitalWrite(liftMotorPin2, LOW);
  }
}

void disableMotor()
{
    analogWrite(liftMotorEnablePin, 0);
    digitalWrite(liftMotorPin1, LOW);
    digitalWrite(liftMotorPin2, LOW);
}

bool processEncoder()
{
    int currentPhotoResistorVal = analogRead(photoResistorPin);
    //Serial.println("sensor val: " + String(currentPhotoResistorVal));
    if (isSteppingFromBlackToWhite(lastPhotoResistorVal, currentPhotoResistorVal) ||
        isSteppingFromWhiteToBlack(lastPhotoResistorVal, currentPhotoResistorVal))
    {
        lastPhotoResistorVal = currentPhotoResistorVal;
        return true;  
    }
    return false;
}
    

bool isSteppingFromBlackToWhite(int lastPhotoResistorVal, int currentPhotoResistorVal)
{
    return isSensingBlack(lastPhotoResistorVal) && isSensingWhite(currentPhotoResistorVal);
}

bool isSteppingFromWhiteToBlack(int lastPhotoResistorVal, int currentPhotoResistorVal)
{
    return isSensingWhite(lastPhotoResistorVal) && isSensingBlack(currentPhotoResistorVal);
}

bool isSensingBlack(int sensingVal)
{
    return sensingVal < blackThreshold;
};

bool isSensingWhite(int sensingVal)
{
    return sensingVal > whiteThreshold;
};
