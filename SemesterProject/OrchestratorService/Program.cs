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
    var disk1 = disks["disk1"];
    var crane1 = cranes["crane1"];
    var camera1 = cameras["camera1"];
    while (running)
    {
        foreach (var slot in disk1.GetSlotsWithElementState(ElementState.Completed)) //For each (not relevant for crane and camera i think)
        {
            disk1.MoveSlot(slot.Number, disk1.GetZone("craneZone")); //move slot of
            //pickup item at
            var element = disk1.GetSlotElement(slot.Number);
            await crane1.Goto("intake");
            await crane1.PickupItem(element);
            //mark slot at
            disk1.SetSlotState("craneZone", SlotState.Empty);
            //if var statement
            if (element.HasMark("red"))
            {
                await crane1.Goto("outRed");
                await crane1.DropItem();
                element.RemoveMark("red");
            }
            if (element.HasMark("green"))
            {
                await crane1.Goto("outGreen");
                await crane1.DropItem();
                element.RemoveMark("green");
            }
            if (element.HasMark("blue"))
            {
                await crane1.Goto("outBlue");
                await crane1.DropItem();
                element.RemoveMark("blue");
            }
        }

        if (disk1.IsEmpty()) { }
        if (!disk1.IsEmpty()) { }
        if (disk1.IsFull()) { }
        if (!disk1.IsFull()) { }
        if (!disk1.IsFull())
        {
            disk1.MoveSlot(disk1.GetEmptySlotNumber(), "craneZone"); //move empty slot
            disk1.MarkSlotElementAt("craneZone", ElementState.InProgress); //mark slot at
            disk1.MoveSlot("craneZone", "cameraZone"); //move slot at
            var currentItemColor = camera1.Scan();
            disk1.MarkSlotElementAt("cameraZone", currentItemColor); //mark slot at
            if (currentItemColor == "red")
            {
                await Task.Run(() =>
                {
                    Thread.Sleep(10000);
                    disk1.RemoveElementMarkAt("cameraZone", ElementState.InProgress);
                    disk1.MarkSlotElementAt("cameraZone", ElementState.Completed);
                });
            }
            if (currentItemColor == "green")
            {
                //"disc" mark slot at "disc.camera" as finished in 10 seconds
                await Task.Run(() =>
                {
                    Thread.Sleep(20000);
                    disk1.RemoveElementMarkAt("cameraZone", ElementState.InProgress);
                    disk1.MarkSlotElementAt("cameraZone", ElementState.Completed);
                });
            }
            if (currentItemColor == "blue")
            {
                //"disc" mark slot at "disc.camera" as finished in 10 seconds
                await Task.Run(() =>
                {
                    Thread.Sleep(30000);
                    disk1.RemoveElementMarkAt("cameraZone", ElementState.InProgress);
                    disk1.MarkSlotElementAt("cameraZone", ElementState.Completed);
                });
            }
        }
    }
}
