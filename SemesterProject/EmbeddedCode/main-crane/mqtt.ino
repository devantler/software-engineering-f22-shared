#include <WiFi.h>
#include <PubSubClient.h>

// Add your MQTT Broker IP address, example:
// const char* mqtt_server = "192.168.1.144";
const char *mqtt_server = "192.168.10.1";

WiFiClient espClient;
PubSubClient client(espClient);
long lastMsg = 0;
char msg[50];
int value = 0;
//typedef void (*Callback) (char* topic, byte* message, unsigned int length);

void setupMqtt()
{
    client.setServer(mqtt_server, 1883);
    client.setCallback(callback);
    subscribeMQTT();
    if (!client.connected()) {
    reconnect("crane1");
    }
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
            subscribeMQTT();
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
}

void mqttLoop(char* device){
  if (!client.connected()) {
    reconnect(device);
  }
  client.loop();
}

void subscribeMQTT()
{
    Serial.println(topicSize);
    for(int i = 0; i < topicSize; i++){
      char* topic = topics[i];
      Serial.println("Subscribing to:");
      Serial.println(topic);
      client.subscribe(topic);
    }
}

void publish(char *topic, char *message)
{
    Serial.println("Sending message:");
    Serial.println(message);
    Serial.println("On topic:");
    Serial.println(topic);
    client.publish(topic, message, true);
}
