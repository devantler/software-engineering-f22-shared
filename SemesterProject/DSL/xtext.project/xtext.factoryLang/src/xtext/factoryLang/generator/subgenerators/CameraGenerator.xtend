package xtext.factoryLang.generator.subgenerators

import xtext.factoryLang.factoryLang.Camera

class CameraGenerator {
	def static String generate(Camera camera){
		return 
		'''
		<template>
	        <name>«camera.name»</name>
	        <location id="«UppaalGenerator.getIdOfLocation(camera.name+"_Idle")»">
	            <name>«camera.name»_Idle</name>
	        </location>
	        <location id="«UppaalGenerator.getIdOfLocation(camera.name+"_Red")»">
	            <name>«camera.name»_Red</name>
	            <committed/>
	        </location>
	        <location id="«UppaalGenerator.getIdOfLocation(camera.name+"_Green")»">
	            <name>«camera.name»_Green</name>
	            <committed/>
	        </location>
	        <location id="«UppaalGenerator.getIdOfLocation(camera.name+"_Blue")»">
	            <name>«camera.name»_Blue</name>
	            <committed/>
	        </location>
	        <init ref="«UppaalGenerator.getIdOfLocation(camera.name+"_Idle")»"/>
	        <transition>
	            <source ref="«UppaalGenerator.getIdOfLocation(camera.name+"_Blue")»"/>
	            <target ref="«UppaalGenerator.getIdOfLocation(camera.name+"_Idle")»"/>
	            <label kind="synchronisation">«camera.name»_gottenColour!</label>
	        </transition>
	        <transition>
	            <source ref="«UppaalGenerator.getIdOfLocation(camera.name+"_Idle")»"/>
	            <target ref="«UppaalGenerator.getIdOfLocation(camera.name+"_Blue")»"/>
	            <label kind="synchronisation">«camera.name»_getColour?</label>
	            <label kind="assignment">colour = 3</label>
	        </transition>
	        <transition>
	            <source ref="«UppaalGenerator.getIdOfLocation(camera.name+"_Green")»"/>
	            <target ref="«UppaalGenerator.getIdOfLocation(camera.name+"_Idle")»"/>
	            <label kind="synchronisation">«camera.name»_gottenColour!</label>
	        </transition>
	        <transition>
	            <source ref="«UppaalGenerator.getIdOfLocation(camera.name+"_Idle")»"/>
	            <target ref="«UppaalGenerator.getIdOfLocation(camera.name+"_Green")»"/>
	            <label kind="synchronisation">«camera.name»_getColour?</label>
	            <label kind="assignment">colour=2</label>
	        </transition>
	        <transition>
	            <source ref="«UppaalGenerator.getIdOfLocation(camera.name+"_Red")»"/>
	            <target ref="«UppaalGenerator.getIdOfLocation(camera.name+"_Idle")»"/>
	            <label kind="synchronisation">«camera.name»_gottenColour!</label>
	        </transition>
	        <transition>
	            <source ref="«UppaalGenerator.getIdOfLocation(camera.name+"_Idle")»"/>
	            <target ref="«UppaalGenerator.getIdOfLocation(camera.name+"_Red")»"/>
	            <label kind="synchronisation">«camera.name»_getColour?</label>
	            <label kind="assignment">colour = 1</label>
	        </transition>
	    </template>
		'''
	}
}