#include <Stepper.h>

const int stepsPerRevolution = 20200;  // change this to fit the number of steps per revolution
// for your motor

int currentAngle = 0;
// initialize the stepper library on pins 8 through 11:
Stepper myStepper(stepsPerRevolution, 8, 9, 10, 11);

void setupStepper() {
  myStepper.setSpeed(4);
}

void gotoAngle(int angle) {
  if(angle > 359){
    Serial.print("Angle is too large: " + angle);
    return;
  }
  if(angle < 0){
    Serial.print("Angle is negative: " + angle);
    return;
  }

  int stepsToGo = (angle - currentAngle) * 112;

  myStepper.step(-stepsToGo);
  delay(100);

  digitalWrite(8, LOW);
  digitalWrite(9, LOW);
  digitalWrite(10, LOW);
  digitalWrite(11, LOW);
}
