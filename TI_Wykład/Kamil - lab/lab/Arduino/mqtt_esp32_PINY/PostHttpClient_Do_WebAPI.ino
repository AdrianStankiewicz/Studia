/**
   Na podstawie przykładu:   
   PostHTTPClient.ino Created on: 21.11.2016
*/

#include <WiFi.h>
#include <HTTPClient.h>
#include "esp_wpa2.h"
#include <Arduino_JSON.h>

#ifndef STASSID
#define STASSID "????????"	// Sieć
#define STAPSK  "????????"      // Hasło
#endif

String AUTHOR = "????????";
String GAGE = "Mierniczek";
int MeasurementId;

#define MSG_BUFFER_SIZE  (60)
char msg[MSG_BUFFER_SIZE];

void setup() {
  Serial.begin(115200);
  Serial.println();
  WiFi.begin(STASSID, STAPSK);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected! IP address: ");
  Serial.println(WiFi.localIP());

  WiFiClient client;
  HTTPClient http;
  http.begin(client, "http://argo.am.gdynia.pl/www/RestWebApi/api/Measurements/"); //HTTP
  http.addHeader("Content-Type", "application/json"); //Nagłówek
  int httpCode = http.POST("{\"Author\": \"" + AUTHOR + "\", \"Gage\": \"" + GAGE + "\"}"); // Żądanie POST  
  Serial.printf("[HTTP] POST... code: %d\n", httpCode); // Otrzymany kod statusu
  const String& payload = http.getString();
  Serial.println(payload);

  JSONVar myObject = JSON.parse(payload); // Zamiana tekstu na obiekt JSON  
      if (JSON.typeof(myObject) == "undefined") {
        Serial.println("Parsing input failed!");
        return;
      }
    
   Serial.print("JSON object = ");
   Serial.println(myObject);       
   Serial.print("MeasurementId = ");
   Serial.println(myObject["MeasurementId"]);
   MeasurementId = myObject["MeasurementId"]; 
   http.end();
}

void loop() {
  // wait for WiFi connection
  if ((WiFi.status() == WL_CONNECTED)) {

    WiFiClient client;
    HTTPClient http;

    Serial.print("[HTTP] begin...");
    // configure traged server and url
    http.begin(client, "http://argo.am.gdynia.pl/www/RestWebApi/api/Results/"); //HTTP      
    http.addHeader("Content-Type", "application/json");

    Serial.print("[HTTP] POST...\n");
    // start connection and send HTTP header and body
    snprintf (msg, MSG_BUFFER_SIZE, "{\"MeasurementId\" : %d, \"x\" : %ld, \"y\" : %ld, \"z\" : %ld}", MeasurementId, random(100),random(100),random(100));
    Serial.print("Publish message: ");
    int httpCode = http.POST(msg);

    // httpCode will be negative on error
    if (httpCode > 0) {
      // HTTP header has been send and Server response header has been handled
      Serial.printf("[HTTP] POST... code: %d\n", httpCode);

      // file found at server
      if (httpCode == HTTP_CODE_OK || httpCode == 201) {
        const String& payload = http.getString();
        Serial.print("received payload: ");
        Serial.println(payload);
      }
    } else {
      Serial.printf("[HTTP] POST... failed, error: %s\n", http.errorToString(httpCode).c_str());
    }
    http.end();
  }
  delay(10000);
}
