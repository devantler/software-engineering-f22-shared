import paho.mqtt.client as c
broker = '10.0.0.10'
port = 1883
topic = 'crane1/elevation'
client_id = 'thonny'
state = True

def connect_mqtt():
    def on_connect(client, userdata, flags, rc):
        if rc == 0:
            print("Connected to MQTT Broker!")
        else:
            print("Failed to connect, return code %d\n", rc)
    # Set Connecting Client ID
    client = c.Client(client_id)
    client.on_connect = on_connect
    client.connect(broker, port)
    return client

client = connect_mqtt()

while True:
    input()
    state=not state
    print(f"sending {state}")
    client.publish(topic,str(int(state)))