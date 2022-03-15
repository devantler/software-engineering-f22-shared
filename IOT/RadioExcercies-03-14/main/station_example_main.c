/* WiFi station Example

   This example code is in the Public Domain (or CC0 licensed, at your option.)

   Unless required by applicable law or agreed to in writing, this
   software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
   CONDITIONS OF ANY KIND, either express or implied.
*/
#include <string.h>
#include "freertos/FreeRTOS.h"
#include "freertos/task.h"
#include "freertos/event_groups.h"
#include "esp_system.h"
#include "esp_wifi.h"
#include "esp_event.h"
#include "esp_log.h"
#include "nvs_flash.h"

#include "lwip/err.h"
#include "lwip/sys.h"

#include "hl_wifi.h"

/* The examples use WiFi configuration that you can set via project configuration menu

   If you'd rather not, just change the below entries to strings with
   the config you want - ie #define EXAMPLE_WIFI_SSID "mywifissid"
*/
#define EXAMPLE_ESP_WIFI_SSID      CONFIG_ESP_WIFI_SSID
#define EXAMPLE_ESP_WIFI_PASS      CONFIG_ESP_WIFI_PASSWORD
#define EXAMPLE_ESP_MAXIMUM_RETRY  CONFIG_ESP_MAXIMUM_RETRY

static const char *TAG = "wifi station";



void task_count(void){
   printf("Task reached!\n");
   fflush(stdout);
   struct sockaddr_in addr = hl_wifi_make_addr("10.126.128.178", 8000);
   int sock = hl_wifi_tcp_connect(addr);
   if(sock < 0){
      printf("Error connecting to socket\n");
      fflush(stdout);
      vTaskDelete(NULL);
   }
   printf("Connected to socket\n");
   fflush(stdout);
   uint16_t counter = 1;
   char* buffer[7];
   while(1){
      sprintf(buffer, "%u\n", counter);
      hl_wifi_tcp_tx(sock, buffer, strlen(buffer));
      counter++;
      vTaskDelay(1000 / portTICK_PERIOD_MS);
   }

   vTaskDelete(NULL);
}

void connected_callback(void){
   printf("Callback reached!\n");
   xTaskCreate(task_count, "task_count task", 4096, NULL, 5, NULL);
}



void app_main(void)
{
    //Initialize NVS
    esp_err_t ret = nvs_flash_init();
    if (ret == ESP_ERR_NVS_NO_FREE_PAGES || ret == ESP_ERR_NVS_NEW_VERSION_FOUND) {
      ESP_ERROR_CHECK(nvs_flash_erase());
      ret = nvs_flash_init();
    }
    ESP_ERROR_CHECK(ret);

    ESP_LOGI(TAG, "ESP_WIFI_MODE_STA");
    //hl_wifi_init(EXAMPLE_ESP_WIFI_SSID, EXAMPLE_ESP_WIFI_PASS, EXAMPLE_ESP_MAXIMUM_RETRY, TAG);
    
    hl_wifi_init("ProjektNet", "RobotRocks", 5, "wifi_station", &connected_callback);
    
}
