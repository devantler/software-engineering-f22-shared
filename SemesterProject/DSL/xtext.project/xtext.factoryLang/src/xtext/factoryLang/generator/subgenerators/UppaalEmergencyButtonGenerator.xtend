package xtext.factoryLang.generator.subgenerators

class UppaalEmergencyButtonGenerator {
	def static String generateUppaalEmergencyButtonTemplate(){
		'''
		<template>
			<name>EmergencyButton</name>
			<location id="«UppaalGenerator.getIdOfLocation("Running")»">
				<name>Running</name>
			</location>
			<location id="«UppaalGenerator.getIdOfLocation("Stopped")»">
				<name>Stopped</name>
			</location>
			<init ref="«UppaalGenerator.getIdOfLocation("Running")»"/>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation("Running")»"/>
				<target ref="«UppaalGenerator.getIdOfLocation("Stopped")»"/>
				<label kind="synchronisation">emergencyStop!</label>
			</transition>
		</template>
		'''
	}
}