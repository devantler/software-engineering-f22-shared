package xtext.factoryLang.generator.subgenerators

import xtext.factoryLang.factoryLang.Disk
import static xtext.factoryLang.generator.subgenerators.UppaalGenerator.getIdOfLocation
import xtext.factoryLang.factoryLang.DiskSlotParameter

class DiscGetVariableGenerator {
	def static String generate(Disk disc, String variable){
		'''
		<template>
			<name>«disc.name»_Get«variable»Slot</name>
			<location id="«getIdOfLocation('''«disc.name»_Get«variable»Slot_Idle''')»">
				<name>«disc.name»_Idle</name>
			</location>
			«FOR i : 1 .. (disc.slotParameter as DiskSlotParameter).size»
			<location id="«getIdOfLocation('''«disc.name»_Get«i»''')»">
				<name>«disc.name»_Get«i»</name>
				<committed/>
			</location>
			«ENDFOR»
			<init ref="«getIdOfLocation('''«disc.name»_Get«variable»Slot_Idle''')»"/>
			«FOR i : 1 .. (disc.slotParameter as DiskSlotParameter).size»
			<transition>
				<source ref="«getIdOfLocation('''«disc.name»_Get«i»''')»"/>
				<target ref="«getIdOfLocation('''«disc.name»_Get«variable»Slot_Idle''')»"/>
				<label kind="synchronisation">«disc.name»_found«variable»Slot!</label>
				<label kind="assignment">currentSlot = «i-1»</label>
			</transition>
			<transition>
				<source ref="«getIdOfLocation('''«disc.name»_Get«variable»Slot_Idle''')»"/>
				<target ref="«getIdOfLocation('''«disc.name»_Get«i»''')»"/>
				<label kind="guard">!«disc.name»_not«variable»Slots[«i-1»]</label>
				<label kind="synchronisation">«disc.name»_get«variable»Slot?</label>
			</transition>
			«ENDFOR»
		</template>
		'''
	}
	
}