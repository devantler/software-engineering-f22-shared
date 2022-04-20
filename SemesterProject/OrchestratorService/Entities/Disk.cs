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
        return _slots.All(x => x.Value.SlotState == SlotState.Full);
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
    public void SetSlotState(string slotName, SlotState slotState)
    {
        _slots[_zones[slotName]].SlotState = slotState;
    }

    public Element? GetSlotElement(string slotName)
    {
        return GetSlot(slotName).Element;
    }

    public Element? GetSlotElement(int slot)
    {
        return GetSlot(slot).Element;
    }

    #region MarkSlotElement methods
    public void MarkSlotElementAt(string slotName, ElementState mark)
    {
        GetSlotElement(slotName)?.AddMark(mark);
    }

    public void MarkSlotElementAt(string slotName, string mark)
    {
        GetSlotElement(slotName)?.AddMark(mark);
    }

    public void MarkSlotElementAt(string slotName, int mark)
    {
        GetSlotElement(slotName)?.AddMark(mark);
    }
    public void RemoveElementMarkAt(string slotName, ElementState mark)
    {
        GetSlotElement(slotName)?.RemoveMark(mark);
    }
    public void RemoveElementMarkAt(string slotName, string mark)
    {
        GetSlotElement(slotName)?.RemoveMark(mark);
    }
    public void RemoveElementMarkAt(string slotName, int mark)
    {
        GetSlotElement(slotName)?.RemoveMark(mark);
    }
    #endregion

    public List<Slot> GetSlots()
    {
        return _slots.Select(x => x.Value).ToList();
    }

    public List<Slot> GetSlotsWithElementState(ElementState elementState)
    {
        return _slots.Where(x => x.Value.Element?.HasMark(elementState) == true).Select(x => x.Value).ToList();
    }

    public List<Slot> GetSlotsWithElementMark(string mark)
    {
        return _slots.Where(x => x.Value.Element?.HasMark(mark) == true).Select(x => x.Value).ToList();
    }

    public int GetZone(string zoneName)
    {
        return _zones[zoneName];
    }
}
