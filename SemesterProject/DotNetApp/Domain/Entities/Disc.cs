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
        _positionNames.Add("crane", 3);
        _positionNames.Add("camera", 6);
        _positionNames.Add("intake", 1);
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
    public void MoveSlot(string fromPositionName, string toPositionName)
    {
        var fromPosition = _positionNames[fromPositionName];
        var toPosition = _positionNames[toPositionName];
        MoveSlot(fromPosition, toPosition);
    }
    
    public void MoveSlot(string fromPositionName, int toPosition)
    {
        var fromPosition = _positionNames[fromPositionName];
        MoveSlot(fromPosition, toPosition);
    }
    
    public void MoveSlot(int fromPosition, string positionName)
    {
        var toPosition = _positionNames[positionName];
        MoveSlot(fromPosition, toPosition);
    }
    public void MoveSlot(int fromPosition, int toPosition)
    {
        //Mqtt stuff
        var amountToMove = fromPosition - toPosition;
        _currentOffset = _currentOffset + amountToMove % _slots.Count;
        _mqttService.SendMessage(MqttTopics.Disc.Slot, _currentOffset.ToString());
    }
    #endregion

    public bool IsFull(){
        return _slots.All(x => x.Value.HasMark("full"));
    }
    public bool IsEmpty(){
        _slots.All(x => x.Value.HasMark("free"));
    }
    public void MarkSlot(int slot, string mark)
    {
        _slots[slot].AddMark(mark);
    }
    
    public void MarkSlot(string positionName, string mark)
    {
        _slots[_positionNames[positionName]].AddMark(mark);
    }

    public bool SlotHasMark(int slot, string mark)
    {
        return _slots[slot].HasMark(mark);
    }

    public bool SlotHasMark(string positionName, string mark)
    {
        return _slots[_positionNames[positionName]].HasMark(mark);
    }
    
    public List<int> GetSlotsWithMark(string mark)
    {
        return _slots.Where(x => x.Value.HasMark(mark)).Select(x => x.Key).ToList();
    }
}