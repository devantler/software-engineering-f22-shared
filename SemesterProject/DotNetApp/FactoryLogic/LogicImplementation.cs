using Domain.Entities;
using Domain.Services;

namespace FactoryLogic;

public class LogicImplementation
{
    private IMqttService _mqttService;
    private Crane crane;
    private Disc disc;
    private Scanner _scanner;
    private bool running = true;

    public LogicImplementation(IMqttService mqttService)
    {
        _mqttService = mqttService;
    }

    public void Setup()
    {
        crane = new Crane(_mqttService);
        disc = new Disc(_mqttService);
        _scanner = new Scanner();
    }

    public void Run()
    {
        while (running)
        {
            //if "disc" is not full then
            if (!disc.IsFull())
            {
                //"disc" move empty slot to "disc.intake"
                var emptySlot = disc.GetEmptySlot();
                disc.MoveSlot(emptySlot, "intake");
                //"disc" mark slot at "disc.intake" as full
                disc.MarkSlot("intake", "full");
                //"disc" move slot at "disc.intake" to "disc.camera"
                disc.MoveSlot("intake", "camera");
                //"scanner" scan color into itemcolor 
                var itemcolor = _scanner.Scan();
                //"disc" mark slot at "disc.camera" as itemcolor
                disc.MarkSlot("camera", itemcolor);
                //if itemcolor is red then
                if (itemcolor == "red")
                {
                    //"disc" mark slot at "disc.camera" as finished in 10 seconds
                    Task.Run(() =>
                    {
                        Thread.Sleep(10000);
                        disc.MarkSlot("camera", "finished");
                    });
                }
                //if itemcolor is green then
                if (itemcolor == "red")
                {
                    //"disc" mark slot at "disc.camera" as finished in 20 seconds
                    Task.Run(() =>
                    {
                        Thread.Sleep(20000);
                        disc.MarkSlot("camera", "finished");
                    });
                }
                //if itemcolor is blue then
                if (itemcolor == "red")
                {
                    //"disc" mark slot at "disc.camera" as finished in 30 seconds
                    Task.Run(() =>
                    {
                        Thread.Sleep(20000);
                        disc.MarkSlot("camera", "finished");
                    });
                }
            }
            
            //for each thing in myStorage of "disc" that is finished then 
            foreach(var thing in disc.GetSlotsWithMark("finished"))
            {
                
            }
        }
    }
    
    
    
    
    
    
    
    

    
    "disc" move slot of thing to "disc.crane" 
    "fishing rod" pickup item at "fishing rod.intake"
    if thing is red then
    "fishing rod" drop item at "fishing rod.red"
    if thing is green then
    "fishing rod" drop item at "fishing rod.green"
    if thing is blue then
    "fishing rod" drop item at "fishing rod.blue"
    "disc" mark slot at "disc.intake" as empty
}