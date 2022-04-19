namespace Entities;

public class Slot
{
    private List<string> _marks = new List<string>();
    
    public bool HasMark(string mark)
    {
        return _marks.Contains(mark);
    }

    public void AddMark(string mark)
    {
    _marks.Add(mark);
    }
}
