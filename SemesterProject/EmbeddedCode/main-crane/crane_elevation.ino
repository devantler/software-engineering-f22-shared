#include "crane_elevation.h"
#include <analogWrite.h>

const int liftMotorPin1 = 14;
const int liftMotorPin2 = 12;
const int liftMotorEnablePin = 13;
const int photoResistorPin = 34;

int lastPhotoResistorVal;

int distanceBetweenDiscAndCrane = 20;
int wheelCircumference = 15;
int wheelStepSize = 12;

void setupElevationControls()
{
    pinMode(liftMotorPin1, OUTPUT);
    pinMode(liftMotorPin2, OUTPUT);
    pinMode(liftMotorEnablePin, OUTPUT);
    lastPhotoResistorVal = analogRead(photoResistorPin);
}

void raise()
{
    int stepsToTake = ceil((float)(distanceBetweenDiscAndCrane / (wheelCircumference / wheelStepSize)));
    enableMotor(true, 255);
    processSteps(stepsToTake);
    disableMotor();
}

void lower()
{
    int stepsToTake = ceil((float)(distanceBetweenDiscAndCrane / (wheelCircumference / wheelStepSize)));
    enableMotor(false, 255);
    processSteps(stepsToTake);
    disableMotor();
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

void processSteps(int stepsToTake)
{
    int stepsTaken = 0;
    while (stepsToTake > stepsTaken)
    {
        int currentPhotoResistorVal = analogRead(photoResistorPin);
        if (isSensingBlack(lastPhotoResistorVal) && isSensingWhite(currentPhotoResistorVal))
        {
            stepsTaken += 1;
            Serial.print(stepsTaken);
        }
        if(isSensingWhite(lastPhotoResistorVal) && isSensingBlack(currentPhotoResistorVal)){
          stepsTaken += 1;
          Serial.print(stepsTaken);
        }
        lastPhotoResistorVal = currentPhotoResistorVal;
        //delay(50);
    }
}

bool isSensingBlack(int sensingVal)
{
    return sensingVal < 1000;
};

bool isSensingWhite(int sensingVal)
{
    return sensingVal > 1000;
};
