// This Arduino example demonstrates bidirectional operation of a
// 28BYJ-48, using a ULN2003 interface board to drive the stepper.
// The 28BYJ-48 motor is a 4-phase, 8-beat motor, geared down by
// a factor of 68. One bipolar winding is on motor pins 1 & 3 and
// the other on motor pins 2 & 4. The step angle is 5.625/64 and the
// operating Frequency is 100pps. Current draw is 92mA.
////////////////////////////////////////////////

const int PIN1 = 32;
const int PIN2 = 33;
const int PIN3 = 25;
const int PIN4 = 26;

//declare variables for the motor pins
int motorPin1 = 32; // Blue – 28BYJ48 pin 1
int motorPin2 = 33; // Pink – 28BYJ48 pin 2
int motorPin3 = 25; // Yellow – 28BYJ48 pin 3
int motorPin4 = 26; // Orange – 28BYJ48 pin 4
// Red – 28BYJ48 pin 5 (VCC)

int motorSpeed = 1000; //variable to set stepper speed
int count = 0; // count of steps made
int countsperrev = 512; // number of steps per full revolution
int lookup[8] = {B01000, B01100, B00100, B00110, B00010, B00011, B00001, B01001};

bool direction = true;

//////////////////////////////////////////////////////////////////////////////
void setup() {
//declare the motor pins as outputs
pinMode(motorPin1, OUTPUT);
pinMode(motorPin2, OUTPUT);
pinMode(motorPin3, OUTPUT);
pinMode(motorPin4, OUTPUT);
Serial.begin(115200);
}

//////////////////////////////////////////////////////////////////////////////
void loop(){
  if(count < countsperrev){
    if(direction){
        clockwise();
    }
    else{
        anticlockwise();
    }
    count++;
  }
  else{
    count = 0;
    direction = !direction;
    off();
    delay(1000);
  }
}

//////////////////////////////////////////////////////////////////////////////
//set pins to ULN2003 high in sequence from 1 to 4
//delay “motorSpeed” between each pin setting (to determine speed)
void anticlockwise()
{
  for(int i = 0; i < 8; i++)
  {
    setOutput(i);
    delayMicroseconds(motorSpeed);
  }
}

void clockwise()
{
  for(int i = 7; i >= 0; i--)
  {
    setOutput(i);
    delayMicroseconds(motorSpeed);
  }
}

void setOutput(int out)
{
  digitalWrite(motorPin1, bitRead(lookup[out], 0));
  digitalWrite(motorPin2, bitRead(lookup[out], 1));
  digitalWrite(motorPin3, bitRead(lookup[out], 2));
  digitalWrite(motorPin4, bitRead(lookup[out], 3));
}
void off(){
  digitalWrite(motorPin1, 0);
  digitalWrite(motorPin2, 0);
  digitalWrite(motorPin3, 0);
  digitalWrite(motorPin4, 0);
}
