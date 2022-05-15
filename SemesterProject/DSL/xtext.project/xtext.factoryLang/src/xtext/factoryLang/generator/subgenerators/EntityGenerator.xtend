package xtext.factoryLang.generator.subgenerators

import org.eclipse.xtext.generator.IFileSystemAccess2

class EntityGenerator {

	def static generate(IFileSystemAccess2 fsa, boolean shouldGenerateCranes, boolean shouldGenerateDisks,
		boolean shouldGenerateCameras) {
		if (shouldGenerateCranes) {
			generateCraneEntity(fsa)
		}
		if (shouldGenerateDisks) {
			generateDiskEntity(fsa)
			generateSlotEntity(fsa)
			generateSlotStateEnum(fsa)
		}
		if (shouldGenerateCameras) {
			generateCameraEntity(fsa)
		}
	}

	def static generateCraneEntity(IFileSystemAccess2 fsa) {
		fsa.generateFile(
			'OrchestratorService/Entities/Crane.cs',
			'''
				using Mqtt;
				
				namespace Entities
				{
				    public class Crane
				    {
				        private readonly string _name;
				        private readonly Dictionary<string, int> _positions;
				        private readonly IMqttService _mqttService;
				
				        public Crane(string name,Dictionary<string, int> positions, IMqttService mqttService)
				        {
				            _name = name;
				            _positions = positions;
				            _mqttService = mqttService;
				        }
				
				        public void AddPosition(string name, int angle)
				        {
				            _positions.Add(name, angle);
				        }
				
				        public async Task GoTo(string positionName)
				        {
				            await WaitTillIdle();
				            await _mqttService.SendMessage(MqttTopics.Crane(_name).Moving, "Running");
				            await _mqttService.SendMessage(MqttTopics.Crane(_name).Angle, _positions[positionName].ToString());
				            await WaitTillIdle();
				        }
				
				        public async Task GoTo(int position)
				        {
				            await WaitTillIdle();
				            await _mqttService.SendMessage(MqttTopics.Crane(_name).Moving, "Running");
				            await _mqttService.SendMessage(MqttTopics.Crane(_name).Angle, position.ToString());
				            await WaitTillIdle();
				        }
				
				        public async Task PickupItem()
				        {
				            await WaitTillIdle();
				            await _mqttService.SendMessage(MqttTopics.Crane(_name).Moving, "Running");
				            await _mqttService.SendMessage(MqttTopics.Crane(_name).Elevation, "0");
				            await _mqttService.SendMessage(MqttTopics.Crane(_name).Magnet, "1");
				            await WaitTillIdle();
				            await Task.Delay(2000);
				            await _mqttService.SendMessage(MqttTopics.Crane(_name).Moving, "Running");
				            await _mqttService.SendMessage(MqttTopics.Crane(_name).Elevation, "1");
				            await WaitTillIdle();
				        }
				
				        public async Task DropItem()
				        {
				            await WaitTillIdle();
				            await _mqttService.SendMessage(MqttTopics.Crane(_name).Moving, "Running");
				            await _mqttService.SendMessage(MqttTopics.Crane(_name).Elevation, "0");
				            await _mqttService.SendMessage(MqttTopics.Crane(_name).Magnet, "0");
				            await WaitTillIdle();
				            await _mqttService.SendMessage(MqttTopics.Crane(_name).Moving, "Running");
				            await _mqttService.SendMessage(MqttTopics.Crane(_name).Elevation, "1");
				        }
				
				        private async Task WaitTillIdle(){
				            while(!IsIdle())
				            {
				                await Task.Delay(100);
				            }
				        }
				        private bool IsIdle(){
				            return _mqttService.GetMessage(MqttTopics.Crane(_name).Moving) == "Stopped" && _mqttService.GetMessage(MqttTopics.Disk(_name).Moving) == "Stopped";
				        }
				
				        public string GetName()
				        {
				            return _name;
				        }
				    }
				}
			'''
		)
	}

	protected def static void generateDiskEntity(IFileSystemAccess2 fsa) {
		fsa.generateFile(
			'OrchestratorService/Entities/Disk.cs',
			'''
				using System;
				using Mqtt;
				
				namespace Entities;
				
				public class Disk
				{
				    private readonly string _name;
				    private int _currentOffset;
				    private readonly Dictionary<int, Slot> _slots;
				    private readonly Dictionary<string, int> _zones;
				    private readonly IMqttService _mqttService;
				
				    public Disk(string name, int slots, Dictionary<string, int> zones, IMqttService mqttService)
				    {
				        _name = name;
				        _slots = new Dictionary<int, Slot>();
				        for (int i = 0; i < slots; i++)
				        {
				            _slots.Add(i, new Slot(i));
				        }
				        _zones = zones;
				        _mqttService = mqttService;
				    }
				
				    public Slot GetEmptySlot()
				    {
				        return _slots.FirstOrDefault(x => x.Value.SlotState == SlotState.Empty).Value;
				    }
				
				    public int GetEmptySlotNumber()
				    {
				        if (_slots.Any(x => x.Value.SlotState == SlotState.Empty))
				        {
				            return _slots.FirstOrDefault(x => x.Value.SlotState == SlotState.Empty).Key;
				        }
				        return -1;
				    }
				
				    #region MoveSlot methods
				
				    public async Task MoveSlot(string fromZoneName, string toZoneName)
				    {
				        var zonesToMove = mod(_currentOffset + (_zones[toZoneName] - _zones[fromZoneName]), _slots.Count);
				        _currentOffset = zonesToMove;
				        await WaitTillIdle();
				        await _mqttService.SendMessage(MqttTopics.Disk(_name).Moving, "Running");
				        await _mqttService.SendMessage(MqttTopics.Disk(_name).Zone, zonesToMove.ToString()); //TODO: Test if this works, _currentOffset.ToString() might be correct
				        await WaitTillIdle();
				    }
				
				    public async Task MoveSlot(string fromZoneName, int toZone)
				    {
				        var fromZone = _zones[fromZoneName];
				        await MoveSlot(fromZone, toZone);
				    }
				
				    public async Task MoveSlot(int fromZone, string toZoneName)
				    {
				        var toZone = _zones[toZoneName];
				        await MoveSlot(fromZone, toZone);
				    }
				
				    public async Task MoveSlot(int fromZone, int toZone)
				    {
				        var zonesToMove = mod((toZone - fromZone), _slots.Count);
				        _currentOffset = zonesToMove;
				        await WaitTillIdle();
				        await _mqttService.SendMessage(MqttTopics.Disk(_name).Moving, "Running");
				        await _mqttService.SendMessage(MqttTopics.Disk(_name).Zone, zonesToMove.ToString()); //TODO: Test if this works, _currentOffset.ToString() might be correct
				        await WaitTillIdle();
				    }
				
				    internal async Task WaitForIntake()
				    {
				        await _mqttService.SendMessage("intake", "intake");
				        while (_mqttService.GetMessage("intake") != "done")
				        {
				            await Task.Delay(100);
				        }
				    }
				    #endregion
				
				    private async Task WaitTillIdle(){
				        while(!IsIdle())
				        {
				            await Task.Delay(100);
				        }
				    }
				    private bool IsIdle(){
				        return _mqttService.GetMessage(MqttTopics.Disk(_name).Moving) == "Stopped";
				    }
				
				    public bool IsFull()
				    {
				        return _slots.All(x => x.Value.SlotState == SlotState.InProgress || x.Value.SlotState == SlotState.Complete);
				    }
				
				    public bool IsEmpty()
				    {
				        return _slots.All(x => x.Value.SlotState == SlotState.Empty);
				    }
				
				    public Slot GetSlot(int slot)
				    {
				        return _slots[slot];
				    }
				
				    public Slot GetSlot(string slotName)
				    {
				        var slot = _slots[mod((_currentOffset - _zones[slotName]), 8)];
				        Console.WriteLine($"Getting slot at: {slotName} Got slot: {slot.Number}");
				        return slot;
				    }
				
				    #region MarkSlot methods
				    public bool SlotHasMark(int slot, string mark)
				    {
				        return _slots[slot].HasMark(mark);
				    }
				
				    public bool SlotHasMark(int slot, int mark)
				    {
				        return _slots[slot].HasMark(mark);
				    }
				
				    public void MarkSlot(string slotName, SlotState mark)
				    {
				        var slot = GetSlot(slotName);
				        Console.WriteLine($"Marking slot at {slot.Number} with {Enum.GetName(mark)}");
				        if(mark == SlotState.Empty)
				            slot.RemoveAllMarks();
				        slot.SlotState = mark;
				    }
				    
				    public void MarkSlot(int slotName, SlotState mark)
				    {
				        var slot = GetSlot(slotName);
				        Console.WriteLine($"Marking slot at {slot.Number} with {Enum.GetName(mark)}");
				        if(mark == SlotState.Empty)
				            slot.RemoveAllMarks();
				        slot.SlotState = mark;
				    }
				
				    public void MarkSlot(string slotName, string mark)
				    {
				        GetSlot(slotName).AddMark(mark);
				    }
				
				    
				    public void MarkSlot(int slotName, string mark)
				    {
				        GetSlot(slotName).AddMark(mark);
				    }
				
				    public void MarkSlot(string slotName, int mark)
				    {
				        GetSlot(slotName).AddMark(mark);
				    }
				
				    public void RemoveSlotMark(int slotName, string mark)
				    {
				        GetSlot(slotName).RemoveMark(mark);
				    }
				
				    public void RemoveSlotMark(int slotName, int mark)
				    {
				        GetSlot(slotName).RemoveMark(mark);
				    }
				    #endregion
				
				    public List<Slot> GetSlots()
				    {
				        return _slots.Select(x => x.Value).ToList();
				    }
				
				    public List<Slot> GetSlotsWithMark(SlotState mark)
				    {
				        return _slots.Where(x => x.Value.SlotState == mark).Select(x => x.Value).ToList();
				    }
				
				    public List<Slot> GetSlotsWithMark(int mark)
				    {
				        return _slots.Where(x => x.Value.HasMark(mark)).Select(x => x.Value).ToList();
				    }
				
				    public List<Slot> GetSlotsWithMark(string mark)
				    {
				        return _slots.Where(x => x.Value.HasMark(mark)).Select(x => x.Value).ToList();
				    }
				
				    public int GetZone(string zoneName)
				    {
				        return _zones[zoneName];
				    }
				    
				    int mod(int x, int m) {
				        return (x%m + m)%m;
				    }
				}
			'''
		)
	}

	def static generateCameraEntity(IFileSystemAccess2 fsa) {
		fsa.generateFile(
			'OrchestratorService/Entities/Camera.cs',
			'''
				using Mqtt;
				
				namespace Entities;
				
				public class Camera
				{
				    private readonly string _name;
					private readonly IMqttService _mqttService;
					private readonly List<string> _colors;
				
					public Camera(string name, List<string> colors, IMqttService mqttService)
					{
						_name = name;
						_colors = colors;
						_mqttService = mqttService;
					}
				
				    public async Task<string> Scan()
				    {
				        await _mqttService.SendMessage(MqttTopics.Camera(_name).Color, "");
				        await _mqttService.SendMessage(MqttTopics.Camera(_name).Scan, "GetColor");
				        await WaitWhileIdle();
				        return _mqttService.GetMessage(MqttTopics.Camera(_name).Color) ?? "RED";
				    }
				
				    private async Task WaitWhileIdle(){
				        while(IsIdle())
				        {
				            await Task.Delay(100);
				        }
				    }
				
				    private bool IsIdle(){
				        return string.IsNullOrEmpty(_mqttService.GetMessage(MqttTopics.Camera(_name).Color));
				    }
				
				    public string GetName()
				    {
				        return _name;
				    }
				}
			'''
		)
	}

	def static generateSlotEntity(IFileSystemAccess2 fsa) {
		fsa.generateFile(
			'OrchestratorService/Entities/Slot.cs',
			'''
				namespace Entities;
				
				public class Slot
				{
				    private readonly List<string> _marks = new();
				    public SlotState SlotState { get; set; } = SlotState.Empty;
				    public int Number { get; set; }
				
				    public Slot(int number)
				    {
				        Number = number;
				    }
				
				    public bool HasMark(string mark)
				    {
				        return _marks.Contains(mark);
				    }
				
				    public bool HasMark(int mark)
				    {
				        return _marks.Contains(mark.ToString());
				    }
				
				    public void AddMark(string mark)
				    {
				        _marks.Add(mark);
				    }
				
				    public void AddMark(int mark)
				    {
				        _marks.Add(mark.ToString());
				    }
				
				    public void RemoveMark(string mark)
				    {
				        _marks.Remove(mark);
				    }
				
				    public void RemoveMark(int mark)
				    {
				        _marks.Remove(mark.ToString());
				    }
				
				    public void RemoveAllMarks()
				    {
				        _marks.Clear();
				    }
				}
			'''
		)
	}

	def static generateSlotStateEnum(IFileSystemAccess2 fsa) {
		fsa.generateFile(
			'OrchestratorService/Entities/SlotState.cs',
			'''
				namespace Entities;
				
				public enum SlotState 
				{
				    Empty,
				    InProgress,
				    Complete
				}
			'''
		)
	}
}
