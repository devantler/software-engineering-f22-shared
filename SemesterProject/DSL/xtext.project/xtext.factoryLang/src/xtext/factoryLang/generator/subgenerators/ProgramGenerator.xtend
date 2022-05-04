package xtext.factoryLang.generator.subgenerators

import java.util.List
import org.eclipse.xtext.generator.IFileSystemAccess2
import xtext.factoryLang.factoryLang.Camera
import xtext.factoryLang.factoryLang.CameraColorParameter
import xtext.factoryLang.factoryLang.Crane
import xtext.factoryLang.factoryLang.CranePositionParameter
import xtext.factoryLang.factoryLang.Device
import xtext.factoryLang.factoryLang.Disk
import xtext.factoryLang.factoryLang.DiskSlotParameter
import xtext.factoryLang.factoryLang.DiskZoneParameter
import xtext.factoryLang.factoryLang.Statement
import xtext.factoryLang.factoryLang.ForEach
import xtext.factoryLang.factoryLang.DeviceConditional
import xtext.factoryLang.parsers.ValueParser
import xtext.factoryLang.factoryLang.VariableConditional
import xtext.factoryLang.factoryLang.DiskMoveVariableSlotOperation
import xtext.factoryLang.factoryLang.CranePickupOperation
import xtext.factoryLang.factoryLang.DiskMarkSlotOperation
import xtext.factoryLang.factoryLang.CraneDropOperation
import xtext.factoryLang.factoryLang.DiskMoveEmptySlotOperation
import xtext.factoryLang.factoryLang.DiskMoveSlotOperation
import xtext.factoryLang.factoryLang.CameraScanOperation
import xtext.factoryLang.factoryLang.impl.GlobalVariableImpl
import xtext.factoryLang.parsers.EnumParser

class ProgramGenerator {

	def static generate(IFileSystemAccess2 fsa, List<Device> devices, List<Statement> statements) {
		fsa.generateFile(
			'OrchestratorService/Program.cs',
			'''
				using Entities;
				using Mqtt;
				
				«generateVariables»
				
				«generateMainLoop»
				
				«generateSetupMethod(devices)»
				
				«generateRunMethod(devices, statements)»
			'''
		)
	}

	protected def static CharSequence generateVariables() '''
		#region Variables
		IMqttService mqtt = new MqttService();
		
		Dictionary<string, Crane> cranes = new();
		Dictionary<string, Disk> disks = new();
		Dictionary<string, Camera> cameras = new();
		
		bool running = true;
		#endregion
	'''
	protected def static CharSequence generateMainLoop() '''
		#region Main
		Setup();
		Run().GetAwaiter().GetResult();
		#endregion
	'''
	protected def static CharSequence generateSetupMethod(List<Device> devices) '''
		void Setup()
		{
			«generateCranes(devices.filter[it instanceof Crane].map[it as Crane].toList)»
		
			«generateDisks(devices.filter[it instanceof Disk].map[it as Disk].toList)»
		
			«generateCameras(devices.filter[it instanceof Camera].map[it as Camera].toList)»
		}
	'''
	protected def static CharSequence generateCranes(List<Crane> cranes) '''
		«IF cranes.size > 0» 
			«FOR crane:cranes»
				cranes.Add("«crane.name»", new Crane("«crane.name»", new Dictionary<string, int>()
				{
					«FOR target:crane.targets.map[it as CranePositionParameter] SEPARATOR ","»
						{"«target.name»", «target.degree»}
					«ENDFOR»
				}, mqtt));
			«ENDFOR»
		«ENDIF»
	'''
	protected def static CharSequence generateDisks(List<Disk> disks) '''
		«IF disks.size > 0»
			«FOR disk:disks»
				disks.Add("«disk.name»", new Disk("«disk.name»", «(disk.slotParameter as DiskSlotParameter).size», new Dictionary<string, int>()
				{
					«FOR target:disk.targets.map[it as DiskZoneParameter] SEPARATOR ","»
						{"«target.name»", «target.slot»}
					«ENDFOR»
				}, mqtt));
			«ENDFOR»
		«ENDIF»
	'''
	protected def static CharSequence generateCameras(List<Camera> cameras) '''
		«IF cameras.size > 0»
			«FOR camera:cameras»
				cameras.Add("«camera.name»", new Camera("«camera.name»", new List<string>()
				{
					«FOR target:camera.targets.map[it as CameraColorParameter] SEPARATOR ","»
						"«target.color»"
					«ENDFOR»
				}, mqtt));
			«ENDFOR»
		«ENDIF»
	'''
	protected def static CharSequence generateRunMethod(List<Device> devices, List<Statement> statements) {
		'''
			async Task Run()	
			{
				«FOR crane : devices.filter[it instanceof Crane].map[it as Crane].toList»
					var «crane.name» = cranes["«crane.name»"];
				«ENDFOR»
				«FOR disk : devices.filter[it instanceof Disk].map[it as Disk].toList»
					var «disk.name» = disks["«disk.name»"];
				«ENDFOR»
				«FOR camera : devices.filter[it instanceof Camera].map[it as Camera].toList»
					var «camera.name» = cameras["«camera.name»"];
				«ENDFOR»
			
				while (running)
				{
					«FOR statement : statements»
						«generateStatement(statement)»
					«ENDFOR»
				}
			}
		'''
	}
	protected def static CharSequence generateStatement(Statement statement) {
		// remember scope for local variables
		switch statement {
			ForEach: {
				val optionalNotOperator = '''«IF !statement.operator.isNullOrEmpty»!«ENDIF»'''
				val methodCalledOnBoundVariable = optionalNotOperator +
					ValueParser.parseVariableValue(statement.variableValue, statement.getClass())
				val filteredDevice = '''«statement.device.name».«methodCalledOnBoundVariable»'''
				'''
					foreach (var «statement.variable.name» in «filteredDevice»)
					{
						«FOR nestedStatement : statement.statements»
							«generateStatement(nestedStatement)»
						«ENDFOR»
					}
				'''
			}
			DeviceConditional: {
				val optionalNotOperator = '''«IF !statement.not_operator.isNullOrEmpty»!«ENDIF»'''
				val deviceName = statement.device.name
				val methodCalledOnBoundVariable = ValueParser.parseDeviceValue(statement.deviceValue,
					statement.getClass())
				'''
					if («optionalNotOperator»«deviceName».«methodCalledOnBoundVariable»)
					{
						«FOR nestedStatement : statement.statements»
							«generateStatement(nestedStatement)»
						«ENDFOR»
					}
				'''
			}
			VariableConditional: {
				val variableName = statement.variable.name
				val variableType = statement.variable.getClass()
				val dotOrComparisonOperator = variableType == GlobalVariableImpl ? " " +
						EnumParser.parseComparisonOperator(statement.comparison_operator) + " " : "."
				val conditionalQuotationMark = variableType == GlobalVariableImpl ? '"' : ''
				val variableValue = ValueParser.parseVariableValue(statement.variableValue, variableType)
				'''
					if («variableName»«dotOrComparisonOperator»«conditionalQuotationMark»«variableValue»«conditionalQuotationMark»)
					{
						«FOR nestedStatement : statement.statements»
							«generateStatement(nestedStatement)»
						«ENDFOR»
					}
				'''
			}
			CranePickupOperation: {
				val deviceName = statement.device.name
				val targetName = (statement.target as CranePositionParameter).name
				'''
					await «deviceName».GoTo("«targetName»");
					await «deviceName».PickupItem();
				'''
			}
			CraneDropOperation: {
				val deviceName = statement.device.name
				val targetName = (statement.target as CranePositionParameter).name
				'''
					await «deviceName».GoTo("«targetName»");
					await «deviceName».DropItem();
				'''
			}
			DiskMarkSlotOperation: {
				val deviceName = statement.device.name
				val targetName = statement.target.name
				val diskSlotValue = ValueParser.parseDiskSlotValue(statement.diskSlotValue, statement.getClass())
				val quantity = statement.quantity
				'''
					«IF quantity > 0»
						await Task.Run(async () =>
						{
							await Task.Delay(«quantity * 1000»);
							«deviceName».MarkSlot("«targetName»", «diskSlotValue»);
						});
					«ELSE»
						«deviceName».MarkSlot("«targetName»", «diskSlotValue»);
					«ENDIF»	
				'''
			}
			DiskMoveVariableSlotOperation: {
				val deviceName = statement.device.name
				val variableName = statement.variable.name
				val targetName = statement.target.name
				'''
					«deviceName».MoveSlot(«variableName».Number, "«targetName»");
				'''
			}
			DiskMoveEmptySlotOperation: {
				val deviceName = statement.device.name
				val targetName = statement.target.name
				'''
					«deviceName».MoveSlot(«deviceName».GetEmptySlotNumber(), "«targetName»");
				'''
			}
			DiskMoveSlotOperation: {
				val deviceName = statement.device.name
				val sourceName = statement.source.name
				val targetName = statement.target.name
				'''
					«deviceName».MoveSlot("«sourceName»", "«targetName»");
				'''
			}
			CameraScanOperation: {
				val deviceName = statement.device.name
				val variableName = statement.variable.name
				'''
					var «variableName» = «deviceName».Scan();
				'''
			}
		}
	}
}