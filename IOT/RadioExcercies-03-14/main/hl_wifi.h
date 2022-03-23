#ifndef HL_WIFI_H
#define HL_WIFI_H

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
#include "lwip/sockets.h"

typedef void (*connected_callback_t)(void);
int hl_wifi_tcp_connect(struct sockaddr_in addr);
struct sockaddr_in hl_wifi_make_addr(char* _cp, uint16_t b);
void hl_wifi_init(char* ssid, char* password, int _max_retry, char* _TAG, connected_callback_t* _connected_callback);
void hl_wifi_tcp_tx(int sock, void* buffer, uint16_t length);
#endif

