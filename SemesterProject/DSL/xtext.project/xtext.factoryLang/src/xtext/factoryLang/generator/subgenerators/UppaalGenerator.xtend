package xtext.factoryLang.generator.subgenerators

import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.emf.ecore.resource.Resource
import xtext.factoryLang.factoryLang.Model
import xtext.factoryLang.factoryLang.Disk
import xtext.factoryLang.factoryLang.Crane
import xtext.factoryLang.factoryLang.Camera
import xtext.factoryLang.factoryLang.DiskSlotParameter
import xtext.factoryLang.factoryLang.DiskSlotStateValue
import xtext.factoryLang.factoryLang.DiskZoneParameter
import xtext.factoryLang.factoryLang.CranePositionParameter
import xtext.factoryLang.factoryLang.Statement
import xtext.factoryLang.factoryLang.DeviceConditional
import xtext.factoryLang.factoryLang.VariableConditional
import xtext.factoryLang.factoryLang.CranePickupOperation
import xtext.factoryLang.factoryLang.CraneDropOperation
import xtext.factoryLang.factoryLang.DiskMoveSlotOperation
import xtext.factoryLang.factoryLang.DiskMoveVariableSlotOperation
import xtext.factoryLang.factoryLang.DiskMoveEmptySlotOperation
import xtext.factoryLang.factoryLang.DiskMarkSlotOperation
import xtext.factoryLang.factoryLang.CameraScanOperation
import xtext.factoryLang.factoryLang.ForEach
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.EMap
import java.util.HashMap
import java.util.Map
import xtext.factoryLang.factoryLang.ColorValue
import xtext.factoryLang.uppaalParsers.EnumParser
import xtext.factoryLang.factoryLang.DISK_STATES

class UppaalGenerator {
	
	public static EList<Statement> statements;
	static Map<String, String> locationIds = new HashMap();
	
	def static generate(IFileSystemAccess2 fsa, Resource resource){
		val model = resource.allContents.filter(Model).next
		val discs = model.configurations.map[device].filter[it instanceof Disk].map[x|x as Disk]
		val cranes = model.configurations.map[device].filter[it instanceof Crane].map[x|x as Crane]
		val cameras = model.configurations.map[device].filter[it instanceof Camera].map[x|x as Camera]
		val discSlotStateValues = resource.allContents.filter(DiskSlotStateValue).map[value].toSet.map[toString]
		statements = model.statements
		
		fsa.generateFile("uppaal/system.xml", 
			'''
			<?xml version="1.0" encoding="utf-8"?>
			<!DOCTYPE nta PUBLIC '-//Uppaal Team//DTD Flat System 1.1//EN' 'http://www.it.uu.se/research/group/darts/uppaal/flat-1_2.dtd'>
			<nta>
				<declaration>
			«FOR disc : discs»
			//«disc.name»
			
			const int «disc.name»_numberOfSlots = «(disc.slotParameter as DiskSlotParameter).size»;
			typedef int[0,«disc.name»numberOfSlots-1] «disc.name»_id_t;
			chan «disc.name»_goto[«disc.name»numberOfSlots];
			chan «disc.name»_addItemCmd, «disc.name»removeItemCmd;
			chan «disc.name»_addItem[«disc.name»numberOfSlots];
			broadcast chan «disc.name»_removeItem[«disc.name»numberOfSlots];
			
			//default tags
			chan «disc.name»_getFreeSlot;
			chan «disc.name»_foundEmptySlot;
			chan «disc.name»_setColour[«disc.name»numberOfSlots][4];
			bool «disc.name»_occupiedSlots[«disc.name»numberOfSlots];
			chan «disc.name»_getColourSlot[«disc.name»numberOfSlots];
			chan «disc.name»_gottenColourSlot;
			
			«FOR value : discSlotStateValues»
			//«value» tag
			chan «disc.name»_set_«value»[«disc.name»numberOfSlots];
			chan «disc.name»_getSlot_«value»;
			chan «disc.name»_foundSlot_«value»;
			bool «disc.name»_slots_«value»[«disc.name»numberOfSlots];
			«ENDFOR»
			
			//Zones: 
			«FOR zone : disc.targets.filter[it instanceof DiskZoneParameter].map[it as DiskZoneParameter]»
			int «disc.name»_zones_«zone.name» = «zone.slot»;
			«ENDFOR»
			«ENDFOR»
			
			«FOR camera : cameras»
			//«camera.name»
			chan «camera.name»_getColour;
			chan «camera.name»_gottenColour;
			«ENDFOR»
			
			«FOR crane : cranes»
			//«crane.name»
			chan «crane.name»_toggleMagnet;
			chan «crane.name»_lowerMagnet, «crane.name»_raiseMagnet;
			«FOR position : crane.targets.filter[it instanceof CranePositionParameter].map[it as CranePositionParameter]»
			chan «crane.name»_goto_«position.name»;
			«ENDFOR»
			
			//-----------------current slot-----------------------------
			int currentSlot = -1;
			
			/**
			1: Red
			2: Green
			3: Blue
			*/
			int colour = 0;
			int currentSlot_colour = 0;
			
			//--------------------defaults------------------------
			clock GlobalTimer;
			broadcast chan emergencyStop;
			
			/**
			1: Tried to remove item from empty disc slot
			2: Tried to add item to full slot
			4:
			8:
			*/
			int error;</declaration>
				<template>
					<name>MasterController</name>
					<declaration>
			clock timer;</declaration>
					<location id="id0">
						<name>Idle</name>
					</location>
					«FOR statement : statements»
					«UppaalMasterGenerator.generateLocation(statement)»
					«ENDFOR»
					<init ref="id0"/>
					«FOR statement : statements»
					«UppaalMasterGenerator.generateTransistion(statement)»	
					«ENDFOR»
				</template>
				«FOR disc : discs»
				«DiscGenerator.generate(disc)»
				«DiscSlotGenerator.generate(disc)»
				«DiscGetVariableGenerator.generate(disc, DISK_STATES.EMPTY.toString)»
				«FOR value : discSlotStateValues»
				«DiscGetVariableGenerator.generate(disc, value)»
				«DiscVariableGenerator.generate(disc, value)»
				«ENDFOR»
				«ENDFOR»
				<template>
					<name>GetFinishedSlot</name>
					<location id="id50" x="40" y="80">
						<name x="0" y="0">Idle</name>
					</location>
					<location id="id51" x="190" y="80">
						<name x="0" y="0">Get4</name>
						<committed/>
					</location>
					<location id="id52" x="190" y="230">
						<name x="0" y="0">Get1</name>
						<committed/>
					</location>
					<location id="id53" x="40" y="230">
						<name x="0" y="0">Get2</name>
						<committed/>
					</location>
					<location id="id54" x="340" y="80">
						<name x="0" y="0">Get3</name>
						<committed/>
					</location>
					<init ref="id50"/>
					<transition>
						<source ref="id51"/>
						<target ref="id50"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»foundSlot_finished!</label>
						<label kind="assignment" x="0" y="0">currentSlot_finished = 3</label>
					</transition>
					<transition>
						<source ref="id50"/>
						<target ref="id51"/>
						<label kind="guard" x="0" y="0">«disc.name»slots_finished[3]</label>
						<label kind="synchronisation" x="0" y="0">«disc.name»getSlot_finished?</label>
					</transition>
					<transition>
						<source ref="id54"/>
						<target ref="id50"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»foundSlot_finished!</label>
						<label kind="assignment" x="0" y="0">currentSlot_finished = 2</label>
					</transition>
					<transition>
						<source ref="id50"/>
						<target ref="id54"/>
						<label kind="guard" x="0" y="0">«disc.name»slots_finished[2]</label>
						<label kind="synchronisation" x="0" y="0">«disc.name»getSlot_finished?</label>
					</transition>
					<transition>
						<source ref="id53"/>
						<target ref="id50"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»foundSlot_finished!</label>
						<label kind="assignment" x="0" y="0">currentSlot_finished = 1</label>
					</transition>
					<transition>
						<source ref="id50"/>
						<target ref="id53"/>
						<label kind="guard" x="0" y="0">«disc.name»slots_finished[1]</label>
						<label kind="synchronisation" x="0" y="0">«disc.name»getSlot_finished?</label>
					</transition>
					<transition>
						<source ref="id52"/>
						<target ref="id50"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»foundSlot_finished!</label>
						<label kind="assignment" x="0" y="0">currentSlot_finished = 0</label>
					</transition>
					<transition>
						<source ref="id50"/>
						<target ref="id52"/>
						<label kind="guard" x="0" y="0">«disc.name»slots_finished[0]</label>
						<label kind="synchronisation" x="0" y="0">«disc.name»getSlot_finished?</label>
					</transition>
				</template>
				
				<template>
					<name>DiscSlot</name>
					<parameter>const id_t id</parameter>
					<location id="id68" x="42" y="170">
						<name x="2" y="90">SlotEmpty</name>
					</location>
					<location id="id69" x="190" y="80">
						<name x="0" y="0">SlotFull</name>
					</location>
					<location id="id70" x="-238" y="17">
						<name x="-428" y="-213">SlotFullRed</name>
					</location>
					<location id="id71" x="40" y="230">
						<name x="0" y="0">GetColourRed</name>
						<committed/>
					</location>
					<location id="id72" x="340" y="80">
						<name x="0" y="0">SlotFullGreen</name>
					</location>
					<location id="id73" x="340" y="230">
						<name x="0" y="0">GetColourGreen</name>
						<committed/>
					</location>
					<location id="id74" x="340" y="380">
						<name x="0" y="0">SlotFullBlue</name>
					</location>
					<location id="id75" x="190" y="380">
						<name x="0" y="0">GetColourBlue</name>
						<committed/>
					</location>
					<location id="id76" x="40" y="380">
						<name x="0" y="0">ErrorAddItemToFull</name>
					</location>
					<location id="id77" x="490" y="80">
						<name x="0" y="0">ErrorRemoveItemFromEmpty</name>
					</location>
					<init ref="id68"/>
					<transition>
						<source ref="id68"/>
						<target ref="id69"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»addItem[id]?</label>
						<label kind="assignment" x="0" y="0">«disc.name»occupiedSlots[id] = true</label>
					</transition>
					<transition>
						<source ref="id69"/>
						<target ref="id70"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»setColour[id][1]?</label>
					</transition>
					<transition>
						<source ref="id70"/>
						<target ref="id71"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»getColourSlot[id]?</label>
						<label kind="assignment" x="0" y="0">currentSlot_colour = 1</label>
					</transition>
					<transition>
						<source ref="id71"/>
						<target ref="id70"/>
						<label kind="synchronisation" x="115" y="230">«disc.name»gottenColourSlot!</label>
					</transition>
					<transition>
						<source ref="id69"/>
						<target ref="id72"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»setColour[id][2]?</label>
					</transition>
					<transition>
						<source ref="id72"/>
						<target ref="id73"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»getColourSlot[id]?</label>
						<label kind="assignment" x="0" y="0">currentSlot_colour = 2</label>
					</transition>
					<transition>
						<source ref="id73"/>
						<target ref="id72"/>
						<label kind="synchronisation" x="340" y="155">«disc.name»gottenColourSlot!</label>
					</transition>
					<transition>
						<source ref="id69"/>
						<target ref="id74"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»setColour[id][3]?</label>
					</transition>
					<transition>
						<source ref="id74"/>
						<target ref="id75"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»getColourSlot[id]?</label>
						<label kind="assignment" x="0" y="0">currentSlot_colour = 3</label>
					</transition>
					<transition>
						<source ref="id75"/>
						<target ref="id74"/>
						<label kind="synchronisation" x="265" y="380">«disc.name»gottenColourSlot!</label>
					</transition>
					<transition>
						<source ref="id69"/>
						<target ref="id68"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»removeItem[id]?</label>
						<label kind="assignment" x="0" y="0">«disc.name»occupiedSlots[id] = false, «disc.name»slots_finished[id] = false</label>
					</transition>
					<transition>
						<source ref="id70"/>
						<target ref="id68"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»removeItem[id]?</label>
						<label kind="assignment" x="0" y="0">«disc.name»occupiedSlots[id] = false, «disc.name»slots_finished[id] = false</label>
					</transition>
					<transition>
						<source ref="id72"/>
						<target ref="id68"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»removeItem[id]?</label>
						<label kind="assignment" x="0" y="0">«disc.name»occupiedSlots[id] = false, «disc.name»slots_finished[id] = false</label>
					</transition>
					<transition>
						<source ref="id74"/>
						<target ref="id68"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»removeItem[id]?</label>
						<label kind="assignment" x="0" y="0">«disc.name»occupiedSlots[id] = false, «disc.name»slots_finished[id] = false</label>
					</transition>
					<transition>
						<source ref="id68"/>
						<target ref="id77"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»removeItem[id]?</label>
						<label kind="assignment" x="0" y="0">error += 1</label>
					</transition>
					<transition>
						<source ref="id69"/>
						<target ref="id76"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»addItem[id]?</label>
						<label kind="assignment" x="0" y="0">error += 2</label>
					</transition>
					<transition>
						<source ref="id70"/>
						<target ref="id76"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»addItem[id]?</label>
						<label kind="assignment" x="0" y="0">error += 2</label>
					</transition>
					<transition>
						<source ref="id72"/>
						<target ref="id76"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»addItem[id]?</label>
						<label kind="assignment" x="0" y="0">error += 2</label>
					</transition>
					<transition>
						<source ref="id74"/>
						<target ref="id76"/>
						<label kind="synchronisation" x="0" y="0">«disc.name»addItem[id]?</label>
						<label kind="assignment" x="0" y="0">error += 2</label>
					</transition>
				</template>
				<template>
					<name>SlotVariable_finished</name>
					<parameter>const id_t id</parameter>
					<location id="id78" x="0" y="0">
						<name x="-10" y="-34">IsFinished</name>
					</location>
					<location id="id79" x="178" y="0">
						<name x="168" y="-34">IsNotFinished</name>
					</location>
					<init ref="id79"/>
					<transition>
						<source ref="id79"/>
						<target ref="id78"/>
						<label kind="synchronisation" x="103" y="-34">«disc.name»set_finished[id]?</label>
						<label kind="assignment" x="89" y="0">«disc.name»slots_finished[id] = true</label>
						<nail x="85" y="-34"/>
					</transition>
					<transition>
						<source ref="id78"/>
						<target ref="id79"/>
						<label kind="synchronisation" x="18" y="4">«disc.name»set_finished[id]?</label>
						<label kind="assignment" x="89" y="0">«disc.name»slots_finished[id] = false</label>
						<nail x="102" y="42"/>
					</transition>
					<transition>
						<source ref="id78"/>
						<target ref="id79"/>
						<label kind="synchronisation" x="89" y="0">«disc.name»removeItem[id]?</label>
						<label kind="assignment" x="89" y="0">«disc.name»slots_finished[id] = false</label>
					</transition>
				</template>
				<template>
					<name>Crane</name>
					<declaration>
			
			// Place local declarations here.
			bool magnetPower =  false;</declaration>
					<location id="id80" x="40" y="80">
						<name x="30" y="50">Intake</name>
					</location>
					<location id="id81" x="190" y="80">
						<name x="180" y="50">Red</name>
					</location>
					<location id="id82" x="190" y="230">
						<name x="180" y="200">Green</name>
					</location>
					<location id="id83" x="40" y="230">
						<name x="30" y="200">Blue</name>
					</location>
					<location id="id84" x="289" y="-110">
						<name x="279" y="-140">LoweredAtRed</name>
					</location>
					<location id="id85" x="399" y="399">
						<name x="389" y="369">LoweredAtGreen</name>
					</location>
					<location id="id86" x="-297" y="255">
						<name x="-307" y="225">LoweredAtBlue</name>
					</location>
					<location id="id87" x="-93" y="-110">
						<name x="-103" y="-140">LoweredAtIntake</name>
					</location>
					<location id="id88" x="561" y="136">
						<name x="551" y="102">Stopped</name>
					</location>
					<init ref="id80"/>
					<transition>
						<source ref="id86"/>
						<target ref="id88"/>
						<label kind="synchronisation" x="132" y="195">emergencyStop?</label>
					</transition>
					<transition>
						<source ref="id87"/>
						<target ref="id88"/>
						<label kind="synchronisation" x="234" y="13">emergencyStop?</label>
					</transition>
					<transition>
						<source ref="id80"/>
						<target ref="id88"/>
						<label kind="synchronisation" x="300" y="108">emergencyStop?</label>
					</transition>
					<transition>
						<source ref="id83"/>
						<target ref="id88"/>
						<label kind="synchronisation" x="300" y="183">emergencyStop?</label>
					</transition>
					<transition>
						<source ref="id85"/>
						<target ref="id88"/>
						<label kind="synchronisation" x="480" y="267">emergencyStop?</label>
					</transition>
					<transition>
						<source ref="id82"/>
						<target ref="id88"/>
						<label kind="synchronisation" x="375" y="183">emergencyStop?</label>
					</transition>
					<transition>
						<source ref="id81"/>
						<target ref="id88"/>
						<label kind="synchronisation" x="375" y="108">emergencyStop?</label>
					</transition>
					<transition>
						<source ref="id84"/>
						<target ref="id88"/>
						<label kind="synchronisation" x="425" y="13">emergencyStop?</label>
					</transition>
					<transition>
						<source ref="id87"/>
						<target ref="id80"/>
						<label kind="synchronisation" x="55" y="215">crane_raiseMagnet?</label>
					</transition>
					<transition>
						<source ref="id80"/>
						<target ref="id87"/>
						<label kind="synchronisation" x="55" y="215">crane_lowerMagnet?</label>
					</transition>
					<transition>
						<source ref="id86"/>
						<target ref="id83"/>
						<label kind="synchronisation" x="130" y="290">crane_raiseMagnet?</label>
					</transition>
					<transition>
						<source ref="id83"/>
						<target ref="id86"/>
						<label kind="synchronisation" x="130" y="290">crane_lowerMagnet?</label>
					</transition>
					<transition>
						<source ref="id85"/>
						<target ref="id82"/>
						<label kind="synchronisation" x="205" y="215">crane_raiseMagnet?</label>
					</transition>
					<transition>
						<source ref="id82"/>
						<target ref="id85"/>
						<label kind="synchronisation" x="205" y="215">crane_lowerMagnet?</label>
					</transition>
					<transition>
						<source ref="id84"/>
						<target ref="id81"/>
						<label kind="synchronisation" x="205" y="65">crane_raiseMagnet?</label>
					</transition>
					<transition>
						<source ref="id81"/>
						<target ref="id84"/>
						<label kind="synchronisation" x="205" y="65">crane_lowerMagnet?</label>
					</transition>
					<transition>
						<source ref="id82"/>
						<target ref="id80"/>
						<label kind="synchronisation" x="55" y="140">crane_goto_intake?</label>
					</transition>
					<transition>
						<source ref="id80"/>
						<target ref="id82"/>
						<label kind="synchronisation" x="55" y="140">crane_goto_green?</label>
					</transition>
					<transition>
						<source ref="id81"/>
						<target ref="id80"/>
						<label kind="synchronisation" x="55" y="65">crane_goto_intake?</label>
					</transition>
					<transition>
						<source ref="id82"/>
						<target ref="id81"/>
						<label kind="synchronisation" x="130" y="140">crane_goto_red?</label>
					</transition>
					<transition>
						<source ref="id83"/>
						<target ref="id82"/>
						<label kind="synchronisation" x="55" y="215">crane_goto_green?</label>
					</transition>
					<transition>
						<source ref="id80"/>
						<target ref="id83"/>
						<label kind="synchronisation" x="-20" y="140">crane_goto_blue?</label>
					</transition>
					<transition>
						<source ref="id83"/>
						<target ref="id80"/>
						<label kind="synchronisation" x="-20" y="140">crane_goto_intake?</label>
					</transition>
					<transition>
						<source ref="id82"/>
						<target ref="id83"/>
						<label kind="synchronisation" x="55" y="215">crane_goto_blue?</label>
					</transition>
					<transition>
						<source ref="id81"/>
						<target ref="id82"/>
						<label kind="synchronisation" x="130" y="140">crane_goto_green?</label>
					</transition>
					<transition>
						<source ref="id80"/>
						<target ref="id81"/>
						<label kind="synchronisation" x="55" y="65">crane_goto_red?</label>
					</transition>
					<transition>
						<source ref="id81"/>
						<target ref="id83"/>
						<label kind="synchronisation" x="55" y="140">crane_goto_blue?</label>
					</transition>
					<transition>
						<source ref="id83"/>
						<target ref="id81"/>
						<label kind="synchronisation" x="55" y="140">crane_goto_red?</label>
					</transition>
					<transition>
						<source ref="id80"/>
						<target ref="id80"/>
						<label kind="synchronisation" x="40" y="80">crane_goto_intake?</label>
						<nail x="10" y="50"/>
						<nail x="70" y="50"/>
					</transition>
					<transition>
						<source ref="id81"/>
						<target ref="id81"/>
						<label kind="synchronisation" x="190" y="80">crane_goto_red?</label>
						<nail x="160" y="50"/>
						<nail x="220" y="50"/>
					</transition>
					<transition>
						<source ref="id82"/>
						<target ref="id82"/>
						<label kind="synchronisation" x="190" y="230">crane_goto_green?</label>
						<nail x="160" y="200"/>
						<nail x="220" y="200"/>
					</transition>
					<transition>
						<source ref="id83"/>
						<target ref="id83"/>
						<label kind="synchronisation" x="40" y="230">crane_goto_blue?</label>
						<nail x="10" y="200"/>
						<nail x="70" y="200"/>
					</transition>
				</template>
				<template>
					<name>CraneMagnet</name>
					<location id="id89" x="40" y="80">
						<name x="30" y="50">MagnetOff</name>
					</location>
					<location id="id90" x="190" y="80">
						<name x="180" y="50">MagnetOn</name>
					</location>
					<location id="id91" x="34" y="-34">
						<name x="24" y="-68">StoppedMagnetOn</name>
					</location>
					<location id="id92" x="195" y="-34">
						<name x="185" y="-68">StoppedMagnetOff</name>
					</location>
					<init ref="id89"/>
					<transition>
						<source ref="id90"/>
						<target ref="id92"/>
						<label kind="synchronisation" x="192" y="6">emergencyStop?</label>
					</transition>
					<transition>
						<source ref="id89"/>
						<target ref="id91"/>
						<label kind="synchronisation" x="37" y="6">emergencyStop?</label>
					</transition>
					<transition>
						<source ref="id90"/>
						<target ref="id89"/>
						<label kind="synchronisation" x="55" y="65">crane_toggleMagnet?</label>
					</transition>
					<transition>
						<source ref="id89"/>
						<target ref="id90"/>
						<label kind="synchronisation" x="55" y="65">crane_toggleMagnet?</label>
					</transition>
				</template>
				<template>
					<name>EmergencyButton</name>
					<location id="id93" x="0" y="0">
						<name x="-10" y="-34">Running</name>
					</location>
					<location id="id94" x="204" y="-8">
						<name x="194" y="-42">Stopped</name>
					</location>
					<init ref="id93"/>
					<transition>
						<source ref="id93"/>
						<target ref="id94"/>
						<label kind="synchronisation" x="18" y="-21">emergencyStop!</label>
					</transition>
				</template>
				<system>
			// Place template instantiations here.
			// List one or more processes to be composed into a system.
			system MasterController, Disc, Crane, DiscSlot, GetEmptySlot, CraneMagnet, Camera, SlotVariable_finished, GetFinishedSlot, EmergencyButton;</system>
				<queries>
					<query>
						<formula>A&lt;&gt; CraneMagnet.MagnetOn imply CraneMagnet.MagnetOff</formula>
						<comment></comment>
					</query>
					<query>
						<formula>A[] !deadlock or EmergencyButton.Stopped</formula>
						<comment></comment>
					</query>
					<query>
						<formula>A[] (Crane.Red and CraneMagnet.MagnetOff) imply !(Crane.Red and CraneMagnet.MagnetOn)</formula>
						<comment></comment>
					</query>
					<query>
						<formula>A[] (Crane.Red and CraneMagnet.MagnetOn) imply !(Crane.Red and CraneMagnet.MagnetOff)</formula>
						<comment></comment>
					</query>
					<query>
						<formula>A[] MasterController.gotoIntake_crane imply «disc.name»slots_finished[currentSlot_finished]</formula>
						<comment></comment>
					</query>
					<query>
						<formula>A[] «disc.name»slots_finished[1] imply «disc.name»occupiedSlots[1]</formula>
						<comment></comment>
					</query>
					<query>
						<formula>E&lt;&gt; forall (i : id_t) DiscSlot(i).SlotEmpty</formula>
						<comment></comment>
					</query>
					<query>
						<formula>A[] EmergencyButton.Stopped imply (Crane.Stopped and Disc.Stopped and (CraneMagnet.StoppedMagnetOff or CraneMagnet.StoppedMagnetOn))</formula>
						<comment></comment>
					</query>
					<query>
						<formula>A[] (EmergencyButton.Stopped and CraneMagnet.MagnetOn) imply CraneMagnet.StoppedMagnetOn</formula>
						<comment></comment>
					</query>
					<query>
						<formula></formula>
						<comment></comment>
					</query>
				</queries>
			</nta>
			'''
		)
	}
	
	static int idCounter = 1;
	def static String getIdOfLocation(String location){
		if(locationIds.containsKey(location)){
			return locationIds.get(location)
		}else{
			return locationIds.put(location, '''id«idCounter++»''')
		}
	}
	
}