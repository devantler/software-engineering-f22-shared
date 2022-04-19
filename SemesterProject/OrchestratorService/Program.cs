using System;
using System.Collections.Generic;
using Entities;
using Mqtt;

namespace OrchestratorService;

#region Variables
private IMqttService mqtt;

private Dictionary<string, Crane> cranes;
private Dictionary<string, Disk> disks;
private Dictionary<string, Camera> cameras;

private bool running = true;
#endregion

#region Main
Setup();
Run();
#endregion

public void Setup() {
	var mqtt = new MqttService();
	
	var cranes = new Dictionary<string, Crane>();
	cranes.Add("crane1", new Crane(new Dictionary<string, int>()
	{
		{"intake", 0},
		{"outRed", 30},
		{"outGreen", 60},
		{"outBlue", 90}
	},mqtt));
	
	var disks = new Dictionary<string, Disk>();
	disks.Add("disk1", new Disk(8, new Dictionary<string, int>()
	{
		{"craneZone", 1},
		{"cameraZone", 3}
	}, mqtt));
	
	var cameras = new Dictionary<string, Camera>();
	cameras.Add("camera1", new Camera(new List<string>()
	{
		"blue",
		"green",
		"red"
	}, mqtt));
}

public void Run() {
	while (running) {
		foreach (var element in disks["disk1"].Where(x => x.HasMark('complete'))) {
		}
		if (!disk1.IsFull()) {
		}
	}
}
