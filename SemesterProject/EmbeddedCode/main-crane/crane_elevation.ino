#include "crane_elevation.h"
#include <analogWrite.h>
#include <LinkedList.h>

const int liftMotorPin1 = 14;
const int liftMotorPin2 = 12;
const int liftMotorEnablePin = 13;
const int photoResistorPin = 34;

const int MAX_MOTOR_POWER = 255;
const int MIN_MOTOR_POWER = 65;

const bool UP = true;
const bool DOWN = false;

int lastPhotoResistorVal = 0;
const int blackThreshold = 50;
const int whiteThreshold = 1200;

float distanceBetweenDiscAndCrane = 200; // in mm
float wheelCircumference = 141.37; // in mm
float wheelStepCount = 12; 



//PID
LinkedList<int> integratorValues;
LinkedList<int> integratorTimes;

const int PROPORTIONAL = 5; //Dingelphyrps
const int INTEGRATION_TIME = 250; //Milliseconds
int lastIntegrationTime = 0;



//const int stepsToTake = ceil(distanceBetweenDiscAndCrane / (wheelCircumference / wheelStepSize));
const int stepsToTake = 70
void setupElevationControls()
{
    pinMode(liftMotorPin1, OUTPUT);
    pinMode(liftMotorPin2, OUTPUT);
    pinMode(liftMotorEnablePin, OUTPUT);
    lastPhotoResistorVal = analogRead(photoResistorPin);
}

void raise()
{
//    enableMotor(true, 225);
//    processSteps(stepsToTake);
//    disableMotor();
//    lastPhotoResistorVal = analogRead(photoResistorPin);
  elevate(UP);
}

void lower()
{
//    enableMotor(false, 225);
//    processSteps(stepsToTake);
//    disableMotor();
//    lastPhotoResistorVal = analogRead(photoResistorPin);
}

void elevate(bool direction){
  int stepsTaken = 0;
  int speedSetpoint = 1; //Arbitrary scaling of the end movement speed of the motor
  int lastStepTime = millis();
  int msPerStep = 0;
  integratorValues = new LinkedList<int>();
  integratorTimes = new LinkedList<int>();
  while(stepsTaken < stepsToTake){
    //process steps
    if(processEncoder(stepsTaken){
      stepsTaken++;
      int newStepTime = millis();
      msPerStep = newStepTime - lastStepTime;
    }
    //run pid
    processMotorSpeed(direction, speedSetpoint, msPerStep)
  }
  disableMotor();
}

void processMotorSpeed(bool direction, int speedSetpoint, int msPerStep){
  //Calculate steps pr seconds
  int stepsPerSecondMeasured = floor(1000/msPerStep);
  
  int msSetpoint = map(speedSetpoint, 1, 5, 15, 30);//name should reflect that it is SPEEEEEED
  int newIntegrationTime = millis();
  if (newIntegrationTime - lastIntegrationTime >= 20){
    lastIntegrationTime = newIntegrationTime;
    
    integratorValues.add(msSetpoint-stepsPerSecondMeasured);
    integratorTimes.add(lastIntegratorTime);
  }
  //Remove old values from the integratorTimes
  //https://github.com/ivanseidel/LinkedList Info about linked list...
  
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
    if (isSteppingFromBlackToWhite(lastPhotoResistorVal, currentPhotoResistorVal) ||
        isSteppingFromWhiteToBlack(lastPhotoResistorVal, currentPhotoResistorVal))
    {
        lastPhotoResistorVal = currentPhotoResistorVal;
        return true;  
    }
    return false
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
