using System;
using Entities;
using Mqtt;

#region Variables
IMqttService mqtt = new MqttService();

Dictionary<string, Crane> cranes = new();
Dictionary<string, Disk> disks = new();
Dictionary<string, Camera> cameras = new();

bool running = true;
#endregion

#region Main
Setup();
Run().GetAwaiter().GetResult();
#endregion

void Setup()
{
    cranes.Add("crane1", new Crane("crane1", new Dictionary<string, int>()
    {
        {"intake", 0},
        {"outRed", 40},
        {"outGreen", 55},
        {"outBlue", 70}
    }, mqtt));

    disks.Add("disk1", new Disk("disk1", 8, new Dictionary<string, int>()
    {
        {"craneZone", 0},
        {"cameraZone", 4},
        {"intakeZone", 2}
    }, mqtt));

    cameras.Add("camera1", new Camera("camera1", new List<string>()
    {
        "blue",
        "green",
        "red"
    }, mqtt));
}

async Task Run()
{
    var crane1 = cranes["crane1"];
    var disk1 = disks["disk1"];
    var camera1 = cameras["camera1"];

    while (running)
    {
        foreach (var diskSlot in disk1.GetSlotsWithMark(SlotState.Complete))
        {
            await disk1.MoveSlot(diskSlot.Number, "craneZone");
            await crane1.GoTo("intake");
            await crane1.PickupItem();
            if (diskSlot.HasMark("RED"))
            {
                await crane1.GoTo("outRed");
                await crane1.DropItem();
            }
            if (diskSlot.HasMark("GREEN"))
            {
                await crane1.GoTo("outGreen");
                await crane1.DropItem();
            }
            if (diskSlot.HasMark("BLUE"))
            {
                await crane1.GoTo("outBlue");
                await crane1.DropItem();
            }
            disk1.MarkSlot(diskSlot.Number, SlotState.Empty);
        }
        if (!disk1.IsFull())
        {
            var currentSlot = disk1.GetEmptySlotNumber();
            await disk1.MoveSlot(currentSlot, "intakeZone");
            Console.WriteLine($"Empty slot: {currentSlot}");
            await disk1.WaitForIntake();
            disk1.MarkSlot(currentSlot, SlotState.InProgress);
            await disk1.MoveZoneToZone("intakeZone", "cameraZone");
            var currentItemColor = await camera1.Scan();
            disk1.MarkSlot(currentSlot, currentItemColor);
            if (currentItemColor == "RED")
            {
                Task.Run(async () =>
                {
                    var slotNo = currentSlot;
                    await Task.Delay(3 * 90 * 1000);
                    disk1.MarkSlot(slotNo, SlotState.Complete);
                });
            }
            if (currentItemColor == "GREEN")
            {
                Task.Run(async () =>
                {
                    var slotNo = currentSlot;
                    await Task.Delay(2 * 90 * 1000);
                    disk1.MarkSlot(slotNo, SlotState.Complete);
                });
            }
            if (currentItemColor == "BLUE")
            {
                Task.Run(async () =>
                {
                    var slotNo = currentSlot;
                    await Task.Delay(4 * 60 * 1000);
                    disk1.MarkSlot(slotNo, SlotState.Complete);
                });
            }
        }
    }
}
