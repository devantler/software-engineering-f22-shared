#!/bin/bash

counter=0

while [ 1 ]
do
    sleep 1s
    result=$(sudo bash /home/pi/software-engineering-f22/Linux/Scripts/read_switch.sh)
    if [[ $result -eq 1 ]]; then 
        counter=$counter+1
    else
        counter=0 
    fi
    if [[ $counter -gt 3 ]]; then
        sudo shutdown now
    fi
done