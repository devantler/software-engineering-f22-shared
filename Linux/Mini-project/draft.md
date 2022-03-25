# Remote controlled crane

Group 9
- Nikolai Emil Damm — [nidam16](nidam16@student.sdu.dk)
- Peter Andreas Brændtgaard — [pebra18](pebra18@student.sdu.dk)
- Frederik Alexander Hounsvad — [frhou18](frhou18@student.sdu.dk)
- Oliver Lind Nordestgaard — [olnor18](olnor18@student.sdu.dk)

## Overall Project Description

Using a combination of ESP32s a Raspberry Pi and a MQTT service we want to remotely control a crane so it can pickup goods from a simulated assembly line (a rotating disk with zones). The system will be able to:

- Recoqnize item types based on color (scanned with a camera interfaced with the Raspberry Pi)
- Be controlled remotely by actuating upon topic values in a hosted MQTT service.
- Use various hardware components: 
  - Phototransistor to count rotations on the crane winch.
  - DC and Stepper motors
  - Self-built electromagnet

## Tasks

- Building a reactive system wirelessly enabled with the MQTT service and WiFi compatible IoT devices. (Linux/IoT)
- Precision of the hardware. The crane should function reliably. (Robots)
- Ensuring valid states. If the states are incorrect the system will behave incorrectly. (SSAV)
- Infterfacing sensors into the system (Linux/Robots/IoT)
- Cross communicating multiple IoT devices through WiFi and MQTT. (Linux/IoT)
- Develop a hosted web interface to program the system with a DSL. (Linux)
- And more…

## Satisfied course objectives

- Linux architecture
- Embedded linux systems
- Distributed embedded Linux systems, wired and wireless communication
- I/O interfacing to sensors and actuators
- Message passing design patterns
- Integrate simple embedded Linux systems into relevant applications (we use quite a few of the linux services to make our system possible e.g. to set up a wifi hotspot)
- Apply appropriate communication and message passing architectures for data exchange and remote management
- Setup and use version control systems


