package xtext.factoryLang.generator.subgenerators

import xtext.factoryLang.factoryLang.CameraScanOperation
import xtext.factoryLang.factoryLang.ColorValue
import xtext.factoryLang.factoryLang.CraneDropOperation
import xtext.factoryLang.factoryLang.CranePickupOperation
import xtext.factoryLang.factoryLang.DeviceConditional
import xtext.factoryLang.factoryLang.DiskMarkSlotOperation
import xtext.factoryLang.factoryLang.DiskMoveEmptySlotOperation
import xtext.factoryLang.factoryLang.DiskMoveSlotOperation
import xtext.factoryLang.factoryLang.DiskMoveVariableSlotOperation
import xtext.factoryLang.factoryLang.DiskZoneParameter
import xtext.factoryLang.factoryLang.ForEach
import xtext.factoryLang.factoryLang.VariableConditional
import xtext.factoryLang.uppaalParsers.EnumParser

import static xtext.factoryLang.generator.subgenerators.UppaalGenerator.getIdOfLocation
import static xtext.factoryLang.generator.subgenerators.UppaalGenerator.statements
import xtext.factoryLang.factoryLang.DiskSlotStateValue
import xtext.factoryLang.factoryLang.CranePositionParameter

class UppaalMasterGenerator {
	static String lastTransistionState = "id0";
	static String currentDisc = "ERROR_NO_DISC";
	
	def static dispatch String generateLocation(DeviceConditional statement) {
		return ""
	}
	
	def static dispatch String generateTransistion(DeviceConditional statement) {
		return ""
	}
	
	def static dispatch String generateLocation(VariableConditional statement) {
		'''
		<location id="«getIdOfLocation('''«statement.variable.name»_get«(statement.variableValue.value as ColorValue).value»_«statements.indexOf(statement)»''')»">
			<name>«statement.variable.name»_get«(statement.variableValue.value as ColorValue).value»_«statements.indexOf(statement)»</name>
			<committed/>
		</location>
		<location id="«getIdOfLocation('''«statement.variable.name»Is«(statement.variableValue.value as ColorValue).value»_«statements.indexOf(statement)»''')»">
			<name>«statement.variable.name»Is«(statement.variableValue.value as ColorValue).value»_«statements.indexOf(statement)»</name>
		</location>
		«FOR s : statement.statements»
		«statements.add(s)»
		«generateLocation(s)»
		«ENDFOR»
		<location id="«getIdOfLocation('''EndIf_«statements.indexOf(statement)»''')»">
			<name>EndIf_«statements.indexOf(statement)»</name>
		</location>
		'''
	}
	
	def static dispatch String generateTransistion(VariableConditional statement){
		switch(statement.variableValue.value){
			ColorValue:{
				val trans = '''
				<transition>
					<source ref="«lastTransistionState»"/>
					<target ref="«getIdOfLocation('''«statement.variable.name»_get«(statement.variableValue.value as ColorValue).value»_«statements.indexOf(statement)»''')»"/>
					<label kind="synchronisation">«currentDisc»_getColourSlot[currentSlot]!</label>
				</transition>
				<transition>
					<source ref="«getIdOfLocation('''«statement.variable.name»_get«(statement.variableValue.value as ColorValue).value»_«statements.indexOf(statement)»''')»"/>
					<target ref="«getIdOfLocation('''«statement.variable.name»Is«(statement.variableValue.value as ColorValue).value»_«statements.indexOf(statement)»''')»"/>
					<label kind="guard">currentSlot_colour == «EnumParser.ColourToInt((statement.variableValue.value as ColorValue).value)»</label>
					<label kind="synchronisation">«currentDisc»_gottenColourSlot?</label>
				</transition>
				«FOR s : statement.statements»
				«generateTransistion(s)»
				«ENDFOR»
				''';
				lastTransistionState = getIdOfLocation('''«statement.variable.name»Is«statement.variableValue.value»_«statements.indexOf(statement)»''')
				return trans
				}
			default: throw new UnsupportedOperationException("This conditional value is not implemented yet")
		}
	}
	
	def static dispatch String generateLocation(CranePickupOperation statement) {
		'''
		<location id="«getIdOfLocation('''«statement.device.name»_goto_«(statement.target as CranePositionParameter).name»_«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_goto_«(statement.target as CranePositionParameter).name»_«statements.indexOf(statement)»</name>
		</location>
		<location id="«getIdOfLocation('''«statement.device.name»_lower_«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_lower_«statements.indexOf(statement)»</name>
		</location>
		<location id="«getIdOfLocation('''«statement.device.name»_toggleMagnet_«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_toggleMagnet_«statements.indexOf(statement)»</name>
		</location>
		<location id="«getIdOfLocation('''«statement.device.name»_raise_«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_raise_«statements.indexOf(statement)»</name>
		</location>
		'''
	}
	
	def static dispatch String generateTransistion(CranePickupOperation statement){
		val trans = '''
		<transition>
			<source ref="«lastTransistionState»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_goto_«(statement.target as CranePositionParameter).name»_«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_goto_«(statement.target as CranePositionParameter).name»!</label>
		</transition>
		<transition>
			<source ref="«getIdOfLocation('''«statement.device.name»_goto_«(statement.target as CranePositionParameter).name»_«statements.indexOf(statement)»''')»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_lower_«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_lowerMagnet!</label>
		</transition>
		<transition>
			<source ref="«getIdOfLocation('''«statement.device.name»_lower_«statements.indexOf(statement)»''')»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_toggleMagnet_«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_toggleMagnet!</label>
		</transition>
		<transition>
			<source ref="«getIdOfLocation('''«statement.device.name»_toggleMagnet_«statements.indexOf(statement)»''')»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_raise_«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_raiseMagnet!</label>
		</transition>
		''';
		lastTransistionState = getIdOfLocation('''«statement.device.name»_raise_«statements.indexOf(statement)»''')
		return trans
	}
	
	def static dispatch String generateLocation(CraneDropOperation statement) {
		'''
		<location id="«getIdOfLocation('''«statement.device.name»_goto_«(statement.target as CranePositionParameter).name»_«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_goto_«(statement.target as CranePositionParameter).name»_«statements.indexOf(statement)»</name>
		</location>
		<location id="«getIdOfLocation('''«statement.device.name»_lower_«(statement.target as CranePositionParameter).name»_«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_lower_«(statement.target as CranePositionParameter).name»_«statements.indexOf(statement)»</name>
		</location>
		<location id="«getIdOfLocation('''«statement.device.name»_toggleMagnet_«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_toggleMagnet_«statements.indexOf(statement)»</name>
		</location>
		<location id="«getIdOfLocation('''«statement.device.name»_raise_«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_raise_«statements.indexOf(statement)»</name>
		</location>
		'''
	}
	
	def static dispatch String generateTransistion(CraneDropOperation statement){
		val trans = '''
		<transition>
			<source ref="«lastTransistionState»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_goto_«(statement.target as CranePositionParameter).name»_«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_goto_«(statement.target as CranePositionParameter).name»!</label>
		</transition>
		<transition>
			<source ref="«getIdOfLocation('''«statement.device.name»_goto_«(statement.target as CranePositionParameter).name»_«statements.indexOf(statement)»''')»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_lower_«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_lowerMagnet!</label>
		</transition>
		<transition>
			<source ref="«getIdOfLocation('''«statement.device.name»_lower_«statements.indexOf(statement)»''')»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_toggleMagnet_«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_toggleMagnet!</label>
		</transition>
		<transition>
			<source ref="«getIdOfLocation('''«statement.device.name»_toggleMagnet_«statements.indexOf(statement)»''')»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_raise_«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_raiseMagnet!</label>
		</transition>
		''';
		lastTransistionState = getIdOfLocation('''«statement.device.name»_raise_«statements.indexOf(statement)»''')
		return trans
	}
	
	def static dispatch String generateLocation(DiskMoveSlotOperation statement) {
		'''
		<location id="«getIdOfLocation('''«statement.device.name»_goto_«statement.target.name»_statement«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_goto_«statement.target.name»_statement«statements.indexOf(statement)»</name>
		</location>
		'''
	}
	
	def static dispatch String generateTransistion(DiskMoveSlotOperation statement){
		val trans = '''
		<transition>
			<source ref="«lastTransistionState»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_goto_«statement.target.name»_statement«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_goto[(«statement.device.name»_zones_«statement.target.name» + currentSlot) % «statement.device.name»_numberOfSlots]!</label>
		</transition>
		'''
		lastTransistionState = getIdOfLocation('''«statement.device.name»_goto_«statement.target.name»_statement«statements.indexOf(statement)»''')
		return trans
	}
	
	def static dispatch String generateLocation(DiskMoveVariableSlotOperation statement) {
		'''
		<location id="«getIdOfLocation('''«statement.device.name»_goto_«statement.target.name»_statment«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»goto_«statement.target.name»_statment«statements.indexOf(statement)»</name>
		</location>
		'''
	}
	
	def static dispatch String generateTransistion(DiskMoveVariableSlotOperation statement){
		val trans = '''
		<transition>
			<source ref="«lastTransistionState»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_goto_«statement.target.name»_statment«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_goto[(«statement.device.name»_zones_«statement.target.name» + currentSlot) % «statement.device.name»_numberOfSlots]!</label>
		</transition>
		'''
		lastTransistionState = getIdOfLocation('''«statement.device.name»goto_«statement.target.name»_statment«statements.indexOf(statement)»''')
		return trans
	}
	
	def static dispatch String generateLocation(DiskMoveEmptySlotOperation statement) {
		'''
		<location id="«getIdOfLocation('''«statement.device.name»_getEmptySlot_statement«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_getEmptySlot_statment«statements.indexOf(statement)»</name>
			<committed/>
		</location>
		<location id="«getIdOfLocation('''«statement.device.name»_gottenEmptySlot_statement«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_gottenEmptySlot_statment«statements.indexOf(statement)»</name>
		</location>
		<location id="«getIdOfLocation('''«statement.device.name»_goto_«statement.target.name»_statement«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_goto_«statement.target.name»_statment«statements.indexOf(statement)»</name>
		</location>
		'''
	}
	
	def static dispatch String generateTransistion(DiskMoveEmptySlotOperation statement) {
		val trans = '''
		<transition>
			<source ref="«lastTransistionState»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_getEmptySlot_statement«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_getFreeSlot!</label>
			<label kind="assignment">GlobalTimer = 0</label>
		</transition>
		<transition>
			<source ref="«getIdOfLocation('''«statement.device.name»_getEmptySlot_statement«statements.indexOf(statement)»''')»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_gottenEmptySlot_statement«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_foundEmptySlot?</label>
		</transition>
		<transition>
			<source ref="«getIdOfLocation('''«statement.device.name»_gottenEmptySlot_statement«statements.indexOf(statement)»''')»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_goto_«statement.target.name»_statement«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_goto[(«statement.device.name»_zones_«statement.target.name» + currentSlot) % «statement.device.name»_numberOfSlots]!</label>
		</transition>
		<transition>
			<source ref="«getIdOfLocation('''«statement.device.name»_getEmptySlot_statement«statements.indexOf(statement)»''')»"/>
			<target ref="«lastTransistionState»"/>
			<label kind="guard">GlobalTimer &gt; 2</label>
		</transition>
		'''
		lastTransistionState = getIdOfLocation('''«statement.device.name»_goto_«statement.target.name»_statment«statements.indexOf(statement)»''')
		currentDisc = statement.device.name
		return trans
	}
	
	
	def static dispatch String generateLocation(DiskMarkSlotOperation statement) {
		'''
		«IF statement.quantity > 0»
		<location id="«getIdOfLocation('''«statement.device.name»_markSlot«statement.diskSlotValue»In«statement.quantity»«statement.measure»_«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_markSlot«statement.diskSlotValue»In«statement.quantity»«statement.measure»_«statements.indexOf(statement)»</name>
		</location>
		«ENDIF»
		<location id="«getIdOfLocation('''«statement.device.name»_markSlot«statement.diskSlotValue»_statement«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_markSlot«statement.diskSlotValue»_statement«statements.indexOf(statement)»</name>
		</location>
		'''
	}
	
	def static dispatch String generateTransistion(DiskMarkSlotOperation statement) {
		val trans = '''
		«IF statement.quantity > 0»
		<transition>
			<source ref="«lastTransistionState»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_markSlot«statement.diskSlotValue»In«statement.quantity»«statement.measure»_«statements.indexOf(statement)»''')»"/>
			<label kind="assignment">timer = 0</label>
		</transition>
		<transition>
			<source ref="«getIdOfLocation('''«statement.device.name»_markSlot«statement.diskSlotValue»In«statement.quantity»«statement.measure»_«statements.indexOf(statement)»''')»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_markSlot«statement.diskSlotValue»_statement«statements.indexOf(statement)»''')»"/>
			<label kind="guard">timer &gt;= «statement.quantity»</label>
			<label kind="synchronisation">«statement.device.name»_set_«statement.diskSlotValue»[currentSlot]</label>
		</transition>
		«ELSE»
		<transition>
			<source ref="«lastTransistionState»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_markSlot«statement.diskSlotValue»_statement«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_set_«statement.diskSlotValue»[currentSlot]</label>
		</transition>
		«ENDIF»
		'''
		lastTransistionState = getIdOfLocation('''«getIdOfLocation('''«statement.device.name»_markSlot«statement.diskSlotValue»_statement«statements.indexOf(statement)»''')»''')
		return trans
	}
	
	def static dispatch String generateLocation(CameraScanOperation statement) {
		'''
		<location id="«getIdOfLocation('''«statement.device.name»_scanItem_«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_scanItem_«statements.indexOf(statement)»</name>
			<committed/>
		</location>
		<location id="«getIdOfLocation('''«statement.device.name»_itemColour_«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_itemColour_«statements.indexOf(statement)»</name>
		</location>
		<location id="«getIdOfLocation('''«statement.device.name»_setItemColour_«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_setItemColour_«statements.indexOf(statement)»</name>
		</location>
		'''
	}
	
	def static dispatch String generateTransistion(CameraScanOperation statement) {
		val trans = '''
		<transition>
			<source ref="«lastTransistionState»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_scanItem_«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_getColour!</label>
		</transition>
		<transition>
			<source ref="«getIdOfLocation('''«statement.device.name»_scanItem_«statements.indexOf(statement)»''')»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_itemColour_«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_gottenColour?</label>
		</transition>
		<transition>
			<source ref="«getIdOfLocation('''«statement.device.name»_itemColour_«statements.indexOf(statement)»''')»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_setItemColour_«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«currentDisc»_setColour[currentSlot][colour]!</label>
		</transition>
		'''
		lastTransistionState = getIdOfLocation('''«statement.device.name»_setItemColour_«statements.indexOf(statement)»''')
		return trans
	}
	
	def static dispatch String generateLocation(ForEach statement) {
		'''
		<location id="«getIdOfLocation('''«statement.device.name»_get«(statement.variableValue.value as DiskSlotStateValue).value»Slot_«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_get«(statement.variableValue.value as DiskSlotStateValue).value»Slot_«statements.indexOf(statement)»</name>
			<committed/>
		</location>
		<location id="«getIdOfLocation('''«statement.device.name»_gottenSlot«(statement.variableValue.value as DiskSlotStateValue).value»_«statements.indexOf(statement)»''')»">
			<name>«statement.device.name»_gottenSlot«(statement.variableValue.value as DiskSlotStateValue).value»_«statements.indexOf(statement)»</name>
		</location>
		«FOR s : statement.statements»
		«generateLocation(s)»
		«ENDFOR»
		'''
	}
	
	def static dispatch String generateTransistion(ForEach statement) {
		val returnTransistion = lastTransistionState
		val trans = '''
		<transition>
			<source ref="«lastTransistionState»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_get«(statement.variableValue.value as DiskSlotStateValue).value»Slot_«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_get«(statement.variableValue.value as DiskSlotStateValue).value»Slot!</label>
			<label kind="assignment">GlobalTimer = 0</label>
		</transition>
		<transition>
			<source ref="«getIdOfLocation('''«statement.device.name»_get«(statement.variableValue.value as DiskSlotStateValue).value»Slot_«statements.indexOf(statement)»''')»"/>
			<target ref="«getIdOfLocation('''«statement.device.name»_gottenSlot«(statement.variableValue.value as DiskSlotStateValue).value»_«statements.indexOf(statement)»''')»"/>
			<label kind="synchronisation">«statement.device.name»_found«(statement.variableValue.value as DiskSlotStateValue).value»Slot?</label>
		</transition>
		«FOR s : statement.statements»
		«statements.add(s)»
		«generateTransistion(s)»
		«ENDFOR»
		<transition>
			<source ref="«getIdOfLocation('''«statement.device.name»_get«(statement.variableValue.value as DiskSlotStateValue).value»Slot_«statements.indexOf(statement)»''')»"/>
			<target ref="«returnTransistion»"/>
			<label kind="guard">GlobalTimer &gt; 2</label>
		</transition>
		'''
		lastTransistionState = getIdOfLocation('''«statement.device.name»_gottenSlot«(statement.variableValue.value as DiskSlotStateValue).value»_«statements.indexOf(statement)»''')
		currentDisc = statement.device.name
		return trans
	}
}

