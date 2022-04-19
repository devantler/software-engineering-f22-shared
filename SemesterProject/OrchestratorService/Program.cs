using Entities;
using Mqtt;

#region Variables
IMqttService mqtt;

Dictionary<string, Crane> cranes;
Dictionary<string, Disk> disks;
Dictionary<string, Camera> cameras;

bool running = true;
#endregion

#region Main
Setup();
Run();
#endregion

void Setup()
{
    mqtt = new MqttService();

    cranes = new Dictionary<string, Crane>();
    cranes.Add("crane1", new Crane(new Dictionary<string, int>()
    {
        {"intake", 0},
        {"outRed", 30},
        {"outGreen", 60},
        {"outBlue", 90}
    }, mqtt));

    disks = new Dictionary<string, Disk>();
    disks.Add("disk1", new Disk(8, new Dictionary<string, int>()
    {
        {"craneZone", 1},
        {"cameraZone", 3},
        {"intakeZone", 6}
    }, mqtt));

    cameras = new Dictionary<string, Camera>();
    cameras.Add("camera1", new Camera(new List<string>()
    {
        "blue",
        "green",
        "red"
    }, mqtt));
}

void Run()
{
    while (running)
    {
		foreach(var slot in disks["disk1"].GetSlotsWithMark("complete"))
        {

        }

        if (!disks["disk1"].IsFull())
        {
        }
    }
}
