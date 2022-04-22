package xtext.factoryLang.generator.subgenerators

import xtext.factoryLang.factoryLang.Disk
import xtext.factoryLang.factoryLang.DiskSlotParameter
import static xtext.factoryLang.generator.subgenerators.UppaalGenerator.getIdOfLocation

class DiscGenerator {
	def static String generate(Disk disc){
		'''
		<template>
			<name>«disc.name»_�disc.name�</name>
			�FOR i : 1 ..(disc.targets.findFirst[it instanceof DiskSlotParameter] as DiskSlotParameter).size�
			<location id="�getIdOfLocation('''Position�i�''')�">
				<name>«disc.name»_Position�i�</name>
			</location>
			<location id="�getIdOfLocation('''AddItem�i�Req''')�">
				<name>«disc.name»_AddItem�i�Req</name>
			</location>
			<location id="�getIdOfLocation('''RemoveItem�i�Req''')�">
				<name>«disc.name»_RemoveItem�i�Req</name>
			</location>
			�ENDFOR�
			<location id="�getIdOfLocation('''�disc.name�_Stopped''')�">
				<name>«disc.name»_Stopped</name>
			</location>
			<init ref="�getIdOfLocation('''Position0''')�"/>
			�FOR i : 1 ..(disc.targets.findFirst[it instanceof DiskSlotParameter] as DiskSlotParameter).size�
			<transition>
				<source ref="�getIdOfLocation('''Position�i�''')�"/>
				<target ref="�getIdOfLocation('''�disc.name�_Stopped''')�"/>
				<label kind="synchronisation">emergencyStop?</label>
			</transition>
			<transition>
				<source ref="�getIdOfLocation('''Position�i�''')�"/>
				<target ref="�getIdOfLocation('''AddItem�i�Req''')�"/>
				<label kind="synchronisation">�disc.name�_addItemCmd?</label>
			</transition>
			<transition>
				<source ref="�getIdOfLocation('''Position�i�''')�"/>
				<target ref="�getIdOfLocation('''RemoveItem�i�Req''')�"/>
				<label kind="synchronisation">�disc.name�_removeItemCmd?</label>
			</transition>
			<transition>
				<source ref="�getIdOfLocation('''AddItem�i�Req''')�"/>
				<target ref="�getIdOfLocation('''Position�i�''')�"/>
				<label kind="synchronisation">�disc.name�_addItem[�i-1�]!</label>
			</transition>
			<transition>
				<source ref="�getIdOfLocation('''RemoveItem�i�Req''')�"/>
				<target ref="�getIdOfLocation('''Position�i�''')�"/>
				<label kind="synchronisation">�disc.name�_removeItem[�i-1�]!</label>
			</transition>
			�ENDFOR�
		</template>
		'''
	}
}