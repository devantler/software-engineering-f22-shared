//This file was generated from (Academic) UPPAAL 4.1.26-1 (rev. 7BCF30B7363A9518), February 2022

/*

*/
A<> crane1_CraneMagnet.crane1_MagnetOn imply crane1_CraneMagnet.crane1_MagnetOff

/*

*/
A[] (crane1.crane1_intake and crane1_CraneMagnet.crane1_MagnetOff) imply !(crane1.crane1_intake and crane1_CraneMagnet.crane1_MagnetOn)

/*

*/
A[] (crane1.crane1_intake and crane1_CraneMagnet.crane1_MagnetOn) imply !(crane1.crane1_intake and crane1_CraneMagnet.crane1_MagnetOff)

/*

*/
A[] (crane1.crane1_outRed and crane1_CraneMagnet.crane1_MagnetOff) imply !(crane1.crane1_outRed and crane1_CraneMagnet.crane1_MagnetOn)

/*

*/
A[] (crane1.crane1_outRed and crane1_CraneMagnet.crane1_MagnetOn) imply !(crane1.crane1_outRed and crane1_CraneMagnet.crane1_MagnetOff)

/*

*/
A[] (crane1.crane1_outGreen and crane1_CraneMagnet.crane1_MagnetOff) imply !(crane1.crane1_outGreen and crane1_CraneMagnet.crane1_MagnetOn)

/*

*/
A[] (crane1.crane1_outGreen and crane1_CraneMagnet.crane1_MagnetOn) imply !(crane1.crane1_outGreen and crane1_CraneMagnet.crane1_MagnetOff)

/*

*/
A[] (crane1.crane1_outBlue and crane1_CraneMagnet.crane1_MagnetOff) imply !(crane1.crane1_outBlue and crane1_CraneMagnet.crane1_MagnetOn)

/*

*/
A[] (crane1.crane1_outBlue and crane1_CraneMagnet.crane1_MagnetOn) imply !(crane1.crane1_outBlue and crane1_CraneMagnet.crane1_MagnetOff)

/*

*/
A[] (EmergencyButton.Stopped and crane1_CraneMagnet.crane1_MagnetOn) imply crane1_CraneMagnet.crane1_StoppedMagnetOn

/*

*/
A[] !deadlock or EmergencyButton.Stopped

/*

*/
A[] disk1_slots_complete[1] imply disk1_notemptySlots[1]

/*

*/
E<> forall (i : disk1_id_t) disk1_DiscSlot(i).disk1_SlotEmpty

/*

*/
A[] EmergencyButton.Stopped imply (crane1.crane1_Stopped and disk1.Stopped and (crane1_CraneMagnet.crane1_StoppedMagnetOff or crane1_CraneMagnet.crane1_StoppedMagnetOn))
