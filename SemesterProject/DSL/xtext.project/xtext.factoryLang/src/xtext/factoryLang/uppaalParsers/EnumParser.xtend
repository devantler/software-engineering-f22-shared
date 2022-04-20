package xtext.factoryLang.uppaalParsers

import xtext.factoryLang.factoryLang.COLOR

class EnumParser {
	def static int ColourToInt(COLOR colour){
		return colour.value + 1
	}
}