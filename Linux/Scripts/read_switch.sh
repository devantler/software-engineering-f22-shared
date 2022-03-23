echo "16" > /sys/class/gpio/export
echo "in" > /sys/class/gpio/gpio16/direction
cat /sys/class/gpio/gpio16/value
echo "16" > /sys/class/gpio/unexport