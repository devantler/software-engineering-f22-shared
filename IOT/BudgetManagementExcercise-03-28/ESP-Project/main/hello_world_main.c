/* Hello World Example

   This example code is in the Public Domain (or CC0 licensed, at your option.)

   Unless required by applicable law or agreed to in writing, this
   software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
   CONDITIONS OF ANY KIND, either express or implied.
*/
#include <stdio.h>
#include "sdkconfig.h"
#include "freertos/FreeRTOS.h"
#include "freertos/task.h"
#include "esp_system.h"
#include "esp_spi_flash.h"
#include "driver/adc.h"
#include "freertos/queue.h"


#define TX_BUFFER_SIZE 10

QueueHandle_t tx_queue; //This is a pointer

void TaskSample(void* pvParameters){
    QueueHandle_t output_queue = (QueueHandle_t)pvParameters;
    int value;
    while (true)
    {
        value = adc1_get_raw((adc1_channel_t)ADC_CHANNEL_6);
        while(xQueueSendToBack(output_queue, &value, 10) != pdTRUE);
        vTaskDelay(500 / portTICK_PERIOD_MS);
    }
}

void TaskTransmit(void* pvParameters){
    QueueHandle_t input_queue = (QueueHandle_t)pvParameters;
    int value;
    while (true)
    {
        while(xQueueReceive(input_queue, &value, 10) != pdPASS);
        printf("%d\n", value);
        vTaskDelay(100 / portTICK_PERIOD_MS);
    }
}

void app_main(void)
{
    adc1_config_width(ADC_WIDTH_BIT_12);
    adc1_config_channel_atten(ADC_CHANNEL_6, ADC_ATTEN_DB_11);
    tx_queue = xQueueCreate(TX_BUFFER_SIZE, sizeof(int));
    xTaskCreate(TaskSample, "sampleTask", 4096, tx_queue, 1, NULL);
    xTaskCreate(TaskTransmit, "transmitTask", 4096, tx_queue, 1, NULL);
}

