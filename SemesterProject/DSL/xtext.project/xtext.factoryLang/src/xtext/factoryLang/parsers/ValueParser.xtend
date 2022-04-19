package xtext.factoryLang.parsers

import xtext.factoryLang.factoryLang.VariableValue
import xtext.factoryLang.factoryLang.DiskSlotStateValue
import xtext.factoryLang.factoryLang.ColorValue
import xtext.factoryLang.factoryLang.DiskStateValue
import xtext.factoryLang.factoryLang.DISK_SLOT_STATES
import xtext.factoryLang.factoryLang.COLOR
import xtext.factoryLang.factoryLang.DISK_STATES
import xtext.factoryLang.factoryLang.Number
import xtext.factoryLang.factoryLang.DeviceValue
import xtext.factoryLang.factoryLang.CranePositionParameter
import xtext.factoryLang.factoryLang.DiskZoneParameter

class ValueParser {
	def static CharSequence parseDeviceValue(DeviceValue deviceValue) {
		switch deviceValue.ref {
			CranePositionParameter: (deviceValue.ref as CranePositionParameter).name
			DiskZoneParameter: (deviceValue.ref as DiskZoneParameter).name
		}
		
		switch deviceValue.value {
			DiskStateValue:
				parseDiskStateValue((deviceValue.value as DiskStateValue).value)
			ColorValue:
				parseColorValue((deviceValue.value as ColorValue).value)
		}
	}

	def static CharSequence parseVariableValue(VariableValue variableValue) {
		if (variableValue.ref !== null) {
			return variableValue.ref.name
		}

		switch variableValue.value {
			DiskSlotStateValue:
				parseDiskSlotStateValue((variableValue.value as DiskSlotStateValue).value)
			ColorValue:
				parseColorValue((variableValue.value as ColorValue).value)
			Number: '''HasMark(«(variableValue.value as Number).value»)'''
			DiskStateValue:
				parseDiskStateValue((variableValue.value as DiskStateValue).value)
		}
	}

	def static CharSequence parseDiskSlotStateValue(DISK_SLOT_STATES diskSlotState) {
		switch diskSlotState {
			case DISK_SLOT_STATES.FREE: "HasMark('free')"
			case DISK_SLOT_STATES.IN_PROGRESS: "HasMark('in-progress')"
			case DISK_SLOT_STATES.COMPLETE: "HasMark('complete')"
		}
	}

	def static CharSequence parseColorValue(COLOR color) {
		switch color {
			case COLOR.RED: "HasMark('red')"
			case COLOR.GREEN: "HasMark('green')"
			case COLOR.BLUE: "HasMark('blue')"
		}
	}

	def static CharSequence parseDiskStateValue(DISK_STATES diskState) {
		switch diskState {
			case DISK_STATES.FULL: "IsFull()"
			case DISK_STATES.EMPTY: "IsEmpty()"
		}
	}
}
