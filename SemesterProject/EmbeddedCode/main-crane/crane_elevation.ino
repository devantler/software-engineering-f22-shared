//https://github.com/ivanseidel/LinkedList Info about linked list...
#include "crane_elevation.h"
#include <analogWrite.h>
#include <PID_v1.h>
#define M_PI 3.14159265358979323846

const int liftMotorPin1 = 14;
const int liftMotorPin2 = 12;
const int liftMotorEnablePin = 13;
const int photoResistorPin = 34;

const int MAX_MOTOR_POWER = 255;
const int MIN_MOTOR_POWER = 120;
const int MAX_SPEED = 100;
const int MIN_SPEED = 1;

const bool UP = true;
const bool DOWN = false;

int lastPhotoResistorVal = 0;
const int blackThreshold = 800;
const int whiteThreshold = 1200;

float distanceBetweenDiscAndCrane = 225; // in mm
float wheelDiameter = 12.3; //in mm
float wheelCircumference = wheelDiameter * M_PI; // in mm
float wheelStepCount = 12; 
//const int stepsToTake = ceil(distanceBetweenDiscAndCrane / (wheelCircumference / wheelStepCount)); // results in 70 stesp with 225 mm distance between disc and crane
const int stepsToTake = 62;

//PID
double Setpoint, Input, Output;
PID myPID(&Input, &Output, &Setpoint, 0.5, 0, 0, DIRECT);

void setupElevationControls()
{
    pinMode(liftMotorPin1, OUTPUT);
    pinMode(liftMotorPin2, OUTPUT);
    pinMode(liftMotorEnablePin, OUTPUT);
    //Arbitrary scaling of the end movement speed of the motor
    int speedSetpoint = 5; 
    //Calculate steps pr seconds  
    Setpoint = 52.0;//name should reflect that it is SPEEEEEED
    myPID.SetOutputLimits(MIN_MOTOR_POWER, MAX_MOTOR_POWER);
    myPID.SetMode(AUTOMATIC);
}

void setTunings(double p, double i, double d){
  myPID.SetTunings(p,i,d);
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
  int lastStepTime = millis();
  int msPerStep = 0;
  int lastMsPerStep = 0;
  int lastLastMsPerStep = 0;
  enableMotor(direction, MIN_MOTOR_POWER);
  while(stepsTaken < stepsToTake){
    //process steps
    if(processEncoder()){
      stepsTaken++;
      int newStepTime = millis();
      msPerStep = newStepTime - lastStepTime;
      lastStepTime = newStepTime;
      double speed;
      if(msPerStep == 0){
        speed = 0;
      }else{
        speed = 1000.0/((msPerStep + lastMsPerStep + lastLastMsPerStep)/3.0);
      }
      if(speed < MIN_SPEED){
        speed = MIN_SPEED;
      }
      lastLastMsPerStep = lastMsPerStep;
      lastMsPerStep = msPerStep;
      
      //Input = map(speed, MIN_SPEED, MAX_SPEED, 1, 100);
      Input = speed;
    }
    //run pid
    myPID.Compute();
    processMotorSpeed(direction);
  }
  disableMotor();
}

void processMotorSpeed(bool direction){
  int finalSpeed = Output;
  if(finalSpeed > MAX_MOTOR_POWER) {
    finalSpeed = MAX_MOTOR_POWER;
  } else if (finalSpeed < MIN_MOTOR_POWER ) {
    finalSpeed = MIN_MOTOR_POWER;
  }
  Serial.println(String(millis()) + "->" + "Input:" + String(Input) + ", Output: " + String(Output) + ", Motor power: " + String(finalSpeed));
  enableMotor(direction, finalSpeed);
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
