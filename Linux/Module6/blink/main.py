from machine import Pin
import utime

led = Pin(25, Pin.OUT)

while True:
    led.toggle()
    print ("hello world")
    utime.sleep(2.0)