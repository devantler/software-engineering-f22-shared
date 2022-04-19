using Mqtt;

namespace Entities;

public class Disk
{
    private int _currentOffset;
    private readonly Dictionary<int, Slot> _slots;
    private readonly Dictionary<string, int> _zones;
    private readonly IMqttService _mqttService;

    public Disk(int slots, Dictionary<string, int> zones, IMqttService mqttService)
    {
        _slots = new Dictionary<int, Slot>();
        for (int i = 0; i < slots; i++)
        {
            _slots.Add(i, new Slot(i));
        }
        _zones = zones;
        _mqttService = mqttService;
    }

    public int GetEmptySlot()
    {
        if (_slots.Any(x => x.Value.HasMark("free")))
        {
            return _slots.FirstOrDefault(x => x.Value.HasMark("free")).Key;
        }
        return -1;
    }

    #region MoveSlot methods
    public void MoveSlot(string fromZoneName, string toZoneName)
    {
        var fromZone = _zones[fromZoneName];
        var toZone = _zones[toZoneName];
        MoveSlot(fromZone, toZone);
    }

    public void MoveSlot(string fromZoneName, int toZone)
    {
        var fromZone = _zones[fromZoneName];
        MoveSlot(fromZone, toZone);
    }

    public void MoveSlot(int fromZone, string toZoneName)
    {
        var toZone = _zones[toZoneName];
        MoveSlot(fromZone, toZone);
    }
    public void MoveSlot(int fromZone, int toZone)
    {
        //Mqtt stuff
        var zonesToMove = fromZone - toZone;
        _currentOffset = (_currentOffset + zonesToMove) % _slots.Count;
        _mqttService.SendMessage(MqttTopics.Disk.Slot, _currentOffset.ToString()); //TODO: Might need to be changed to MqttTopics.Disk.Zone
    }
    #endregion

    public bool IsFull()
    {
        return _slots.All(x => x.Value.HasMark("full"));
    }
    public bool IsEmpty()
    {
        return _slots.All(x => x.Value.HasMark("free"));
    }
    public void MarkSlot(int slot, string mark)
    {
        _slots[slot].AddMark(mark);
    }

    public void MarkSlot(string zoneName, string mark)
    {
        _slots[_zones[zoneName]].AddMark(mark);
    }

    public void RemoveMarkSlot(int slot, string mark)
    {
        _slots[slot].RemoveMark(mark);
    }

    public void RemoveMarkSlot(string zoneName, string mark)
    {
        _slots[_zones[zoneName]].RemoveMark(mark);
    }

    public bool SlotHasMark(int slot, string mark)
    {
        return _slots[slot].HasMark(mark);
    }

    public bool SlotHasMark(string zoneName, string mark)
    {
        return _slots[_zones[zoneName]].HasMark(mark);
    }

    public List<Slot> GetSlots()
    {
        return _slots.Select(x => x.Value).ToList();
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
