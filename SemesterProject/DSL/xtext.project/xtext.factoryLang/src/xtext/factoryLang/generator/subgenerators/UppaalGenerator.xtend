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

class UppaalGenerator {
	def static generate(IFileSystemAccess2 fsa, Resource resource){
		val model = resource.allContents.filter(Model).next
		val discs = model.configurations.map[device].filter[it instanceof Disk].map[x|x as Disk]
		val cranes = model.configurations.map[device].filter[it instanceof Crane].map[x|x as Crane]
		val cameras = model.configurations.map[device].filter[it instanceof Camera].map[x|x as Camera]
		val discSlotStateValues = resource.allContents.filter(DiskSlotStateValue).map[value].toSet
		fsa.generateFile("uppaal/system.xml", 
			'''
			<?xml version="1.0" encoding="utf-8"?>
			<!DOCTYPE nta PUBLIC '-//Uppaal Team//DTD Flat System 1.1//EN' 'http://www.it.uu.se/research/group/darts/uppaal/flat-1_2.dtd'>
			<nta>
				<declaration>
			«FOR disc : discs»
			//«disc.name»
			
			const int «disc.name»_numberOfSlots = «(disc.slotParameter as DiskSlotParameter).size»;
			typedef int[0,«disc.name»numberOfSlots-1] id_t;
			chan «disc.name»goto[«disc.name»numberOfSlots];
			chan «disc.name»addItemCmd, «disc.name»removeItemCmd;
			chan «disc.name»addItem[«disc.name»numberOfSlots];
			broadcast chan «disc.name»removeItem[«disc.name»numberOfSlots];
			
			//default tags
			chan «disc.name»getFreeSlot;
			chan «disc.name»foundEmptySlot;
			chan «disc.name»setColour[«disc.name»numberOfSlots][4];
			bool «disc.name»occupiedSlots[«disc.name»numberOfSlots];
			chan «disc.name»getColourSlot[«disc.name»numberOfSlots];
			chan «disc.name»gottenColourSlot;
			
			«FOR value : discSlotStateValues»
			//«value» tag
			chan «disc.name»set_«value»[«disc.name»numberOfSlots];
			chan «disc.name»getSlot_«value»;
			chan «disc.name»foundSlot_«value»;
			bool «disc.name»slots_«value»[«disc.name»numberOfSlots];
			«ENDFOR»
			
			//Zones: 
			«FOR zone : disc.targets.filter[it instanceof DiskZoneParameter].map[it as DiskZoneParameter]»
			int «disc.name»_zones_«zone.name» = «zone.slot»;
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
			
			//-----------------current slots-----------------------------
			int currentSlot_empty = -1;
			int currentSlot_finished = -1;
			
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
					<location id="id0" x="700" y="212">
						<name x="690" y="182">Idle</name>
					</location>
					<location id="id1" x="850" y="212">
						<name x="840" y="182">getEmptySlot</name>
						<committed/>
					</location>
					<location id="id2" x="864" y="73">
						<name x="854" y="43">slotEmpty</name>
					</location>
					<location id="id3" x="1059" y="81">
						<name x="1049" y="51">gotoIntake</name>
					</location>
					<location id="id4" x="1229" y="183">
						<name x="1219" y="153">fillSlot</name>
					</location>
					<location id="id5" x="1263" y="353">
						<name x="1253" y="323">gotoCamera</name>
					</location>
					<location id="id6" x="1000" y="512">
						<name x="990" y="482">scanItem</name>
						<committed/>
					</location>
					<location id="id7" x="850" y="512">
						<name x="840" y="482">itemColour</name>
					</location>
					<location id="id8" x="595" y="518">
						<name x="570" y="476">setItemColour</name>
					</location>
					<location id="id9" x="416" y="263">
						<name x="406" y="229">markSlotFinishedIn10Seconds</name>
					</location>
					<location id="id10" x="357" y="535">
						<name x="272" y="552">markSlotFinishedIn20Seconds</name>
					</location>
					<location id="id11" x="467" y="680">
						<name x="457" y="646">markSlotFinishedIn30Seconds</name>
					</location>
					<location id="id12" x="289" y="161">
						<name x="279" y="127">SetFinsihedRed</name>
					</location>
					<location id="id13" x="153" y="544">
						<name x="143" y="510">setFinishedGreen</name>
					</location>
					<location id="id14" x="263" y="722">
						<name x="253" y="688">setFinishedBlue</name>
					</location>
					<location id="id15" x="527" y="68">
						<name x="517" y="34">getFinishedSlot</name>
						<committed/>
					</location>
					<location id="id16" x="357" y="-17">
						<name x="347" y="-51">slotFinished</name>
					</location>
					<location id="id17" x="382" y="-102">
						<name x="372" y="-136">gotoCrane</name>
					</location>
					<location id="id18" x="561" y="-144">
						<name x="551" y="-178">gotoIntake_crane</name>
					</location>
					<location id="id19" x="765" y="-136">
						<name x="755" y="-170">craneLower</name>
					</location>
					<location id="id20" x="926" y="-127">
						<name x="916" y="-161">toggleMagnet_crane</name>
					</location>
					<location id="id21" x="1096" y="-119">
						<name x="1086" y="-153">getColourOfSlot</name>
						<committed/>
					</location>
					<location id="id22" x="1300" y="-136">
						<name x="1300" y="-136">thingIsRed</name>
					</location>
					<location id="id23" x="1292" y="-93">
						<name x="1292" y="-93">thingIsGreen</name>
					</location>
					<location id="id24" x="1275" y="-34">
						<name x="1275" y="-34">thingIsBlue</name>
					</location>
					<location id="id25" x="1453" y="-127">
						<name x="1443" y="-161">gotoRed_crane</name>
					</location>
					<location id="id26" x="1436" y="-76">
						<name x="1426" y="-110">gotoGreen_crane</name>
					</location>
					<location id="id27" x="1411" y="0">
						<name x="1401" y="-34">gotoBlue_crane</name>
					</location>
					<location id="id28" x="1360" y="110">
						<name x="1350" y="76">craneLowerBlue</name>
					</location>
					<location id="id29" x="1419" y="110">
						<name x="1409" y="76">craneLowerGreen</name>
					</location>
					<location id="id30" x="1462" y="110">
						<name x="1452" y="76">craneLowerRed</name>
					</location>
					<location id="id31" x="1360" y="187">
						<name x="1350" y="153">toggleMagnetBlue</name>
					</location>
					<location id="id32" x="1419" y="178">
						<name x="1409" y="144">toggleMagnetGreen</name>
					</location>
					<location id="id33" x="1470" y="187">
						<name x="1460" y="153">toggleMagnetRed</name>
					</location>
					<location id="id34" x="1419" y="289">
						<name x="1409" y="255">EndIf</name>
					</location>
					<location id="id35" x="1419" y="374">
						<name x="1409" y="340">markEmpty</name>
					</location>
					<location id="id36" x="323" y="297">
						<name x="313" y="263">IdleTime1</name>
					</location>
					<location id="id37" x="357" y="476">
						<name x="347" y="442">IdleTime2</name>
					</location>
					<location id="id38" x="535" y="705">
						<name x="525" y="671">IdleTime3</name>
					</location>
					<location id="id39" x="1011" y="-93">
						<name x="1001" y="-127">craneRaise</name>
					</location>
					<location id="id40" x="1513" y="297">
						<name x="1503" y="263">craneRaise1</name>
					</location>
					<init ref="id0"/>
					<transition>
						<source ref="id40"/>
						<target ref="id35"/>
						<label kind="synchronisation" x="1437" y="318">«disc.name»removeItem[currentSlot_finished]!</label>
					</transition>
					<transition>
						<source ref="id34"/>
						<target ref="id40"/>
						<label kind="synchronisation" x="1437" y="276">crane_raiseMagnet!</label>
					</transition>
					<transition>
						<source ref="id38"/>
						<target ref="id11"/>
					</transition>
					<transition>
						<source ref="id11"/>
						<target ref="id38"/>
						<label kind="guard" x="501" y="692">timer &lt; 30</label>
					</transition>
					<transition>
						<source ref="id37"/>
						<target ref="id10"/>
					</transition>
					<transition>
						<source ref="id10"/>
						<target ref="id37"/>
						<label kind="guard" x="357" y="505">timer &lt; 20</label>
					</transition>
					<transition>
						<source ref="id36"/>
						<target ref="id9"/>
					</transition>
					<transition>
						<source ref="id9"/>
						<target ref="id36"/>
						<label kind="guard" x="369" y="280">timer &lt; 10</label>
					</transition>
					<transition>
						<source ref="id1"/>
						<target ref="id0"/>
						<label kind="guard" x="718" y="148">GlobalTimer &gt; 2</label>
						<nail x="790" y="153"/>
					</transition>
					<transition>
						<source ref="id15"/>
						<target ref="id0"/>
						<label kind="guard" x="545" y="51">GlobalTimer &gt; 2</label>
						<nail x="697" y="102"/>
					</transition>
					<transition>
						<source ref="id35"/>
						<target ref="id0"/>
					</transition>
					<transition>
						<source ref="id33"/>
						<target ref="id34"/>
					</transition>
					<transition>
						<source ref="id32"/>
						<target ref="id34"/>
					</transition>
					<transition>
						<source ref="id31"/>
						<target ref="id34"/>
					</transition>
					<transition>
						<source ref="id30"/>
						<target ref="id33"/>
						<label kind="synchronisation" x="1466" y="131">crane_toggleMagnet!</label>
					</transition>
					<transition>
						<source ref="id29"/>
						<target ref="id32"/>
						<label kind="synchronisation" x="1419" y="127">crane_toggleMagnet!</label>
					</transition>
					<transition>
						<source ref="id28"/>
						<target ref="id31"/>
						<label kind="synchronisation" x="1360" y="131">crane_toggleMagnet!</label>
					</transition>
					<transition>
						<source ref="id25"/>
						<target ref="id30"/>
						<label kind="synchronisation" x="1457" y="-25">crane_lowerMagnet!</label>
					</transition>
					<transition>
						<source ref="id26"/>
						<target ref="id29"/>
						<label kind="synchronisation" x="1427" y="0">crane_lowerMagnet!</label>
					</transition>
					<transition>
						<source ref="id27"/>
						<target ref="id28"/>
						<label kind="synchronisation" x="1385" y="38">crane_lowerMagnet!</label>
					</transition>
					<transition>
						<source ref="id24"/>
						<target ref="id27"/>
						<label kind="synchronisation" x="1293" y="-34">crane_goto_blue!</label>
					</transition>
					<transition>
						<source ref="id23"/>
						<target ref="id26"/>
						<label kind="synchronisation" x="1310" y="-101">crane_goto_green!</label>
					</transition>
					<transition>
						<source ref="id22"/>
						<target ref="id25"/>
						<label kind="synchronisation" x="1318" y="-148">crane_goto_red!</label>
					</transition>
					<transition>
						<source ref="id21"/>
						<target ref="id24"/>
						<label kind="guard" x="1114" y="-110">currentSlot_colour == 3</label>
						<label kind="synchronisation" x="1114" y="-93">«disc.name»gottenColourSlot?</label>
					</transition>
					<transition>
						<source ref="id21"/>
						<target ref="id23"/>
						<label kind="guard" x="1114" y="-140">currentSlot_colour == 2</label>
						<label kind="synchronisation" x="1114" y="-123">«disc.name»gottenColourSlot?</label>
					</transition>
					<transition>
						<source ref="id21"/>
						<target ref="id22"/>
						<label kind="guard" x="1114" y="-161">currentSlot_colour == 1</label>
						<label kind="synchronisation" x="1114" y="-144">«disc.name»gottenColourSlot?</label>
					</transition>
					<transition>
						<source ref="id20"/>
						<target ref="id39"/>
						<label kind="synchronisation" x="968" y="-110">crane_raiseMagnet!</label>
					</transition>
					<transition>
						<source ref="id39"/>
						<target ref="id21"/>
						<label kind="synchronisation" x="1053" y="-106">«disc.name»getColourSlot[currentSlot_finished]!</label>
					</transition>
					<transition>
						<source ref="id19"/>
						<target ref="id20"/>
						<label kind="synchronisation" x="783" y="-148">crane_toggleMagnet!</label>
					</transition>
					<transition>
						<source ref="id18"/>
						<target ref="id19"/>
						<label kind="synchronisation" x="579" y="-157">crane_lowerMagnet!</label>
					</transition>
					<transition>
						<source ref="id17"/>
						<target ref="id18"/>
						<label kind="synchronisation" x="400" y="-140">crane_goto_intake!</label>
					</transition>
					<transition>
						<source ref="id16"/>
						<target ref="id17"/>
						<label kind="synchronisation" x="369" y="-76">«disc.name»goto[(zones_crane + currentSlot_finished) % «disc.name»numberOfSlots]!</label>
					</transition>
					<transition>
						<source ref="id15"/>
						<target ref="id16"/>
						<label kind="synchronisation" x="375" y="8">«disc.name»foundSlot_finished?</label>
					</transition>
					<transition>
						<source ref="id0"/>
						<target ref="id15"/>
						<label kind="synchronisation" x="545" y="123">«disc.name»getSlot_finished!</label>
						<label kind="assignment" x="545" y="140">GlobalTimer = 0</label>
					</transition>
					<transition>
						<source ref="id14"/>
						<target ref="id0"/>
					</transition>
					<transition>
						<source ref="id13"/>
						<target ref="id0"/>
					</transition>
					<transition>
						<source ref="id12"/>
						<target ref="id0"/>
					</transition>
					<transition>
						<source ref="id11"/>
						<target ref="id14"/>
						<label kind="guard" x="281" y="667">timer &gt;= 30</label>
						<label kind="synchronisation" x="281" y="684">«disc.name»set_finished[currentSlot_empty]!</label>
					</transition>
					<transition>
						<source ref="id10"/>
						<target ref="id13"/>
						<label kind="guard" x="171" y="505">timer &gt;= 20</label>
						<label kind="synchronisation" x="171" y="522">«disc.name»set_finished[currentSlot_empty]!</label>
					</transition>
					<transition>
						<source ref="id9"/>
						<target ref="id12"/>
						<label kind="guard" x="307" y="178">timer &gt;= 10</label>
						<label kind="synchronisation" x="307" y="195">«disc.name»set_finished[currentSlot_empty]!</label>
					</transition>
					<transition>
						<source ref="id8"/>
						<target ref="id11"/>
						<label kind="guard" x="501" y="586">colour == 3</label>
						<label kind="assignment" x="518" y="603">timer = 0</label>
					</transition>
					<transition>
						<source ref="id8"/>
						<target ref="id10"/>
						<label kind="guard" x="399" y="476">colour == 2</label>
						<label kind="assignment" x="468" y="488">timer = 0</label>
					</transition>
					<transition>
						<source ref="id8"/>
						<target ref="id9"/>
						<label kind="guard" x="493" y="357">colour == 1</label>
						<label kind="assignment" x="493" y="340">timer = 0</label>
					</transition>
					<transition>
						<source ref="id7"/>
						<target ref="id8"/>
						<label kind="synchronisation" x="678" y="496">«disc.name»setColour[currentSlot_empty][colour]!</label>
					</transition>
					<transition>
						<source ref="id1"/>
						<target ref="id2"/>
						<label kind="synchronisation" x="991" y="191">«disc.name»foundEmptySlot?</label>
					</transition>
					<transition>
						<source ref="id2"/>
						<target ref="id3"/>
						<label kind="synchronisation" x="918" y="25">«disc.name»goto[(zones_intake + currentSlot_empty) % «disc.name»numberOfSlots]!</label>
					</transition>
					<transition>
						<source ref="id3"/>
						<target ref="id4"/>
						<label kind="synchronisation" x="1204" y="242">«disc.name»addItem[currentSlot_empty]!</label>
					</transition>
					<transition>
						<source ref="id4"/>
						<target ref="id5"/>
					</transition>
					<transition>
						<source ref="id5"/>
						<target ref="id6"/>
						<label kind="synchronisation" x="940" y="422">camera_getColour!</label>
					</transition>
					<transition>
						<source ref="id6"/>
						<target ref="id7"/>
						<label kind="synchronisation" x="881" y="514">camera_gottenColour?</label>
					</transition>
					<transition>
						<source ref="id0"/>
						<target ref="id1"/>
						<label kind="synchronisation" x="715" y="197">«disc.name»getFreeSlot!</label>
						<label kind="assignment" x="718" y="212">GlobalTimer = 0</label>
					</transition>
				</template>
				<template>
					<name>Camera</name>
					<location id="id41" x="40" y="80">
						<name x="30" y="50">Idle</name>
					</location>
					<location id="id42" x="190" y="80">
						<name x="180" y="50">Red</name>
						<committed/>
					</location>
					<location id="id43" x="190" y="230">
						<name x="180" y="200">Green</name>
						<committed/>
					</location>
					<location id="id44" x="40" y="230">
						<name x="30" y="200">Blue</name>
						<committed/>
					</location>
					<init ref="id41"/>
					<transition>
						<source ref="id44"/>
						<target ref="id41"/>
						<label kind="synchronisation" x="-20" y="140">camera_gottenColour!</label>
					</transition>
					<transition>
						<source ref="id41"/>
						<target ref="id44"/>
						<label kind="synchronisation" x="-20" y="140">camera_getColour?</label>
						<label kind="assignment" x="-20" y="155">colour = 3</label>
					</transition>
					<transition>
						<source ref="id43"/>
						<target ref="id41"/>
						<label kind="synchronisation" x="55" y="140">camera_gottenColour!</label>
					</transition>
					<transition>
						<source ref="id41"/>
						<target ref="id43"/>
						<label kind="synchronisation" x="55" y="140">camera_getColour?</label>
						<label kind="assignment" x="55" y="155">colour=2</label>
					</transition>
					<transition>
						<source ref="id42"/>
						<target ref="id41"/>
						<label kind="synchronisation" x="55" y="65">camera_gottenColour!</label>
					</transition>
					<transition>
						<source ref="id41"/>
						<target ref="id42"/>
						<label kind="synchronisation" x="55" y="65">camera_getColour?</label>
						<label kind="assignment" x="55" y="80">colour = 1</label>
					</transition>
				</template>
				<template>
					<name>GetEmptySlot</name>
					<location id="id45" x="40" y="80">
						<name x="30" y="50">Idle</name>
					</location>
					<location id="id46" x="190" y="80">
						<name x="180" y="50">Get4</name>
						<committed/>
					</location>
					<location id="id47" x="190" y="230">
						<name x="180" y="200">Get1</name>
						<committed/>
					</location>
					<location id="id48" x="40" y="230">
						<name x="30" y="200">Get2</name>
						<committed/>
					</location>
					<location id="id49" x="340" y="80">
						<name x="330" y="50">Get3</name>
						<committed/>
					</location>
					<init ref="id45"/>
					<transition>
						<source ref="id46"/>
						<target ref="id45"/>
						<label kind="synchronisation" x="55" y="65">«disc.name»foundEmptySlot!</label>
						<label kind="assignment" x="55" y="80">currentSlot_empty = 3</label>
					</transition>
					<transition>
						<source ref="id45"/>
						<target ref="id46"/>
						<label kind="guard" x="55" y="50">!«disc.name»occupiedSlots[3]</label>
						<label kind="synchronisation" x="55" y="65">«disc.name»getFreeSlot?</label>
					</transition>
					<transition>
						<source ref="id49"/>
						<target ref="id45"/>
						<label kind="synchronisation" x="130" y="65">«disc.name»foundEmptySlot!</label>
						<label kind="assignment" x="130" y="80">currentSlot_empty = 2</label>
					</transition>
					<transition>
						<source ref="id45"/>
						<target ref="id49"/>
						<label kind="guard" x="130" y="50">!«disc.name»occupiedSlots[2]</label>
						<label kind="synchronisation" x="130" y="65">«disc.name»getFreeSlot?</label>
					</transition>
					<transition>
						<source ref="id48"/>
						<target ref="id45"/>
						<label kind="synchronisation" x="-20" y="140">«disc.name»foundEmptySlot!</label>
						<label kind="assignment" x="-20" y="155">currentSlot_empty = 1</label>
					</transition>
					<transition>
						<source ref="id45"/>
						<target ref="id48"/>
						<label kind="guard" x="-20" y="125">!«disc.name»occupiedSlots[1]</label>
						<label kind="synchronisation" x="-20" y="140">«disc.name»getFreeSlot?</label>
					</transition>
					<transition>
						<source ref="id47"/>
						<target ref="id45"/>
						<label kind="synchronisation" x="55" y="140">«disc.name»foundEmptySlot!</label>
						<label kind="assignment" x="55" y="155">currentSlot_empty = 0</label>
					</transition>
					<transition>
						<source ref="id45"/>
						<target ref="id47"/>
						<label kind="guard" x="55" y="125">!«disc.name»occupiedSlots[0]</label>
						<label kind="synchronisation" x="55" y="140">«disc.name»getFreeSlot?</label>
					</transition>
				</template>
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
					<name>Disc</name>
					<location id="id55" x="40" y="80">
						<name x="30" y="50">Position1</name>
					</location>
					<location id="id56" x="190" y="80">
						<name x="180" y="50">Position2</name>
					</location>
					<location id="id57" x="190" y="230">
						<name x="180" y="200">Position3</name>
					</location>
					<location id="id58" x="40" y="230">
						<name x="30" y="200">Position4</name>
					</location>
					<location id="id59" x="340" y="80">
						<name x="330" y="50">AddItem1Req</name>
					</location>
					<location id="id60" x="340" y="230">
						<name x="330" y="200">RemoveItem1Req</name>
					</location>
					<location id="id61" x="340" y="380">
						<name x="330" y="350">AddItem2Req</name>
					</location>
					<location id="id62" x="190" y="380">
						<name x="180" y="350">RemoveItem2Req</name>
					</location>
					<location id="id63" x="40" y="380">
						<name x="30" y="350">AddItem3Req</name>
					</location>
					<location id="id64" x="490" y="80">
						<name x="480" y="50">RemoveItem3Req</name>
					</location>
					<location id="id65" x="490" y="230">
						<name x="480" y="200">AddItem4Req</name>
					</location>
					<location id="id66" x="490" y="380">
						<name x="480" y="350">RemoveItem4Req</name>
					</location>
					<location id="id67" x="-238" y="68">
						<name x="-238" y="68">Stopped</name>
					</location>
					<init ref="id55"/>
					<transition>
						<source ref="id57"/>
						<target ref="id67"/>
						<label kind="synchronisation" x="-24" y="149">emergencyStop?</label>
					</transition>
					<transition>
						<source ref="id56"/>
						<target ref="id67"/>
						<label kind="synchronisation" x="-24" y="74">emergencyStop?</label>
					</transition>
					<transition>
						<source ref="id55"/>
						<target ref="id67"/>
						<label kind="synchronisation" x="-99" y="74">emergencyStop?</label>
					</transition>
					<transition>
						<source ref="id58"/>
						<target ref="id67"/>
						<label kind="synchronisation" x="-99" y="149">emergencyStop?</label>
					</transition>
					<transition>
						<source ref="id58"/>
						<target ref="id56"/>
						<label kind="synchronisation" x="55" y="140">«disc.name»goto[1]?</label>
					</transition>
					<transition>
						<source ref="id56"/>
						<target ref="id58"/>
						<label kind="synchronisation" x="55" y="140">«disc.name»goto[3]?</label>
					</transition>
					<transition>
						<source ref="id55"/>
						<target ref="id57"/>
						<label kind="synchronisation" x="55" y="140">«disc.name»goto[2]?</label>
					</transition>
					<transition>
						<source ref="id57"/>
						<target ref="id55"/>
						<label kind="synchronisation" x="55" y="140">«disc.name»goto[0]?</label>
					</transition>
					<transition>
						<source ref="id58"/>
						<target ref="id57"/>
						<label kind="synchronisation" x="55" y="215">«disc.name»goto[2]?</label>
					</transition>
					<transition>
						<source ref="id55"/>
						<target ref="id58"/>
						<label kind="synchronisation" x="-20" y="140">«disc.name»goto[3]?</label>
					</transition>
					<transition>
						<source ref="id56"/>
						<target ref="id55"/>
						<label kind="synchronisation" x="55" y="65">«disc.name»goto[0]?</label>
					</transition>
					<transition>
						<source ref="id57"/>
						<target ref="id56"/>
						<label kind="synchronisation" x="130" y="140">«disc.name»goto[1]?</label>
					</transition>
					<transition>
						<source ref="id55"/>
						<target ref="id56"/>
						<label kind="synchronisation" x="55" y="65">«disc.name»goto[1]?</label>
					</transition>
					<transition>
						<source ref="id58"/>
						<target ref="id55"/>
						<label kind="synchronisation" x="-20" y="140">«disc.name»goto[0]?</label>
					</transition>
					<transition>
						<source ref="id57"/>
						<target ref="id58"/>
						<label kind="synchronisation" x="55" y="215">«disc.name»goto[3]?</label>
					</transition>
					<transition>
						<source ref="id56"/>
						<target ref="id57"/>
						<label kind="synchronisation" x="130" y="140">«disc.name»goto[2]?</label>
					</transition>
					<transition>
						<source ref="id55"/>
						<target ref="id55"/>
						<label kind="synchronisation" x="40" y="80">«disc.name»goto[0]?</label>
						<nail x="10" y="50"/>
						<nail x="70" y="50"/>
					</transition>
					<transition>
						<source ref="id56"/>
						<target ref="id56"/>
						<label kind="synchronisation" x="190" y="80">«disc.name»goto[1]?</label>
						<nail x="160" y="50"/>
						<nail x="220" y="50"/>
					</transition>
					<transition>
						<source ref="id57"/>
						<target ref="id57"/>
						<label kind="synchronisation" x="190" y="230">«disc.name»goto[2]?</label>
						<nail x="160" y="200"/>
						<nail x="220" y="200"/>
					</transition>
					<transition>
						<source ref="id58"/>
						<target ref="id58"/>
						<label kind="synchronisation" x="40" y="230">«disc.name»goto[3]?</label>
						<nail x="10" y="200"/>
						<nail x="70" y="200"/>
					</transition>
					<transition>
						<source ref="id55"/>
						<target ref="id59"/>
						<label kind="synchronisation" x="130" y="65">«disc.name»addItemCmd?</label>
					</transition>
					<transition>
						<source ref="id55"/>
						<target ref="id60"/>
						<label kind="synchronisation" x="130" y="140">«disc.name»removeItemCmd?</label>
					</transition>
					<transition>
						<source ref="id56"/>
						<target ref="id61"/>
						<label kind="synchronisation" x="205" y="215">«disc.name»addItemCmd?</label>
					</transition>
					<transition>
						<source ref="id56"/>
						<target ref="id62"/>
						<label kind="synchronisation" x="130" y="215">«disc.name»removeItemCmd?</label>
					</transition>
					<transition>
						<source ref="id57"/>
						<target ref="id63"/>
						<label kind="synchronisation" x="55" y="290">«disc.name»addItemCmd?</label>
					</transition>
					<transition>
						<source ref="id57"/>
						<target ref="id64"/>
						<label kind="synchronisation" x="280" y="140">«disc.name»removeItemCmd?</label>
					</transition>
					<transition>
						<source ref="id58"/>
						<target ref="id65"/>
						<label kind="synchronisation" x="205" y="215">«disc.name»addItemCmd?</label>
					</transition>
					<transition>
						<source ref="id58"/>
						<target ref="id66"/>
						<label kind="synchronisation" x="205" y="290">«disc.name»removeItemCmd?</label>
					</transition>
					<transition>
						<source ref="id59"/>
						<target ref="id55"/>
						<label kind="synchronisation" x="130" y="65">«disc.name»addItem[0]!</label>
					</transition>
					<transition>
						<source ref="id60"/>
						<target ref="id55"/>
						<label kind="synchronisation" x="130" y="140">«disc.name»removeItem[0]!</label>
					</transition>
					<transition>
						<source ref="id61"/>
						<target ref="id56"/>
						<label kind="synchronisation" x="205" y="215">«disc.name»addItem[1]!</label>
					</transition>
					<transition>
						<source ref="id62"/>
						<target ref="id56"/>
						<label kind="synchronisation" x="130" y="215">«disc.name»removeItem[1]!</label>
					</transition>
					<transition>
						<source ref="id63"/>
						<target ref="id57"/>
						<label kind="synchronisation" x="55" y="290">«disc.name»addItem[2]!</label>
					</transition>
					<transition>
						<source ref="id64"/>
						<target ref="id57"/>
						<label kind="synchronisation" x="280" y="140">«disc.name»removeItem[2]!</label>
					</transition>
					<transition>
						<source ref="id65"/>
						<target ref="id58"/>
						<label kind="synchronisation" x="205" y="215">«disc.name»addItem[3]!</label>
					</transition>
					<transition>
						<source ref="id66"/>
						<target ref="id58"/>
						<label kind="synchronisation" x="205" y="290">«disc.name»removeItem[3]!</label>
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
}