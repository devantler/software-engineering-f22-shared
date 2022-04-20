namespace Entities;

public class Element
{
    private readonly List<string> _marks = new();

    public bool HasMark(ElementState mark)
    {
        return _marks.Contains(mark.ToString());
    }
    public bool HasMark(string mark)
    {
        return _marks.Contains(mark);
    }
    public bool HasMark(int mark)
    {
        return _marks.Contains(mark.ToString());
    }
     public void AddMark(ElementState mark)
    {
        _marks.Add(mark.ToString());
    }
    public void AddMark(string mark)
    {
        _marks.Add(mark);
    }
    public void AddMark(int mark)
    {
        _marks.Add(mark.ToString());
    }
    public void RemoveMark(ElementState mark)
    {
        _marks.Remove(mark.ToString());
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