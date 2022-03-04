// See https://aka.ms/new-console-template for more information

using System;
using System.Collections.Generic;
using Domain.Entities;
using Domain.Services;

var mqtt = new MqttService();
var crane = new Crane(new Dictionary<string, int>()
{
    {"intake", 30},
    {"red", 120},
    {"green", 140},
    {"blue", 160}
}, mqtt);
string[]? userInput;
do
{
    userInput = Console.ReadLine()?.Split(" ");
    switch (userInput?[0])
    {
        case "crane":
            CraneActions(userInput);
            break;
        case "disc":
            DiscActions(userInput);
            break;
        default:
            Console.WriteLine($"{userInput?[0]} is not a known entity");
            break;
    }
} while (userInput?[0] != "exit" || userInput?[0] != "q");

void CraneActions(string[]? input)
{
    var firstParam = input?[2];
    switch (input?[1])
    {
        case "goto":
            if (int.TryParse(firstParam, out var angle))
            {
                Console.WriteLine($"Going to angle: {firstParam}");
                crane.Goto(angle);
            }
            if (firstParam != null)
            {
                Console.WriteLine($"Going to position: {firstParam}");
                crane.Goto(firstParam);
            }
            break;
        case "drop":
            Console.WriteLine("Dropping item");
            crane.DropItem();
            break;
        case "pickup":
            Console.WriteLine("Picking up item");
            crane.PickupItem();
            break;
        default:
            Console.WriteLine($"{input?[1]} is not a known crane action");
            break;
    }
}

void DiscActions(string[]? input)
{
}