#include "crane_elevation.h"
#include <analogWrite.h>

const int liftMotorPin1 = 2;
const int liftMotorPin2 = 3;
const int liftMotorEnablePin = 9;
const int photoResistorPin = 0;

int lastPhotoResistorVal;

int distanceBetweenDiscAndCrane = 30;
int wheelCircumference = 10;
int wheelStepSize = 4;

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
    enableMotor(true, 100);
    processSteps(stepsToTake);
    disableMotor();
}

void lower()
{
    int stepsToTake = ceil((float)(distanceBetweenDiscAndCrane / (wheelCircumference / wheelStepSize)));
    enableMotor(false, 100);
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
    while (stepsToTake != stepsTaken)
    {
        int currentPhotoResistorVal = analogRead(photoResistorPin);
        if (isSensingBlack(lastPhotoResistorVal) && isSensingWhite(currentPhotoResistorVal))
        {
            stepsTaken += 1;
        }
        lastPhotoResistorVal = currentPhotoResistorVal;
    }
}

bool isSensingBlack(int sensingVal)
{
    return sensingVal < 150;
};

bool isSensingWhite(int sensingVal)
{
    return sensingVal > 150;
};
