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
    cranes.Add("crane1", new Crane(new Dictionary<string, int>()
    {
        {"intake", 0},
        {"outRed", 30},
        {"outGreen", 60},
        {"outBlue", 90}
    }, mqtt));

    disks.Add("disk1", new Disk(8, new Dictionary<string, int>()
    {
        {"craneZone", 1},
        {"cameraZone", 3},
        {"intakeZone", 6}
    }, mqtt));

    cameras.Add("camera1", new Camera(new List<string>()
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
            disk1.MarkSlot("craneZone", SlotState.Empty); //This is a hack that removes all marks as our DSL does not support removing marks yet.
        }

        if (!disk1.IsFull())
        {
            disk1.MoveSlot(disk1.GetEmptySlotNumber(), "intakeZone"); //move empty slot
            disk1.MarkSlot("intakeZone", SlotState.InProgress); //mark slot at
            disk1.MoveSlot("intakeZone", "cameraZone"); //move slot at
            var currentItemColor = camera1.Scan();
            disk1.MarkSlot("cameraZone", currentItemColor); //mark slot at
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
                //"disc" mark slot at "disc.camera" as finished in 10 seconds
                await Task.Run(() =>
                {
                    Thread.Sleep(20000);
                    disk1.MarkSlot("cameraZone", SlotState.Complete);
                });
            }
            if (currentItemColor == "blue")
            {
                //"disc" mark slot at "disc.camera" as finished in 10 seconds
                await Task.Run(() =>
                {
                    Thread.Sleep(30000);
                    disk1.MarkSlot("cameraZone", SlotState.Complete);
                });
            }
        }
    }
}
