package xtext.factoryLang.parsers

import xtext.factoryLang.factoryLang.Device
import xtext.factoryLang.factoryLang.Crane
import xtext.factoryLang.factoryLang.Disk
import xtext.factoryLang.factoryLang.Camera

class TypeParser {
	def static CharSequence parseDeviceType(Device device, boolean isPlural) {
		switch device {
			Crane: isPlural ? "cranes" : "crane"
			Disk: isPlural ? "disks" : "disk"
			Camera: isPlural ? "cameras" : "camera"
		}
	}
}
