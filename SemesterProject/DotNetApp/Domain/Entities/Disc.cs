using Domain.Services;

namespace Domain.Entities;

public class Disc
{
    private int _currentOffset = 0;
    private readonly Dictionary<int, Slot> _slots;
    private Dictionary<string, int> _positionNames = new Dictionary<string, int>();
    private IMqttService _mqttService;
    
    public Disc(IMqttService mqttService)
    {
        _mqttService = mqttService;
        _slots = new Dictionary<int, Slot>();
        for (int i = 0; i < 8; i++)
        {
            _slots.Add(i, new Slot());
        }
        _positionNames.Add("A", 1);
        _positionNames.Add("B", 2);
        _positionNames.Add("C", 3);
    }

    public int GetEmptySlot()
    {
        if (_slots.Any(x => !x.Value.HasItem))
        {
            return _slots.FirstOrDefault(x => !x.Value.HasItem).Key;
        }
        return -1;
    }

    public void MoveSlot(int slot, string positionName)
    {
        //Mqtt stuff
        var position = _positionNames[positionName];
        var amountToMove = slot - position;
        _currentOffset = _currentOffset + amountToMove % _slots.Count;
    }
    
    public void MoveSlot(int slot, int position)
    {
        //Mqtt stuff
        var amountToMove = slot - position;
        _currentOffset = _currentOffset + amountToMove % _slots.Count;
    }
}