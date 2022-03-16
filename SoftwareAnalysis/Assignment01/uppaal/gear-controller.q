//This file was generated from (Academic) UPPAAL 4.1.26-1 (rev. 7BCF30B7363A9518), February 2022

/*
P1 It is not possible to change gear.
*/
E<> GearControl.GearChanged

/*
P2.A It is possible to switch gear nr 5 and to reverse gear (i.e. R).
*/
E<> Interface.Gear5

/*
P2.B It is possible to switch gear nr 5 and to reverse gear (i.e. R).
*/
E<> Interface.GearR

/*
P3 It is possible to switch gear in 1000ms (not very interesting).
*/
E<> GearControl.GearChanged and SysTimer<=1000

/*
P4 When the gearbox is in position N, the gear is not in position 1-5 or R.
*/
A[] not (GearBox.Neutral and (Interface.Gear1 or Interface.Gear2 or Interface.Gear3 or Interface.Gear4 or Interface.Gear5 or Interface.GearR))

/*
P5.A The gear is never N, when the gearbox is idle (expected to be neutral).
*/
A[] not (GearBox.Idle and Interface.GearN)

/*
P5.B The gear is never N, when the gearbox is idle (expected to be neutral).
*/
A[] (Interface.GearN imply GearBox.Neutral)

/*
P6.A In the case of no errors (in gear and clutch) and ideal (engine) scenario: 
A gear switch is guaranteed in 900ms (including 900ms).
*/
A[] ((ErrStat==0 and UseCase==0 and SysTimer>=900) imply (GearControl.GearChanged or GearControl.Gear)) 

/*
P6.A' In the case of no errors (in gear and clutch) and ideal (engine) scenario: 
A gear switch is not guaranteed in strictly less than 900ms.
*/
E<> (ErrStat==0 and UseCase==0 and SysTimer>899 and SysTimer<900 and not (GearControl.GearChanged or GearControl.Gear))

/*
P6.B In the case of no errors (in gear and clutch) and ideal (engine) scenario: 
It is impossible to switch gear in less than 150ms.
*/
A[] ((ErrStat==0 and UseCase==0 and (SysTimer<150)) imply not (GearControl.GearChanged))

/*
P6.B' In the case of no errors (in gear and clutch) and ideal (engine) scenario: 
It is impossible to switch gear in less than 150ms.
*/
E<> (ErrStat==0 and UseCase==0 and GearControl.GearChanged and (SysTimer==150))

/*
P6.C In the case of no errors (in gear and clutch) and ideal (engine) scenario: 
It is impossible to switch gear in less than 400ms if the switch is not from\/to gear N.
*/
A[] ((ErrStat==0 and UseCase==0 and FromGear>0 and ToGear>0 and (SysTimer<400)) imply not (GearControl.GearChanged))

/*
P6.C' In the case of no errors (in gear and clutch) and ideal (engine) scenario: 
It is possible to switch gear at 400ms if the switch is not from\/to gear N..
*/
E<> (ErrStat==0 and UseCase==0 and FromGear>0 and ToGear>0 and GearControl.GearChanged and (SysTimer==400))

/*
P7.A When no errors (in gear and clutch) occur, but engine fails to deliver zero torque: 
A gear switch is guaranteed after 1055ms (not including 1055).
*/
A[] ((ErrStat==0 and UseCase==1 and SysTimer>1055) imply (GearControl.GearChanged or GearControl.Gear))

/*
P7.A' When no errors (in gear and clutch) occur, but engine fails to deliver zero torque: 
It is impossible to switch gear in 1055ms.
*/
E<> (ErrStat==0 and UseCase==1 and SysTimer==1055 and not (GearControl.GearChanged or GearControl.Gear))

/*
P7.B When no errors (in gear and clutch) occur, but engine fails to deliver zero torque: 
It is impossible to switch gear in less than 550ms.
*/
A[] ((ErrStat==0 and UseCase==1 and SysTimer<550) imply not (GearControl.GearChanged or GearControl.Gear))

/*
P7.B' When no errors (in gear and clutch) occur, but engine fails to deliver zero torque: 
It is possible to switch gear at 550ms.
*/
E<> (ErrStat==0 and UseCase==1 and GearControl.GearChanged and (SysTimer==550))

/*
P7.C When no errors (in gear and clutch) occur, but engine fails to deliver zero torque: 
It is impossible to switch gear in less than 700ms if the switch is not from\/to gear N. 
*/
A[] ((ErrStat==0 and UseCase==1 and FromGear>0 and ToGear>0 and SysTimer<700) imply not (GearControl.GearChanged and GearControl.Gear))

/*
P7.C' When no errors (in gear and clutch) occur, but engine fails to deliver zero torque: 
It is possible to switch gear at 700ms if the switch is not from\/to gear N.
*/
E<> (ErrStat==0 and UseCase==1 and FromGear>0 and ToGear>0 and GearControl.GearChanged and (SysTimer==700))

/*
P8.A When no errors occur, but engine fails to find synchronous speed:
A gear switch is guaranteed in 1205ms (including 1205).
*/
A[] ((ErrStat==0 and UseCase==2 and SysTimer>=1205) imply (GearControl.GearChanged or GearControl.Gear))

/*
P8.A' When no errors occur, but engine fails to find synchronous speed:
A gear switch is not guaranteed at less than 1205ms.
*/
E<> (ErrStat==0 and UseCase==2 and SysTimer>1204 and SysTimer<1205 and not (GearControl.GearChanged or GearControl.Gear))

/*
P8.B When no errors occur, but engine fails to find synchronous speed:
It is impossible to switch gear in less than 450ms.
*/
A[] ((UseCase==2 and (SysTimer<450)) imply not (GearControl.GearChanged or GearControl.Gear))

/*
P8.B' When no errors occur, but engine fails to find synchronous speed:
It is possible to switch gear at 450ms.
*/
E<> (UseCase==2 and GearControl.GearChanged and (SysTimer==450))

/*
P8.C When no errors occur, but engine fails to find synchronous speed:
It is impossible to switch gear in less than 750ms if the switch is not from\/to gear N.
*/
A[] ((ErrStat==0 and UseCase==2 and FromGear>0 and ToGear>0 and SysTimer<750) imply not (GearControl.GearChanged and GearControl.Gear))

/*
P8.C' When no errors occur, but engine fails to find synchronous speed:
It is possible to switch gear at 750ms if the switch is not from\/to gear N.
*/
E<> (ErrStat==0 and UseCase==2 and FromGear>0 and ToGear>0 and GearControl.GearChanged and (SysTimer==750))

/*
P9.A If the clutch is not closed properly (i.e. a timeout occurs) the gearbox controller will enter the location CCloseError within 200ms.
*/
A[] ((Clutch.ErrorClose and (GearControl.GCTimer>200)) imply GearControl.CCloseError)

/*
P9.B When the gearbox controller enters location CCloseError, there is always a problem in the clutch with closing the clutch.
*/
A[] (GearControl.CCloseError imply Clutch.ErrorClose)

/*
P9.C If the clutch is not opened properly (i.e. a timeout occurs) the gearbox controller will enter location COpenError within 200ms.
*/
A[] ((Clutch.ErrorOpen and (GearControl.GCTimer>200)) imply GearControl.COpenError)

/*
P9.D When the gearbox controller enters location COpenError, there is always a problem in the clutch with opening the clutch.
*/
A[] ((GearControl.COpenError) imply Clutch.ErrorOpen)

/*
P10.A If the gearbox can not set a requested gear (i.e a timeout occurs) the gearbox controller will enter the location GSetError within 350ms.
*/
A[] ((GearBox.ErrorIdle and (GearControl.GCTimer>350)) imply GearControl.GSetError)

/*
P10.B When the gearbox controller enters location GSetError, there is always a problem in the gearbox with setting the gear.
*/
A[] ((GearControl.GSetError) imply GearBox.ErrorIdle)

/*
P10.C If the gearbox can not switch to neutral gear (i.e. a timeout occurs) the gearbox controller will enter location GNeuError within 200ms.
*/
A[] ((GearBox.ErrorNeu and (GearControl.GCTimer>200)) imply GearControl.GNeuError)

/*
P10.D When the gearbox controller enters location GNeuError there is always a problem in the gearbox swtiching to neutral gear.
*/
A[] ((GearControl.GNeuError) imply GearBox.ErrorNeu)

/*
P11 If no errors occur in the engine, it is guaranteed to find synchronous speed.
*/
A[] not (ErrStat==0 and Engine.ErrorSpeed)

/*
P12 When the gear is N, the engine is in initial or on its way to initial (i.e ToGear==0 and engine in zero).
*/
A[] (Interface.GearN imply ((ToGear==0 and Engine.Zero) or Engine.Initial))

/*
P13.A When the gear controller has a gear set, torque regulation is always indicated in the engine.
*/
A[] ((GearControl.Gear and Interface.GearR) imply Engine.Torque)

/*
P13.B When the gear controller has a gear set, torque regulation is always indicated in the engine.
*/
A[] ((GearControl.Gear and Interface.Gear1) imply Engine.Torque)

/*
P13.C When the gear controller has a gear set, torque regulation is always indicated in the engine.
*/
A[] ((GearControl.Gear and Interface.Gear2) imply Engine.Torque)

/*
P13.D When the gear controller has a gear set, torque regulation is always indicated in the engine.
*/
A[] ((GearControl.Gear and Interface.Gear3) imply Engine.Torque)

/*
P13.E When the gear controller has a gear set, torque regulation is always indicated in the engine.
*/
A[] ((GearControl.Gear and Interface.Gear4) imply Engine.Torque)

/*
P13.F When the gear controller has a gear set, torque regulation is always indicated in the engine.
*/
A[] ((GearControl.Gear and Interface.Gear5) imply Engine.Torque)

/*
P14.A If clutch is open, the gearbox controller is in one of the predefined locations.
*/
A[] (Clutch.Open imply (GearControl.ClutchOpen or GearControl.ClutchOpen2 or GearControl.CheckGearSet2 or GearControl.ReqSetGear2 or GearControl.GNeuError or GearControl.ClutchClose or GearControl.CheckClutchClosed or GearControl.CheckClutchClosed2 or GearControl.CCloseError or GearControl.GSetError or GearControl.CheckGearNeu2))

/*
P14.B If clutch is closed, the gearbox controller is in one of the predefined locations.
*/
A[] (Clutch.Closed imply (GearControl.ReqTorqueC or GearControl.GearChanged or GearControl.Gear or GearControl.Initiate or GearControl.CheckTorque or GearControl.ReqNeuGear or GearControl.CheckGearNeu or GearControl.GNeuError or GearControl.ReqSyncSpeed or GearControl.CheckSyncSpeed or GearControl.ReqSetGear or GearControl.CheckGearSet1 or GearControl.GSetError))

/*
P15.A If gear is set, the gearbox controller is in one the predefined locations.
*/
A[] (GearBox.Idle imply (GearControl.ClutchClose or GearControl.CheckClutchClosed or GearControl.CCloseError or GearControl.ReqTorqueC or GearControl.GearChanged or GearControl.Gear or GearControl.Initiate or GearControl.CheckTorque or GearControl.ReqNeuGear or GearControl.CheckClutch2 or GearControl.COpenError or GearControl.ClutchOpen2))

/*
P15.B If gear is neutral, the gearbox controller is in one of the predefined locations.
*/
A[] (GearBox.Neutral imply (GearControl.ReqSetGear or GearControl.CheckClutchClosed2 or GearControl.CCloseError or GearControl.ReqTorqueC or GearControl.GearChanged or GearControl.Gear or GearControl.Initiate or GearControl.ReqSyncSpeed or GearControl.CheckSyncSpeed or GearControl.ReqSetGear or GearControl.CheckClutch or GearControl.COpenError or GearControl.ClutchOpen or GearControl.ReqSetGear2))

/*
P16 If engine regulates on torque, then the clutch is closed.
*/
A[] (Engine.Torque imply Clutch.Closed)

/*
P17 As all states will satisfy "1 > 0", model-checking this
formula will generate the whole state-space of the system,
and the answer will be that the property is satisfied.
UPPAAL is designed to report all the deadlocked states
during state-space exploration. So if no deadlock is
reported before the final answer is given, the system is
deadlock-free.
*/
A[] (1>0)
