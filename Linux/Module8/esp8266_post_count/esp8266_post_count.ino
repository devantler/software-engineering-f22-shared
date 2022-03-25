
// Wifi
#include <ESP8266WiFi.h>
#include <ESP8266WiFiMulti.h>
#include <ESP8266HTTPClient.h>

const char* WIFI_SSID = "LEO1_TEAM_09";
const char* WIFI_PASSWORD = "embeddedlinux";

ESP8266WiFiMulti WiFiMulti;

// Counter
#define GPIO_INTERRUPT_PIN 4
#define DEBOUNCE_TIME 200 // milliseconds

volatile unsigned long count_prev_time;
volatile unsigned long count;

// POST
#define POST_URL "http://192.168.10.1/log.php"
#define POST_INTERVAL 15000 // milliseconds
unsigned long prev_post_time;
char post_str[50];

// debug
#define DEBUG_INTERVAL 1000
unsigned long prev_debug_time;


ICACHE_RAM_ATTR void count_isr()
{
  if (count_prev_time + DEBOUNCE_TIME < millis() || count_prev_time > millis())
  {
    count_prev_time = millis(); 
    count++;
  }
}

void setup()
{
  // count
  count_prev_time = millis();
  count = 0;
  pinMode(GPIO_INTERRUPT_PIN, INPUT_PULLUP);
  attachInterrupt(digitalPinToInterrupt(GPIO_INTERRUPT_PIN), count_isr, RISING);

  // serial
  Serial.begin(115200);
  delay(10);
  // We start by connecting to a WiFi network
  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(WIFI_SSID);

  // wifi
    /* Explicitly set the ESP8266 to be a WiFi-client, otherwise, it by default,
       would try to act as both a client and an access-point and could cause
       network-issues with your other WiFi-devices on your WiFi-network. */
  WiFi.mode(WIFI_STA);
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
}

void post_data()
{
   sprintf (post_str, "log=%lu" , count);
   Serial.println(post_str);
   count = 0;
  // wait for WiFi connection   
  if((WiFiMulti.run() == WL_CONNECTED))
  {
    Serial.print("connecting");

    WiFiClient client;
    HTTPClient http;
    http.begin(client, POST_URL);
    http.addHeader("Content-Type", "application/x-www-form-urlencoded");
    http.POST(post_str);
    String payload = http.getString();
    http.end();
    
    Serial.print("[HTTP] result: ");
    Serial.print(payload);
    Serial.print("\n");
  }
}

void loop()
{
    if (millis() - prev_post_time >= POST_INTERVAL)
    {
      prev_post_time = millis();
      long start_time = millis();
      post_data();
      long stop_time = millis();
      Serial.print("I am postdatatime: ");
      Serial.println(stop_time-start_time);
    }
   
    if (millis() - prev_debug_time >= DEBUG_INTERVAL)
    {
      prev_debug_time = millis();
      Serial.println(count);
    }
}
