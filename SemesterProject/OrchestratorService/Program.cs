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
Run();
#endregion

void Setup()
{
    cranes.Add("crane1", new Crane("crane1", new Dictionary<string, int>()
    {
        {"intake", 0},
        {"outRed", 30},
        {"outGreen", 60},
        {"outBlue", 90}
    }, mqtt));

    disks.Add("disk1", new Disk("disk1", 8, new Dictionary<string, int>()
    {
        {"craneZone", 1},
        {"cameraZone", 3},
        {"intakeZone", 6}
    }, mqtt));

    cameras.Add("camera1", new Camera("camera1", new List<string>()
    {
        "blue",
        "green",
        "red"
    }, mqtt));
}

async void Run()
{
    var crane1 = cranes["crane1"];
    var disk1 = disks["disk1"];
    var camera1 = cameras["camera1"];

    while (running)
    {
        foreach (var diskSlot in disk1.GetSlotsWithMark(SlotState.Complete))
        {
            disk1.MoveSlot(diskSlot.Number, "craneZone");
            await crane1.GoTo("intake");
            await crane1.PickupItem();

            if (diskSlot.HasMark("red"))
            {
                await crane1.GoTo("outRed");
                await crane1.DropItem();
            }
            if (diskSlot.HasMark("green"))
            {
                await crane1.GoTo("outGreen");
                await crane1.DropItem();
            }
            if (diskSlot.HasMark("blue"))
            {
                await crane1.GoTo("outBlue");
                await crane1.DropItem();
            }
            disk1.MarkSlot("craneZone", SlotState.Empty);
        }

        if (!disk1.IsFull())
        {
            disk1.MoveSlot(disk1.GetEmptySlotNumber(), "intakeZone");
            disk1.MarkSlot("intakeZone", SlotState.InProgress);
            disk1.MoveSlot("intakeZone", "cameraZone");
            var currentItemColor = camera1.Scan();
            disk1.MarkSlot("cameraZone", currentItemColor);
            if (currentItemColor == "red")
            {
                await Task.Run(() =>
                {
                    Thread.Sleep(10000);
                    disk1.MarkSlot("cameraZone", SlotState.Complete);
                });
            }
            if (currentItemColor == "green")
            {
                await Task.Run(() =>
                {
                    Thread.Sleep(20000);
                    disk1.MarkSlot("cameraZone", SlotState.Complete);
                });
            }
            if (currentItemColor == "blue")
            {
                await Task.Run(() =>
                {
                    Thread.Sleep(30000);
                    disk1.MarkSlot("cameraZone", SlotState.Complete);
                });
            }
        }
    }
}
