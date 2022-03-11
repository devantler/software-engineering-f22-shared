import machine
import utime
led = machine.Pin(16, machine.Pin.OUT)
conversion_factor = 3.3 / (65535)
sensor_temp = machine.ADC(4)
while True:
    led.toggle()
    reading = sensor_temp.read_u16() * conversion_factor
    temperature = 27 - (reading - 0.706)/0.001721
    print (temperature)
    utime.sleep(2.0)