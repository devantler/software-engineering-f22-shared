echo "26" > /sys/class/gpio/export
echo "out" > /sys/class/gpio/gpio26/direction
touch /home/pi/software-engineering-f22/Linux/Scripts/led_running
while [[ -f /home/pi/software-engineering-f22/Linux/Scripts/led_running ]]
do
    echo "1" > /sys/class/gpio/gpio26/value
    sleep 1s
    echo "0" > /sys/class/gpio/gpio26/value
    sleep 1s
done
echo "26" > /sys/class/gpio/unexport