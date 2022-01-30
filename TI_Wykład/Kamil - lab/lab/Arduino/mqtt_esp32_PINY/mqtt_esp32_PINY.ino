/*
 Basic ESP8266 MQTT example
 This sketch demonstrates the capabilities of the pubsub library in combination
 with the ESP8266 board/library.
 It connects to an MQTT server then:
  - publishes "hello world" to the topic "outTopic" every two seconds
  - subscribes to the topic "inTopic", printing out any messages
    it receives. NB - it assumes the received payloads are strings not binary
  - If the first character of the topic "inTopic" is an 1, switch ON the ESP Led,
    else switch it off
 It will reconnect to the server if the connection is lost using a blocking
 reconnect function. See the 'mqtt_reconnect_nonblocking' example for how to
 achieve the same result without blocking the main loop.
 To install the ESP8266 board, (using Arduino 1.6.4+):
  - Add the following 3rd party board manager under "File -> Preferences -> Additional Boards Manager URLs":
       http://arduino.esp8266.com/stable/package_esp8266com_index.json
  - Open the "Tools -> Board -> Board Manager" and click install for the ESP8266"
  - Select your ESP8266 in "Tools -> Board"
*/

#include <WiFi.h>
#include <PubSubClient.h>

#define ledRed 15
#define ledYellow 4
#define ledGreen 16

#define ledX 13

int threshold = 40;


// Update these with values suitable for your network.

const char* ssid = "Uniwerek1";
const char* password = "morski111";
const char* mqtt_server = "lukan.sytes.net";

WiFiClient espClient;
PubSubClient client(espClient);
unsigned long lastMsg = 0;
#define MSG_BUFFER_SIZE	(50)
char msg[MSG_BUFFER_SIZE];
int value = 0;

void setup_wifi() {

  delay(10);
  // We start by connecting to a WiFi network
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);

  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  randomSeed(micros());

  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
}


String temat;

void callback(char* topic, byte* payload, unsigned int length) {
  Serial.print("Message arrived [");
  Serial.print(topic);
  Serial.print("] ");
  for (int i = 0; i < length; i++) {
    Serial.print((char)payload[i]);
  }
  Serial.println();

   temat = (String)topic;

  // Switch on the LED if an 1 was received as first character
  if ((char)payload[0] == '1') {
    digitalWrite(BUILTIN_LED, LOW);   // Turn the LED on (Note that LOW is the voltage level
    // but actually the LED is on; this is because
    // it is active low on the ESP-01)
  } else {
    digitalWrite(BUILTIN_LED, HIGH);  // Turn the LED off by making the voltage HIGH
  }
  if(temat == "/TITI/pomiary/pin32")
  if ((char)payload[0] == '0') {
    digitalWrite(ledRed, LOW);   // Turn the LED on (Note that LOW is the voltage level    
  } else {
    digitalWrite(ledRed, HIGH);  // Turn the LED off by making the voltage HIGH
  }

  if(temat == "/TITI/pomiary/pin36")
  if ((char)payload[0] == '0') {
    digitalWrite(ledYellow, LOW);   // Turn the LED on (Note that LOW is the voltage level    
  } else {
    digitalWrite(ledYellow, HIGH);  // Turn the LED off by making the voltage HIGH
  }

  if(temat == "/TITI/pomiary/pin37")
  if ((char)payload[0] == '0') {
    digitalWrite(ledGreen, LOW);   // Turn the LED on (Note that LOW is the voltage level    
  } else {
    digitalWrite(ledGreen, HIGH);  // Turn the LED off by making the voltage HIGH
  }

  if(temat == "/TITI/pomiary/pin12")
  {
 
  if ((char)payload[0] == '0') {
    digitalWrite(ledX, LOW);   // Turn the LED on (Note that LOW is the voltage level    
  } else {
    digitalWrite(ledX, HIGH);  // Turn the LED off by making the voltage HIGH
  }
  }
}

void reconnect() {
  // Loop until we're reconnected
  while (!client.connected()) {
    Serial.print("Attempting MQTT connection...");
    // Create a random client ID
    String clientId = "ESP8266Client-";
    clientId += String(random(0xffff), HEX);
    // Attempt to connect
    if (client.connect(clientId.c_str())) {
      Serial.println("connected");
      // Once connected, publish an announcement...
      client.publish("/test", "ESP32",true);
      // ... and resubscribe
      client.subscribe("/TITI/pomiary/pin32");
      client.subscribe("/TITI/pomiary/pin37");
      client.subscribe("/TITI/pomiary/pin36");
      client.subscribe("/TITI/pomiary/pin12");
    } else {
      Serial.print("failed, rc=");
      Serial.print(client.state());
      Serial.println(" try again in 5 seconds");
      // Wait 5 seconds before retrying
      delay(5000);
    }
  }
}

void setup() {
  pinMode(BUILTIN_LED, OUTPUT);     // Initialize the BUILTIN_LED pin as an output
  Serial.begin(115200);
  setup_wifi();
  client.setServer(mqtt_server, 1883);
  client.setCallback(callback);

  pinMode(ledGreen, OUTPUT);
  pinMode(ledYellow, OUTPUT);
  pinMode(ledRed, OUTPUT);
  pinMode(ledX, OUTPUT);  
  
}

boolean state12_ON = true;
boolean stateT6_ON = true;

void loop() {

  if (!client.connected()) {
    reconnect();
  }
  client.loop();

  int poziom = touchRead(T6);
  if(poziom < threshold) stateT6_ON = true; else stateT6_ON = false;
  if(stateT6_ON  && !state12_ON)
  {
    Serial.println("ON");
    state12_ON = true;
    client.publish("/TITI/pomiary/pin12", "1",true);
 
  }
  if(!stateT6_ON  && state12_ON)
  {
    Serial.println("OFF");
    state12_ON = false;
    client.publish("/TITI/pomiary/pin12", "0",true);
  }
  
  

}
