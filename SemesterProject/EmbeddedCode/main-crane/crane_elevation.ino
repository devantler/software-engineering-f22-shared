#include "crane_elevation.h"
#include <analogWrite.h>

const int liftMotorPin1 = 14;
const int liftMotorPin2 = 12;
const int liftMotorEnablePin = 13;
const int photoResistorPin = 34;

int lastPhotoResistorVal;
const int sensorValThreshold = 2000;

float distanceBetweenDiscAndCrane = 200; // in mm
float wheelCircumference = 141.37; // in mm
float wheelStepSize = 12;
const int stepsToTake = ceil(distanceBetweenDiscAndCrane / (wheelCircumference / wheelStepSize));

void setupElevationControls()
{
    pinMode(liftMotorPin1, OUTPUT);
    pinMode(liftMotorPin2, OUTPUT);
    pinMode(liftMotorEnablePin, OUTPUT);
    lastPhotoResistorVal = analogRead(photoResistorPin);
}

void raise()
{
    enableMotor(true, 225);
    processSteps(stepsToTake);
    disableMotor();
    lastPhotoResistorVal = analogRead(photoResistorPin);
}

void lower()
{
    enableMotor(false, 225);
    processSteps(stepsToTake);
    disableMotor();
    lastPhotoResistorVal = analogRead(photoResistorPin);
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
    while (stepsToTake <= stepsTaken)
    {
        int currentPhotoResistorVal = analogRead(photoResistorPin);
        if (isSteppingFromBlackToWhite(lastPhotoResistorVal, currentPhotoResistorVal) ||
            isSteppingFromWhiteToBlack(lastPhotoResistorVal, currentPhotoResistorVal))
        {
            stepsTaken++;
            Serial.println(stepsTaken);
            lastPhotoResistorVal = currentPhotoResistorVal;
        }
    }
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
    return sensingVal < 700;
};

bool isSensingWhite(int sensingVal)
{
    return sensingVal > 1800;
};
