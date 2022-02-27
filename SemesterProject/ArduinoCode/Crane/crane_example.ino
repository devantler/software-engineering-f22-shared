#include <crane.h>

void setup()
{
  setupStepper();
}

void loop()
{
  gotoAngle(200);
  delay(300);
  gotoAngle(0);
}
