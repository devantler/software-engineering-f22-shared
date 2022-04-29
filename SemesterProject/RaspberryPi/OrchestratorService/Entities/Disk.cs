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
        var fromZone = _zones[fromZoneName];
        var toZone = _zones[toZoneName];
        await MoveSlot(fromZone, toZone);
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
        var zonesToMove = fromZone - toZone;
        _currentOffset = (_currentOffset + zonesToMove) % _slots.Count;
        await WaitTillIdle();
        await _mqttService.SendMessage(MqttTopics.Disk(_name).Moving, "Running");
        await _mqttService.SendMessage(MqttTopics.Disk(_name).Zone, toZone.ToString()); //TODO: Test if this works, _currentOffset.ToString() might be correct
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
        return _slots[_zones[slotName]];
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
        if(mark == SlotState.Empty)
            GetSlot(slotName).RemoveAllMarks();
        GetSlot(slotName).SlotState = mark;
    }

    public void MarkSlot(string slotName, string mark)
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
}
