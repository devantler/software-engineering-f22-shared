import paho.mqtt.client as mqtt
from influxdb import InfluxDBClient
import os
import json
import time

mqttbroker = os.environ['MQTT_HOST']
mqttport = int(os.environ['MQTT_PORT'])
client_id = "LogScoop"

influxdbhost = os.environ['INFLUXDB_HOST']
influxdbport = int(os.environ['INFLUXDB_PORT'])
influxdbdatabase = os.environ['INFLUXDB_DATABASE']
influxdbusername = os.environ['INFLUXDB_USERNAME']
influxdbpassword = os.environ['INFLUXDB_PASSWORD']


topics = json.loads(os.environ['topics'])

def connect_mqtt(influxdbclient: InfluxDBClient):
    def on_connect(client, userdata, flags, rc):
        if rc == 0:
            print("Connected to MQTT Broker!")
            subscribe(client, topics, influxdbclient)
        else:
            print("Failed to connect, return code %d\n", rc)
    client = mqtt.Client(client_id)
    client.on_connect = on_connect
    client.connect(mqttbroker, mqttport)
    return client

def subscribe(client: mqtt, _topics: list, influxdbclient: InfluxDBClient):
    def on_message(client, userdata, msg):
        message = msg.payload.decode()
        severity = msg.topic.split('/')[-1]
        device = "/".join(msg.topic.split('/')[1:-1])
        print(f"Received `{message}` from `{msg.topic}` topic")
        data = [{
            "measurement": "logs",
            "tags": {
                    "device": device, 
                    "severity": severity
            },
            "fields": {
                    "message": message,
            },
            "time": int(time.time() * 1000)
        }]
        influxdbclient.write_points(data, database=influxdbdatabase, time_precision='ms', batch_size=1, protocol='json')

    for topic in _topics:
        print(f"Subscribing to `{topic}` topic")
        client.subscribe(topic)
    client.on_message = on_message

print("Starting LogScooper...")
influxdbclient = InfluxDBClient(host=influxdbhost, port=influxdbport, username=influxdbusername, password=influxdbpassword)
influxdbclient.create_database(influxdbdatabase)

mqttclient = connect_mqtt(influxdbclient)
mqttclient.loop_forever()


