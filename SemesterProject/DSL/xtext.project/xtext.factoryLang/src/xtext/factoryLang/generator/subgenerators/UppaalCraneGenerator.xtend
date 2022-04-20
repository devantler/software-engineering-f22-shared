package xtext.factoryLang.generator.subgenerators

import xtext.factoryLang.factoryLang.Crane
import xtext.factoryLang.factoryLang.CranePositionParameter

class UppaalCraneGenerator {
	def static String generateUppaalCraneTemplate(Crane crane){
		return 
		'''
		<template>
			<name>«crane.name»</name>
			<declaration>
	        </declaration>
			«FOR position : crane.targets»
			<location id="«UppaalGenerator.getIdOfLocation(crane.name + "_" + (position as CranePositionParameter).name)»">
				<name>«crane.name»_«(position as CranePositionParameter).name»</name>
			</location>
			<location id="«UppaalGenerator.getIdOfLocation(crane.name + "_LoweredAt" + (position as CranePositionParameter).name)»">
				<name>«crane.name»_LoweredAt«(position as CranePositionParameter).name»</name>
			</location>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation(crane.name + "_" + (position as CranePositionParameter).name)»"/>
				<target ref="«UppaalGenerator.getIdOfLocation(crane.name + "_Stopped")»"/>
				<label kind="synchronisation">emergencyStop?</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation(crane.name + "_LoweredAt" + (position as CranePositionParameter).name)»"/>
				<target ref="«UppaalGenerator.getIdOfLocation(crane.name + "_Stopped")»"/>
				<label kind="synchronisation">emergencyStop?</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation(crane.name + "_" + (position as CranePositionParameter).name)»"/>
				<target ref="«UppaalGenerator.getIdOfLocation(crane.name + "_LoweredAt" + (position as CranePositionParameter).name)»"/>
				<label kind="synchronisation">«crane.name»crane_lowerMagnet?</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation(crane.name + "_LoweredAt" + (position as CranePositionParameter).name)»"/>
				<target ref="«UppaalGenerator.getIdOfLocation(crane.name + "_" + (position as CranePositionParameter).name)»"/>
				<label kind="synchronisation">«crane.name»crane_raiseMagnet?</label>
			</transition>
			«FOR otherposition : crane.targets»
			«IF otherposition != position»
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation(crane.name + "_" + (position as CranePositionParameter).name)»"/>
				<target ref="«UppaalGenerator.getIdOfLocation(crane.name + "_" + (otherposition as CranePositionParameter).name)»"/>
				<label kind="synchronisation">«crane.name»crane_goto_«(otherposition as CranePositionParameter).name»?</label>
			</transition>
			«ENDIF»
			«ENDFOR»
			«ENDFOR»
			<location id="«UppaalGenerator.getIdOfLocation(crane.name + "_Stopped")»">
				<name>«crane.name»_Stopped</name>
			</location>
			<init ref="«UppaalGenerator.getIdOfLocation(crane.name + "_" + (crane.targets.get(0) as CranePositionParameter).name)»"/>
		</template>
		'''
	}
}