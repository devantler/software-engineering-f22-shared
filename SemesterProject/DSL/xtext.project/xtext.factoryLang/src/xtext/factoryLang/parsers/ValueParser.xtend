package xtext.factoryLang.parsers

import xtext.factoryLang.factoryLang.VariableValue
import xtext.factoryLang.factoryLang.DiskSlotStateValue
import xtext.factoryLang.factoryLang.ColorValue
import xtext.factoryLang.factoryLang.DiskStateValue
import xtext.factoryLang.factoryLang.Number
import xtext.factoryLang.factoryLang.DeviceValue
import xtext.factoryLang.factoryLang.CranePositionParameter
import xtext.factoryLang.factoryLang.DiskZoneParameter

class ValueParser {
	def static CharSequence parseDeviceValue(DeviceValue deviceValue, boolean asCode) {
		switch deviceValue.ref {
			CranePositionParameter: (deviceValue.ref as CranePositionParameter).name
			DiskZoneParameter: (deviceValue.ref as DiskZoneParameter).name
		}

		switch deviceValue.value {
			DiskStateValue:
				EnumParser.parseDiskState((deviceValue.value as DiskStateValue).value, asCode)
			ColorValue:
				EnumParser.parseColor((deviceValue.value as ColorValue).value, asCode)
		}
	}

	def static CharSequence parseVariableValue(VariableValue variableValue, boolean asCode) {
		if (variableValue.ref !== null) {
			return variableValue.ref.name
		}

		switch variableValue.value {
			DiskSlotStateValue:
				EnumParser.parseDiskSlotState((variableValue.value as DiskSlotStateValue).value)
			ColorValue:
				EnumParser.parseColor((variableValue.value as ColorValue).value, asCode)
			Number: asCode ? "HasMark(" + (variableValue.value as Number).value + ")" : (variableValue.value as Number).value.toString
			DiskStateValue:
				EnumParser.parseDiskState((variableValue.value as DiskStateValue).value, asCode)
		}
	}
}
