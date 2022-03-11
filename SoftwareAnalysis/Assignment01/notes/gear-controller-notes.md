# Gear Controller Notes

Current Status = Changing gear OR idling
Transistions = gear change, zero-torque transmission, release gear, achieve synchronous speed over the transmission, set new gear, increase torque, open clutch, close clutch

## Components and states

- Interface (either driver or dedicated component implementing gear change algorithm (e.g. automatic gear change))
  - Current Status (Changing gear OR idling)
- Gearbox
  - Set gear (in 100 to 300ms)
  - Release gear (in 100 to 200ms)
  - Error state (if above thresholds)
- Clutch
  - Open (within 100 to 150ms)
  - Close (within 100 to 150ms)
  - Error stat (if above thresholds)
- Engine
  - Normal torque
  - Zero torque (within 400ms)
  - Safe state (if below zero torque threshold)
  - Synchronous speed (within 500ms)
  - Error state (if above synchronous speed threshold)

## Simplified transitions

1. Gear change request from interface
2. Zero-torque transmission
   - Safe state
   - Error state
3. Release currently set gear
   - Error state
4. Achieve synchronous speed
   - Error state
5. Set new gear
   - Error state
6. Normal torque

Alternative:

1. Gear change request from interface
2. Open clutch
3. Release currently set gear
   - Error state
4. Set new gear
   - Error state
5. Close clutch
6. Normal torque

Error are recovered or terminated.

## Requirements

Performance:

- A gear change should be completed within 1,5 seconds // 1 second under normal operation conditions

Predictability:

- No deadlocks
- When regulating torque, clutch must be closed.
- The gear must be set when regulating torque.

Functionality:

- It can use all gears
- It uses the engine to enhance zero-torque and synchrnous speed over the transmission
- It uses the gearbox to set and release gears
- It is allowed to use clutch in difficult situations.
- It does not require zero-torque when when changing from neutral gears.
- The gear controller does not request synchronous speed when changing to neutral gear.

Error detection:

- when the clutch is not opened/closed in time.
- when the gearbox is not able to set/release a gear in time.

## What automata they use to model the system

- GearControl (GC)
- Interface (I)
- Clutch (C)
- Engine (E)
- GearBox (GB)

Variables:

- GCTimer
- GBTimer
- CTimer
- ETimer
- FromGear
- ToGear

Two channels for each service (request/respond)

## Description of their system aswell as validation and verification

See section 6 and 7 in the article

