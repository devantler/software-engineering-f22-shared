package xtext.factoryLang.parsers

import xtext.factoryLang.factoryLang.Device
import xtext.factoryLang.factoryLang.Crane
import xtext.factoryLang.factoryLang.Disk
import xtext.factoryLang.factoryLang.Camera

class TypeParser {
	def static CharSequence parseDeviceTypeInPlural(Device device) {
		switch device {
			Crane: "cranes"
			Disk: "disks"
			Camera: "cameras"
		}
	}
}