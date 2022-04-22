package xtext.factoryLang.generator.subgenerators

import xtext.factoryLang.factoryLang.Disk

class DiscVariableGenerator {
	def static String generate(Disk disc, String variable){
		return 
		'''
		<template>
			<name>«disc.name»_SlotVariable_«variable»</name>
			<parameter>const «disc.name»_id_t id</parameter>
			<location id="«UppaalGenerator.getIdOfLocation('''«disc.name»_Is«variable»''')»">
				<name>«disc.name»_Is«variable»</name>
			</location>
			<location id="«UppaalGenerator.getIdOfLocation('''«disc.name»_IsNot«variable»''')»">
				<name>«disc.name»_IsNot«variable»</name>
			</location>
			<init ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_IsNot«variable»''')»"/>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_IsNot«variable»''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_Is«variable»''')»"/>
				<label kind="synchronisation">«disc.name»set_«variable»[id]?</label>
				<label kind="assignment">«disc.name»_slots_«variable»[id] = true</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_Is«variable»''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_IsNot«variable»''')»"/>
				<label kind="synchronisation">«disc.name»set_«variable»[id]?</label>
				<label kind="assignment">«disc.name»_slots_«variable»[id] = false</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_Is«variable»''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_IsNot«variable»''')»"/>s
				<label kind="synchronisation">«disc.name»_removeItem[id]?</label>
				<label kind="assignment">«disc.name»_slots_«variable»[id] = false</label>
			</transition>
		</template>
		'''
	}
}