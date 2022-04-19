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
    while (running)
    {
        foreach (var slot in disks["disk1"].GetSlotsWithMark("complete")) //For each (not relevant for crane and camera i think)
        {
            disks["disk1"].MoveSlot(slot.Number, disks["disk1"].GetZone("craneZone")); //move slot of
            //pickup item at
            await cranes["crane1"].Goto("intake");
            await cranes["crane1"].PickupItem();
            //mark slot at
            disks["disk1"].MarkSlot("craneZone", "free");
            //if var statement
            if (slot.HasMark("red"))
            {
                await cranes["crane1"].Goto("outRed");
                await cranes["crane1"].DropItem();
                slot.RemoveMark("red");
            }
            if (slot.HasMark("green"))
            {
                await cranes["crane1"].Goto("outGreen");
                await cranes["crane1"].DropItem();
                slot.RemoveMark("green");
            }
            if (slot.HasMark("blue"))
            {
                await cranes["crane1"].Goto("outBlue");
                await cranes["crane1"].DropItem();
                slot.RemoveMark("blue");
            }
        }
        
        if (disks["disk1"].IsEmpty()) { }
        if (!disks["disk1"].IsEmpty()) { }
        if (disks["disk1"].IsFull()) { }
        if (!disks["disk1"].IsFull()) { }

        if (!disks["disk1"].IsFull())
        {
            disks["disk1"].MoveSlot(disks["disk1"].GetEmptySlot(), "craneZone"); //move empty slot
            disks["disk1"].MarkSlot("craneZone", "in-progress"); //mark slot at
            disks["disk1"].MoveSlot("craneZone", "cameraZone"); //move slot at
            var currentItemColor = cameras["camera1"].Scan();
            disks["disk1"].MarkSlot("cameraZone", currentItemColor); //mark slot at
            if (currentItemColor == "red")
            {
                await Task.Run(() =>
                {
                    Thread.Sleep(10000);
                    disks["disk1"].MarkSlot("cameraZone", "complete");
                });
            }
            if (currentItemColor == "green")
            {
                //"disc" mark slot at "disc.camera" as finished in 10 seconds
                await Task.Run(() =>
                {
                    Thread.Sleep(20000);
                    disks["disk1"].MarkSlot("cameraZone", "complete");
                });
            }
            if (currentItemColor == "blue")
            {
                //"disc" mark slot at "disc.camera" as finished in 10 seconds
                await Task.Run(() =>
                {
                    Thread.Sleep(30000);
                    disks["disk1"].MarkSlot("cameraZone", "complete");
                });
            }
        }
    }
}
