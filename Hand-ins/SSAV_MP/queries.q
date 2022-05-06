//This file was generated from (Academic) UPPAAL 4.1.26 (rev. C3644FEF32EA19FE), December 2021

/*
A.1.a
*/
E<> disk1.Position1 imply disk1.Position2

/*
A.1.a
*/
A<> disk1.Position2 imply disk1.Position8

/*
A.1.d
*/
A<> disk1.AddItem1Req imply (disk1_DiscSlot(1).disk1_SlotFull and forall(i : int[2,8]) disk1_DiscSlot(i).disk1_SlotEmpty)

/*
A.2.a
*/
E<> crane1.crane1_intake imply crane1.crane1_outRed

/*
A.2.a
*/
E<> crane1.crane1_outRed imply crane1.crane1_outBlue

/*
A.2.a
*/
E<> crane1.crane1_outBlue imply crane1.crane1_intake

/*
A.2.b
*/
E<> crane1.crane1_intake imply crane1.crane1_LoweredAtintake imply crane1.crane1_intake

/*
A.2.b
*/
E<> crane1.crane1_outGreen imply crane1.crane1_LoweredAtoutGreen imply crane1.crane1_outGreen

/*
A.2.c
*/
A<> crane1_CraneMagnet.crane1_MagnetOn imply crane1_CraneMagnet.crane1_MagnetOff

/*
A.3.a
*/
E<> (camera1.camera1_Green or camera1.camera1_Blue or camera1.camera1_Red) and (colour <= 3 or colour > 0)

/*
A.3.b
*/
MasterController.camera1_scanItem_14 --> MasterController.camera1_scanItem_14

/*
A.2.b, A.2.c
*/
E<> (crane1.crane1_LoweredAtintake and crane1_CraneMagnet.crane1_MagnetOn) imply (crane1.crane1_intake and crane1_CraneMagnet.crane1_MagnetOn)

/*
A.2.a, A.2.b, A.2.c
*/
E<> (crane1.crane1_intake and crane1_CraneMagnet.crane1_MagnetOn) imply (crane1.crane1_outRed and crane1_CraneMagnet.crane1_MagnetOn)

/*
A.2.b, A.2.c
*/
E<> (crane1.crane1_outRed and crane1_CraneMagnet.crane1_MagnetOn) imply (crane1.crane1_LoweredAtoutRed and crane1_CraneMagnet.crane1_MagnetOn)

/*
A.2.c
*/
E<> (crane1.crane1_LoweredAtoutRed and crane1_CraneMagnet.crane1_MagnetOn) imply (crane1.crane1_LoweredAtoutRed and crane1_CraneMagnet.crane1_MagnetOff)

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
A.1.f, A.1.g, A.2.f, A.2.g
*/
A[] EmergencyButton.Stopped imply (crane1.crane1_Stopped and disk1.Stopped and (crane1_CraneMagnet.crane1_StoppedMagnetOff or crane1_CraneMagnet.crane1_StoppedMagnetOn))

/*
A.1.f, A.1.g, A.2.f, A.2.g
*/
A<> EmergencyButton.Stopped imply (crane1.crane1_Stopped and disk1.Stopped and (crane1_CraneMagnet.crane1_StoppedMagnetOff or crane1_CraneMagnet.crane1_StoppedMagnetOn))

/*
A.1.h
*/
A<> disk1.Stopped imply disk1.Position1

/*
A.2.h
*/
A<> crane1.crane1_Stopped imply crane1.crane1_intake

/*
A.1.h
*/
disk1.Stopped --> disk1.Position1

/*
A.2.h
*/
crane1.crane1_Stopped --> crane1.crane1_intake

/*
A.1.f, A.2.f
*/
E<> EmergencyButton.Stopped
