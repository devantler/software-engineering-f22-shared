namespace Domain.Entities;

public class Slot
{
    private List<string> _marks = new List<string>();
    
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
}