package xtext.factoryLang.generator.subgenerators

import xtext.factoryLang.factoryLang.Disk

class DiscSlotGenerator {
	def static String generate(Disk disc){
		return
		'''
		<template>
			<name>«disc.name»_DiscSlot</name>
			<parameter>const «disc.name»_id_t id</parameter>
			<location id="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotEmpty''')»">
				<name>«disc.name»_SlotEmpty</name>
			</location>
			<location id="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFull''')»">
				<name>«disc.name»_SlotFull</name>
			</location>
			<location id="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullRed''')»">
				<name>«disc.name»_SlotFullRed</name>
			</location>
			<location id="«UppaalGenerator.getIdOfLocation('''«disc.name»_GetColourRed''')»">
				<name>«disc.name»_GetColourRed</name>
				<committed/>
			</location>
			<location id="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullGreen''')»">
				<name>«disc.name»_SlotFullGreen</name>
			</location>
			<location id="«UppaalGenerator.getIdOfLocation('''«disc.name»_GetColourGreen''')»">
				<name>«disc.name»_GetColourGreen</name>
				<committed/>
			</location>
			<location id="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullBlue''')»">
				<name>«disc.name»_SlotFullBlue</name>
			</location>
			<location id="«UppaalGenerator.getIdOfLocation('''«disc.name»_GetColourBlue''')»">
				<name>«disc.name»_GetColourBlue</name>
				<committed/>
			</location>
			<location id="«UppaalGenerator.getIdOfLocation('''«disc.name»_ErrorAddItemToFull''')»">
				<name>«disc.name»_ErrorAddItemToFull</name>
			</location>
			<location id="«UppaalGenerator.getIdOfLocation('''«disc.name»_ErrorRemoveItemFromEmpty''')»">
				<name>«disc.name»_ErrorRemoveItemFromEmpty</name>
			</location>
			<init ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotEmpty''')»"/>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotEmpty''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFull''')»"/>
				<label kind="synchronisation">«disc.name»_addItem[id]?</label>
				<label kind="assignment">«disc.name»_notemptySlots[id] = true</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFull''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullRed''')»"/>
				<label kind="synchronisation">«disc.name»_setColour[id][1]?</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullRed''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_GetColourRed''')»"/>
				<label kind="synchronisation">«disc.name»_getColourSlot[id]?</label>
				<label kind="assignment">currentSlot_colour = 1</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_GetColourRed''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullRed''')»"/>
				<label kind="synchronisation">«disc.name»_gottenColourSlot!</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFull''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullGreen''')»"/>
				<label kind="synchronisation">«disc.name»_setColour[id][2]?</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullGreen''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_GetColourGreen''')»"/>
				<label kind="synchronisation">«disc.name»_getColourSlot[id]?</label>
				<label kind="assignment">currentSlot_colour = 2</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_GetColourGreen''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullGreen''')»"/>
				<label kind="synchronisation">«disc.name»_gottenColourSlot!</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFull''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullBlue''')»"/>
				<label kind="synchronisation">«disc.name»_setColour[id][3]?</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullBlue''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_GetColourBlue''')»"/>
				<label kind="synchronisation">«disc.name»_getColourSlot[id]?</label>
				<label kind="assignment">currentSlot_colour = 3</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_GetColourBlue''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullBlue''')»"/>
				<label kind="synchronisation">«disc.name»_gottenColourSlot!</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFull''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotEmpty''')»"/>
				<label kind="synchronisation">«disc.name»_removeItem[id]?</label>
				<label kind="assignment">«disc.name»_notemptySlots[id] = false, «disc.name»_notcompleteSlots[id] = true</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullRed''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotEmpty''')»"/>
				<label kind="synchronisation">«disc.name»_removeItem[id]?</label>
				<label kind="assignment">«disc.name»_notemptySlots[id] = false, «disc.name»_notcompleteSlots[id] = true</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullGreen''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotEmpty''')»"/>
				<label kind="synchronisation">«disc.name»_removeItem[id]?</label>
				<label kind="assignment">«disc.name»_notemptySlots[id] = false, «disc.name»_notcompleteSlots[id] = true</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullBlue''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotEmpty''')»"/>
				<label kind="synchronisation">«disc.name»_removeItem[id]?</label>
				<label kind="assignment">«disc.name»_notemptySlots[id] = false, «disc.name»_notcompleteSlots[id] = true</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotEmpty''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_ErrorRemoveItemFromEmpty''')»"/>
				<label kind="synchronisation">«disc.name»_removeItem[id]?</label>
				<label kind="assignment">error += 1</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFull''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_ErrorAddItemToFull''')»"/>
				<label kind="synchronisation">«disc.name»_addItem[id]?</label>
				<label kind="assignment">error += 2</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullRed''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_ErrorAddItemToFull''')»"/>
				<label kind="synchronisation">«disc.name»_addItem[id]?</label>
				<label kind="assignment">error += 2</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullGreen''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_ErrorAddItemToFull''')»"/>
				<label kind="synchronisation">«disc.name»_addItem[id]?</label>
				<label kind="assignment">error += 2</label>
			</transition>
			<transition>
				<source ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_SlotFullBlue''')»"/>
				<target ref="«UppaalGenerator.getIdOfLocation('''«disc.name»_ErrorAddItemToFull''')»"/>
				<label kind="synchronisation">«disc.name»_addItem[id]?</label>
				<label kind="assignment">error += 2</label>
			</transition>
		</template>
		
		'''
	}
}