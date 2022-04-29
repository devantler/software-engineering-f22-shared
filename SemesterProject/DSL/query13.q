
/*

*/
E<> forall (i : disk1_id_t) disk1_DiscSlot(i).disk1_SlotEmpty

/*

*/
A[] EmergencyButton.Stopped imply (crane1.crane1_Stopped and disk1.Stopped and (crane1_CraneMagnet.crane1_StoppedMagnetOff or crane1_CraneMagnet.crane1_StoppedMagnetOn))
