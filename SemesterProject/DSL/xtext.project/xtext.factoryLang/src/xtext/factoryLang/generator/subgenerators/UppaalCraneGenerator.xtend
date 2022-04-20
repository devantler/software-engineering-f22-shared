package xtext.factoryLang.generator.subgenerators

import xtext.factoryLang.factoryLang.Crane

class UppaalCraneGenerator {
	def static String generateUppaalCraneTemplate(Crane crane){
		return '''
		<template>
			<name>«crane.name»</name>
			<declaration>
	        </declaration>
			<location id="id80">
				<name>«crane.name»_Intake</name>
			</location>
			<location id="id81">
				<name>Red</name>
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
		'''
	}
}