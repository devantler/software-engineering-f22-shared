package xtext.factoryLang.generator.subgenerators

import java.util.List
import xtext.factoryLang.factoryLang.*

class UppaalQueryGenerator {
	def static String generateUpaalQuery(List<Crane> cranes, List<Disk> discs, List<Camera> cameras){
		return '''
			<queries>
			    «FOR crane: cranes»
			    <query>
					<formula>A&lt;&gt; «crane.name»_CraneMagnet.«crane.name»_MagnetOn imply «crane.name»_CraneMagnet.«crane.name»_MagnetOff</formula>
					<comment></comment>
				</query>
				«FOR position: crane.targets»
				<query>
					<formula>A[] («crane.name».«crane.name»_«(position as CranePositionParameter).name» and «crane.name»_CraneMagnet.«crane.name»_MagnetOff) imply !(«crane.name».«crane.name»_«(position as CranePositionParameter).name» and «crane.name»_CraneMagnet.«crane.name»_MagnetOn)</formula>
					<comment></comment>
				</query>
				<query>
					<formula>A[] («crane.name».«crane.name»_«(position as CranePositionParameter).name» and «crane.name»_CraneMagnet.«crane.name»_MagnetOn) imply !(«crane.name».«crane.name»_«(position as CranePositionParameter).name» and «crane.name»_CraneMagnet.«crane.name»_MagnetOff)</formula>
					<comment></comment>
				</query>
				«ENDFOR»
				<query>
					<formula>A[] (EmergencyButton.Stopped and «crane.name»_CraneMagnet.«crane.name»_MagnetOn) imply «crane.name»_CraneMagnet.«crane.name»_StoppedMagnetOn</formula>
					<comment></comment>
				</query>
			    «ENDFOR»
				<query>
					<formula>A[] !deadlock or EmergencyButton.Stopped</formula>
					<comment></comment>
				</query>
				«FOR disc: discs»
				<query>
					<formula>A[] !«disc.name»_notcompleteSlots[1] imply «disc.name»_notemptySlots[1]</formula>
					<comment></comment>
				</query>
				<query>
					<formula>E&lt;&gt; forall (i : «disc.name»_id_t) «disc.name»_DiscSlot(i).«disc.name»_SlotEmpty</formula>
					<comment></comment>
				</query>
				«FOR crane: cranes»
				<query>
					<formula>A[] EmergencyButton.Stopped imply («crane.name».«crane.name»_Stopped and «disc.name».Stopped and («crane.name»_CraneMagnet.«crane.name»_StoppedMagnetOff or «crane.name»_CraneMagnet.«crane.name»_StoppedMagnetOn))</formula>
					<comment></comment>
				</query>
				«ENDFOR»
				«ENDFOR»
			</queries>
		</nta>
		'''
		/* Removed for now
 					<query>
						<formula>A[] MasterController.gotoIntake_crane imply «disc.name»slots_finished[currentSlot_finished]</formula>
						<comment></comment>
					</query>
		 */
	}
}