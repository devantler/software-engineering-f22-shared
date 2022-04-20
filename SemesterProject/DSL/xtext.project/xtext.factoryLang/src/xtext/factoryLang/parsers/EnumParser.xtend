package xtext.factoryLang.parsers

import xtext.factoryLang.factoryLang.DISK_SLOT_STATES
import xtext.factoryLang.factoryLang.COLOR
import xtext.factoryLang.factoryLang.DISK_STATES
import xtext.factoryLang.factoryLang.COMPARISON_OPERATOR

class EnumParser {
	def static CharSequence parseDiskSlotState(DISK_SLOT_STATES diskSlotState) {
		switch diskSlotState {
			case DISK_SLOT_STATES.FREE: "free"
			case DISK_SLOT_STATES.IN_PROGRESS: "in-progress"
			case DISK_SLOT_STATES.COMPLETE: "complete"
		}
	}

	def static CharSequence parseColor(COLOR color, boolean asCode) {
		switch color {
			case COLOR.RED: asCode ? '.HasMark("red")' : "red"
			case COLOR.GREEN: asCode ? '.HasMark("green")' : "green"
			case COLOR.BLUE: asCode ? '.HasMark("blue")' : "blue"
		}
	}

	def static CharSequence parseDiskState(DISK_STATES diskState, boolean asCode) {
		switch diskState {
			case DISK_STATES.FULL: asCode ? ".IsFull()" : "full"
			case DISK_STATES.EMPTY: asCode ? ".IsEmpty()" : "empty"
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
