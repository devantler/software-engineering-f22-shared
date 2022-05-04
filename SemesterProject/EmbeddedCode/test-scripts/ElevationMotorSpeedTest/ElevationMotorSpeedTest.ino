#include <analogWrite.h>

const int liftMotorPin1 = 14;
const int liftMotorPin2 = 12;
const int liftMotorEnablePin = 13;
const int photoResistorPin = 34;

const int blackThreshold = 800;
const int whiteThreshold = 1200;

//float distanceBetweenDiscAndCrane = 100; // in mm
//float wheelCircumference = 141.37; // in mm
//float wheelStepCount = 12;
//const int stepsToTake = ceil(distanceBetweenDiscAndCrane / (wheelCircumference / wheelStepCount));
int lastPhotoResistorVal = 0;
int targetSpeed = 70;

void setup() {
  Serial.begin(115200);
  while (!Serial)
  {
    // Waiting until serial is connected
  };
  Serial.println("Serial connected");
  Serial.println("How fast(enter for default): ");
  while(true){
    String input = Serial.readString();
    if(input.length() < 1){
      continue;
    }
    if(input.toInt() == 0){
      break;
    }
    targetSpeed = input.toInt();
    Serial.println("Target speed: " + String(targetSpeed));
    if(targetSpeed > 0 && targetSpeed <= 255){
      break;
    }
  }  
  pinMode(liftMotorPin1, OUTPUT);
  pinMode(liftMotorPin2, OUTPUT);
  pinMode(liftMotorEnablePin, OUTPUT);

  //enableMotor(true, 70);
  //while(isSensingBlack(analogRead(photoResistorPin)) || isSensingWhite(analogRead(photoResistorPin))){
  //    disableMotor();
  //    break;
  //}
}

void loop() {
  int numberOfSteps;
  bool selectedDirection;
  String selectedDirectionString;
  Serial.println("Which direction and how far(u55 || d45): ");
  while(true){
    String input = Serial.readString();
    selectedDirectionString = input.substring(0,1);
    if(input.length() < 2){
      //Serial.println("Invalid input must start with u or d and end with a number of steps i.e. u65");
      continue;
    }
    if(selectedDirectionString == "u"){
      selectedDirection = true;
    }else if(selectedDirectionString == "d"){
      selectedDirection = false;
    }else{
      Serial.println("Invalid input must start with u or d and end with a number of steps i.e. u65");
      continue;
    }
    
    numberOfSteps = input.substring(1, input.length()-1).toInt();
      
    Serial.println("Input: "+ input);
    Serial.println("Target speed: " + String(targetSpeed) + ", Target direction: " + selectedDirectionString + ", Target steps: " + String(numberOfSteps));
    if(targetSpeed > 0 && targetSpeed <= 255){
      break;
    }
  } 

  int stepsTaken = 0;
  int oldTime = 0;
  int startTimeMotor = millis();
  enableMotor(selectedDirection, targetSpeed);
  while(stepsTaken <= numberOfSteps){
    if(checkSteps()){
      int newTime = millis();
      stepsTaken++;
      int timeTaken = newTime - oldTime;
      Serial.println("steps: " + String(stepsTaken) + ", time:" + String(timeTaken) + ", speed: " + String(floor(1000/timeTaken)));
      oldTime = newTime;   
    }
  }
  disableMotor();
  Serial.println("Time for excecution: " + String(millis() - startTimeMotor));
}

bool checkSteps() {
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
