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
import xtext.factoryLang.parsers.TypeParser

class ProgramGenerator {

	def static generate(IFileSystemAccess2 fsa, List<Device> devices, List<Statement> statements) {
		fsa.generateFile(
			'OrchestratorService/Program.cs',
			'''
				using System;
				using System.Collections.Generic;
				using Entities;
				using Mqtt;
				
				namespace OrchestratorService;
				
				«generateVariables»	
				
				«generateMainLoop»	
				
				«generateSetupMethod(devices)»
				
				«generateRunMethod(statements)»
			'''
		)
	}

	protected def static CharSequence generateVariables() '''
		#region Variables
		private IMqttService mqtt;
		
		private Dictionary<string, Crane> cranes;
		private Dictionary<string, Disk> disks;
		private Dictionary<string, Camera> cameras;
		
		private bool running = true;
		#endregion
	'''

	protected def static CharSequence generateMainLoop() '''
		#region Main
		Setup();
		Run();
		#endregion
	'''

	protected def static CharSequence generateSetupMethod(List<Device> devices) '''
		public void Setup() {
			var mqtt = new MqttService();
			«generateCranes(devices.filter[it instanceof Crane].map[it as Crane].toList)»
			«generateDisks(devices.filter[it instanceof Disk].map[it as Disk].toList)»
			«generateCameras(devices.filter[it instanceof Camera].map[it as Camera].toList)»
		}
	'''

	protected def static CharSequence generateCranes(List<Crane> cranes) '''
		«IF cranes.size > 0» 
			
			var cranes = new Dictionary<string, Crane>();
			«FOR crane:cranes»
				cranes.Add("«crane.name»", new Crane(new Dictionary<string, int>()
				{
					«FOR target:crane.targets.map[it as CranePositionParameter] SEPARATOR ","»
						{"«target.name»", «target.degree»}
					«ENDFOR»
				},mqtt));
			«ENDFOR»
		«ENDIF»
	'''

	protected def static CharSequence generateDisks(List<Disk> disks) '''
		«IF disks.size > 0» 
			
			var disks = new Dictionary<string, Disk>();
			«FOR disk:disks»
				disks.Add("«disk.name»", new Disk(«(disk.slotParameter as DiskSlotParameter).size», new Dictionary<string, int>()
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
			
			var cameras = new Dictionary<string, Camera>();
			«FOR camera:cameras»
				cameras.Add("«camera.name»", new Camera(new List<string>()
				{
					«FOR target:camera.targets.map[it as CameraColorParameter] SEPARATOR ","»
						"«target.color»"
					«ENDFOR»
				}, mqtt));
			«ENDFOR»
		«ENDIF»
	'''

	protected def static CharSequence generateRunMethod(List<Statement> statements) {
		'''
			public void Run() {
				while (running) {
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
			ForEach: '''
				foreach (var «statement.variable.name» in «TypeParser.parseDeviceTypeInPlural(statement.device)»["«statement.device.name»"].Where(x => «IF !statement.operator.isNullOrEmpty»!«ENDIF»x.«ValueParser.parseVariableValue(statement.variableValue)»)) {
					«FOR nestedStatement : statement.statements»
						«generateStatement(nestedStatement)»
					«ENDFOR»
				}
			'''
			DeviceConditional: '''
				if («IF !statement.not_operator.isNullOrEmpty»!«ENDIF»«statement.device.name».«ValueParser.parseDeviceValue(statement.deviceValue)») {
					«FOR nestedStatement : statement.statements»
						«generateStatement(nestedStatement)»
					«ENDFOR»
				}
			'''
		}
	}
}
