package xtext.factoryLang.generator.subgenerators

import xtext.factoryLang.factoryLang.Disk
import xtext.factoryLang.factoryLang.DiskSlotParameter
import static xtext.factoryLang.generator.subgenerators.UppaalGenerator.getIdOfLocation

class DiscGenerator {
	def static String generate(Disk disc){
		'''
		<template>
			<name>«disc.name»</name>
			«FOR i : 1 ..(disc.slotParameter as DiskSlotParameter).size»
			<location id="«getIdOfLocation('''Position«i»''')»">
				<name>Position«i»</name>
			</location>
			<location id="«getIdOfLocation('''AddItem«i»Req''')»">
				<name>AddItem«i»Req</name>
				<committed/>
			</location>
			<location id="«getIdOfLocation('''RemoveItem«i»Req''')»">
				<name>RemoveItem«i»Req</name>
				<committed/>
			</location>
			«ENDFOR»
			<location id="«getIdOfLocation('''«disc.name»_Stopped''')»">
				<name>Stopped</name>
			</location>
			<init ref="«getIdOfLocation('''Position1''')»"/>
			«FOR i : 1 ..(disc.slotParameter as DiskSlotParameter).size»
			<transition>
				<source ref="«getIdOfLocation('''Position«i»''')»"/>
				<target ref="«getIdOfLocation('''«disc.name»_Stopped''')»"/>
				<label kind="synchronisation">emergencyStop?</label>
			</transition>
			<transition>
				<source ref="«getIdOfLocation('''Position«i»''')»"/>
				<target ref="«getIdOfLocation('''AddItem«i»Req''')»"/>
				<label kind="synchronisation">«disc.name»_addItemCmd?</label>
			</transition>
			<transition>
				<source ref="«getIdOfLocation('''Position«i»''')»"/>
				<target ref="«getIdOfLocation('''RemoveItem«i»Req''')»"/>
				<label kind="synchronisation">«disc.name»_removeItemCmd?</label>
			</transition>
			<transition>
				<source ref="«getIdOfLocation('''AddItem«i»Req''')»"/>
				<target ref="«getIdOfLocation('''Position«i»''')»"/>
				<label kind="synchronisation">«disc.name»_addItem[currentSlot]!</label>
			</transition>
			<transition>
				<source ref="«getIdOfLocation('''RemoveItem«i»Req''')»"/>
				<target ref="«getIdOfLocation('''Position«i»''')»"/>
				<label kind="synchronisation">«disc.name»_removeItem[currentSlot]!</label>
			</transition>
			«FOR j : 0 ..< (disc.slotParameter as DiskSlotParameter).size»
			<transition>
				<source ref="«getIdOfLocation('''Position«((i + j) % (disc.slotParameter as DiskSlotParameter).size) + 1»''')»"/>
				<target ref="«getIdOfLocation('''Position«i»''')»"/>
				<label kind="synchronisation">«disc.name»_goto[«i-1»]?</label>
			</transition>
			«ENDFOR»
			«ENDFOR»
		</template>
		'''
		//<label kind="assignment">currentSlot = «i-1»</label>
	}
}