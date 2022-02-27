#include <WiFi.h>
#include <PubSubClient.h>

// Add your MQTT Broker IP address, example:
// const char* mqtt_server = "192.168.1.144";
const char *mqtt_server = "YOUR_MQTT_BROKER_IP_ADDRESS";

WiFiClient espClient;
PubSubClient client(espClient);
long lastMsg = 0;
char msg[50];
int value = 0;

void setupMqtt(function *callback)
{
    client.setServer(mqtt_server, 1883);
    client.setCallback(callback);
}

void reconnect(char *clientID)
{
    // Loop until we're reconnected
    while (!client.connected())
    {
        Serial.print("Attempting MQTT connection...");
        // Attempt to connect
        if (client.connect(clientID))
        {
            Serial.println("connected");
        }
        else
        {
            Serial.print("failed, rc=");
            Serial.print(client.state());
            Serial.println(" try again in 5 seconds");
            // Wait 5 seconds before retrying
            delay(5000);
        }
    }

    void subscribe(char *topic)
    {
        Serial.println("Subscribing to:");
        Serial.println(topic);
        client.subscribe(topic);
    }

    void publish(char *topic, char *message)
    {
        Serial.println("Sending message:");
        Serial.println(message);
        Serial.println("On topic:");
        Serial.println(topic);
        client.publish(topic, message);
    }
}