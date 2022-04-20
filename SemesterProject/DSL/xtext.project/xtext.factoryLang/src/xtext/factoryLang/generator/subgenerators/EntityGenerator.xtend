package xtext.factoryLang.generator.subgenerators

import org.eclipse.xtext.generator.IFileSystemAccess2

class EntityGenerator {

	def static generate(IFileSystemAccess2 fsa, boolean shouldGenerateCranes, boolean shouldGenerateDisks, boolean shouldGenerateCameras) {
		if (shouldGenerateCranes) {
			generateCraneEntity(fsa)
		}
		if (shouldGenerateDisks) {
			generateDiskEntity(fsa)
			generateSlotEntity(fsa)
		}
		if (shouldGenerateCameras) {
			generateCameraEntity(fsa)
		}
	}

	def static generateSlotEntity(IFileSystemAccess2 fsa) {

		fsa.generateFile(
			'OrchestratorService/Entities/Slot.cs',
			'''
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
			'''
		)
	}

	def static generateCraneEntity(IFileSystemAccess2 fsa) {
		fsa.generateFile(
			'OrchestratorService/Entities/Crane.cs',
			'''
				using System.Collections.Generic;
				using System.Linq;
				using System.Threading.Tasks;
				using Mqtt;
				
				namespace Entities
				{
				    public class Crane
				    {
						private readonly Dictionary<string, int> _positions;
						private readonly IMqttService _mqttService;
						      public Crane(IMqttService mqttService)
						{
							_positions = new Dictionary<string, int>()
							{
								{"intake", 30},
								{"red", 120},
								{"green", 140},
								{"blue", 160}
							};
							_mqttService = mqttService;
						}
						      
						public Crane(Dictionary<string, int> positions, IMqttService mqttService)
						{
							_positions = positions;
							_mqttService = mqttService;
						}
				
				        public void AddPosition(string name, int angle)
				        {
				            _positions.Add(name, angle);
				        }
				
				        public async Task Goto(string position)
				        {
				            await _mqttService.SendMessage(MqttTopics.Crane.Angle, _positions[position].ToString());
				        }
				        
				        public async Task Goto(int position)
				        {
				            await _mqttService.SendMessage(MqttTopics.Crane.Angle, position.ToString());
				        }
				
				        public async Task PickupItem()
				        {
				            await _mqttService.SendMessage(MqttTopics.Crane.Elevation, "LOW");
				            await _mqttService.SendMessage(MqttTopics.Crane.Magnet, "1");
				            while (_mqttService.GetMessage(MqttTopics.Crane.Moving) != "0")
				            {
				                await Task.Delay(100);
				            }
				            await _mqttService.SendMessage(MqttTopics.Crane.Elevation, "HIGH");
				        }
				        
				        public async Task DropItem()
				        {
				            await _mqttService.SendMessage(MqttTopics.Crane.Elevation, "LOW");
				            while (_mqttService.GetMessage(MqttTopics.Crane.Moving) != "0")
				            {
				                await Task.Delay(100);
				            }
				            await _mqttService.SendMessage(MqttTopics.Crane.Magnet, "0");
				            await _mqttService.SendMessage(MqttTopics.Crane.Elevation, "HIGH");
				        }
				    }
				}
			'''
		)
	}

	def static generateCameraEntity(IFileSystemAccess2 fsa) {
		fsa.generateFile(
			'OrchestratorService/Entities/Camera.cs',
			'''
				using Mqtt;
				
				namespace Entities;
				
				public class Camera
				{
					private readonly List<string> _colors;
					   private IMqttService _mqttService;
				
				    public Camera(List<string> colors, IMqttService mqttService){
					_colors = colors;
					_mqttService = mqttService;
				    }
				
				    public string Scan()
				    {
				    //Scanner stuff
				    return string.Empty;
				    }
				}
			'''
		)
	}

	protected def static void generateDiskEntity(IFileSystemAccess2 fsa) {
		fsa.generateFile(
			'OrchestratorService/Entities/Disk.cs',
			'''
				using Mqtt;
				
				namespace Entities;
				
				public class Disk
				{
				    private int _currentOffset = 0;
				    private readonly Dictionary<int, Slot> _slots;
				    private Dictionary<string, int> _zones = new Dictionary<string, int>();
				    private IMqttService _mqttService;
				
					    public Disk(int slots, Dictionary<string, int> zones, IMqttService mqttService){
					    	_slots = new Dictionary<int, Slot>();
					    	   for (int i = 0; i < slots; i++)
					    	   {
					    	       _slots.Add(i, new Slot());
					    	   }
					    	_zones = zones;
					    	_mqttService = mqttService;
					    }
				
				    public int GetEmptySlot()
				    {
				        if (_slots.Any(x => !x.Value.HasItem))
				        {
				            return _slots.FirstOrDefault(x => !x.Value.HasItem).Key;
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
				
				    #endregion
				
				    public void MoveSlot(int fromPosition, int toPosition)
				    {
				        //Mqtt stuff
				        var amountToMove = fromPosition - toPosition;
				        _currentOffset = _currentOffset + amountToMove % _slots.Count;
				    }
				
				    public bool IsFull()
				    {
				        return _slots.All(x => x.Value.HasMark("full"));
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
			'''
		)
	}
}
