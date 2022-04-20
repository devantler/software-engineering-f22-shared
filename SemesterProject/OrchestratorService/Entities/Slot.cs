namespace Entities;

public class Slot
{
    public Element? Element { get; set; }
    public SlotState SlotState { get; set; }
    public int Number {get; set; }
    public Slot(int number)
    {
        Number = number;
    }
}
