#!/usr/bin/env python3
PIN_SERVO = 3

import RPi.GPIO as GPIO
from time import sleep

GPIO.setmode(GPIO.BOARD)
GPIO.setup(PIN_SERVO, GPIO.OUT)
pwm=GPIO.PWM(PIN_SERVO, 50) # 50 Hz
pwm.start(0)
def servo_angle(servo_angle):
    duty = servo_angle / 18 + 2
    GPIO.output(PIN_SERVO, True)
    pwm.ChangeDutyCycle(duty)
    sleep(1)
    GPIO.output(PIN_SERVO, False)
    pwm.ChangeDutyCycle(0)
def servo_stop():
    pwm.stop()
    GPIO.cleanup()
servo_angle (0)
sleep (1)
servo_angle (90)
sleep (1)
servo_angle (180)
servo_stop()