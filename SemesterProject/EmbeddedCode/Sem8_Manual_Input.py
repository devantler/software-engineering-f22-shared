import paho.mqtt.client as c
import PySimpleGUI as sg
import time

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



if __name__ == "__main__":
    client = connect_mqtt()
    layout = [[sg.Button("done"), sg.Button("RED"), sg.Button("GREEN"), sg.Button("BLUE")]]
    window = sg.Window("Sem8 Manual Input", layout)
    while True:
        time.sleep(0.1)
        client.loop()
        event, values = window.read()
        if event == "done":
            client.reconnect()
            client.publish("intake", "done")
        elif event == "RED":
            client.reconnect()
            client.publish("camera1/result", "RED")
        elif event == "GREEN":
            client.reconnect()
            client.publish("camera1/result", "GREEN")
        elif event == "BLUE":
            client.reconnect()
            client.publish("camera1/result", "BLUE")
        elif event == sg.WIN_CLOSED:
            break
    window.close()