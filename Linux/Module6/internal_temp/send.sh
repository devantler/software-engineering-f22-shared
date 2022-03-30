testvar=$(/home/pi/software-engineering-f22/Linux/Module6/internal_temp/read.sh)
curl -so /dev/null -X POST https://api.thingspeak.com/update --data "api_key=Q3R9NV4X4N3BV5HQ&field1=$testvar" 
