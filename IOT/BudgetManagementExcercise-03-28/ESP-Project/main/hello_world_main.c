/* Hello World Example

   This example code is in the Public Domain (or CC0 licensed, at your option.)

   Unless required by applicable law or agreed to in writing, this
   software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
   CONDITIONS OF ANY KIND, either express or implied.
*/

//To get the version of Q2 go to commit "IOT 03-28 Q2"

#include <stdio.h>
#include "sdkconfig.h"
#include "freertos/FreeRTOS.h"
#include "freertos/task.h"
#include "esp_system.h"
#include "esp_spi_flash.h"
#include "driver/adc.h"
#include "freertos/queue.h"
#include "string.h"


#define TX_BUFFER_SIZE 10
#define AVG_BUFFER_SIZE 10
#define AVG_WINDOW_SIZE 7

QueueHandle_t tx_queue; //This is a pointer
QueueHandle_t avg_queue;


typedef struct stage_interface_t{
    QueueHandle_t input;
    QueueHandle_t output;
};

struct stage_interface_t avg_pair;

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
    QueueHandle_t avg_queue = (QueueHandle_t)pvParameters;
    int value;
    while (true)
    {
        while(xQueueReceive(input_queue, &value, 10) != pdPASS);
        printf("%d\n", value);
        vTaskDelay(100 / portTICK_PERIOD_MS);
    }
}

void TaskAvg(void* pvParameters){
    struct stage_interface_t* pair = (struct stage_interface_t*)pvParameters;
    QueueHandle_t input_queue = pair -> input;
    QueueHandle_t output_queue = pair -> output;
    int buffer[AVG_WINDOW_SIZE];
    memset(buffer, 0, AVG_WINDOW_SIZE*sizeof(buffer[0]));
    uint8_t index = 0;
    int sum = 0;
    //TODO: consume AVG_WINDOW_SIZE-1 message
    int new;
    while (true)
    {
        for(int i = 0; i < AVG_WINDOW_SIZE-1; i++){ //This is good if sending data is the expensive operation
            //Recieve
            while(xQueueReceive(input_queue, &new, 10) != pdPASS);
            int old = buffer[index];
            buffer[index] = new;
            sum += new - old;
            index = (index + 1) % AVG_WINDOW_SIZE;
        }
        //Send
        int value = sum / AVG_WINDOW_SIZE;
        while(xQueueSendToBack(output_queue, &value, 10) != pdTRUE);
        
    }
}

void app_main(void)
{
    //Initialize the ADC
    adc1_config_width(ADC_WIDTH_BIT_12);
    adc1_config_channel_atten(ADC_CHANNEL_6, ADC_ATTEN_DB_11);

    //Initialize the queues
    tx_queue = xQueueCreate(TX_BUFFER_SIZE, sizeof(int));
    avg_queue = xQueueCreate(AVG_BUFFER_SIZE, sizeof(int));
    avg_pair = (struct stage_interface_t){avg_queue, tx_queue};

    //Initialize the tasks
    xTaskCreate(TaskSample, "sampleTask", 4096, avg_queue, 1, NULL);
    xTaskCreate(TaskTransmit, "transmitTask", 4096, tx_queue, 1, NULL);
    xTaskCreate(TaskAvg, "avgTask", 4096, &avg_pair, 1, NULL);
}

