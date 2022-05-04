package xtext.factoryLang.parsers

import xtext.factoryLang.factoryLang.DISK_SLOT_STATES
import xtext.factoryLang.factoryLang.COLOR
import xtext.factoryLang.factoryLang.DISK_STATES
import xtext.factoryLang.factoryLang.COMPARISON_OPERATOR
import xtext.factoryLang.factoryLang.ForEach
import xtext.factoryLang.factoryLang.DiskMarkSlotOperation
import xtext.factoryLang.factoryLang.impl.ForEachImpl
import xtext.factoryLang.factoryLang.impl.DiskMarkSlotOperationImpl
import xtext.factoryLang.factoryLang.impl.LocalVariableImpl
import xtext.factoryLang.factoryLang.impl.GlobalVariableImpl

class EnumParser {
	def static CharSequence parseDiskSlotState(DISK_SLOT_STATES diskSlotState, Class<?> originClass) {
		switch originClass {
			case ForEachImpl: {	
				switch diskSlotState {
					case DISK_SLOT_STATES.FREE: 'GetSlotsWithMark(SlotState.Empty)'
					case DISK_SLOT_STATES.IN_PROGRESS: 'GetSlotsWithMark(SlotState.InProgress)'
					case DISK_SLOT_STATES.COMPLETE: 'GetSlotsWithMark(SlotState.Complete)'
				}
			}
			case DiskMarkSlotOperationImpl: {
				switch diskSlotState {
					case DISK_SLOT_STATES.FREE: "SlotState.Empty"
					case DISK_SLOT_STATES.IN_PROGRESS: "SlotState.InProgress"
					case DISK_SLOT_STATES.COMPLETE: "SlotState.Complete"
				}
			}
		}
	}

	def static CharSequence parseColor(COLOR color, Class<?> originClass) {
		switch originClass {
			case LocalVariableImpl: {
				switch color {
					case COLOR.RED: 'HasMark("RED")'
					case COLOR.GREEN: 'HasMark("GREEN")'
					case COLOR.BLUE: 'HasMark("BLUE")'
				}
			}
			case GlobalVariableImpl: {
				switch color {
					case COLOR.RED: "RED"
					case COLOR.GREEN: "GREEN"
					case COLOR.BLUE: "BLUE"
				}
			}
		}
	}

	def static CharSequence parseDiskState(DISK_STATES diskState, Class<?> originClass) {
		switch diskState {
			case DISK_STATES.FULL: originClass !== null ? "IsFull()" : "full"
			case DISK_STATES.EMPTY: originClass !== null ? "IsEmpty()" : "empty"
		}
	}

	def static CharSequence parseComparisonOperator(COMPARISON_OPERATOR operator) {
		switch operator {
			case COMPARISON_OPERATOR.GREATER_THAN: ">"
			case COMPARISON_OPERATOR.LESS_THAN: "<"
			case COMPARISON_OPERATOR.NOT: "!="
			default: "=="
		}
	}
}
