```python
#############Setup#############
create crane named "fishing rod"
    with position at 30 named "intake"
    with position at 120 named "red"
    with posttion at 140 named "green"
    with position at 160 named "blue"

create storage named "storage"
    with 8 slots
    with position at slot 3 named "crane"
    with position at slot 6 named "camera"
    with position at slot 1 named "intake"

create camera named "scanner"
    with color red
    with color blue
    with color green

########logic loop (variable delay)#############
"storage" check capacity
if capacity is not full then 
    "storage" move empty slot to "intake"
    "storage" mark slot at "intake" as full
    "storage" move slot at "intake" to "camera"
    "scanner" scan color
    "storage" mark slot at "camera" as color
    if color is red then
        "storage" mark slot at "camera" as finished in 10 seconds
    if color is green then
        "storage" mark slot at "camera" as finished in 20 seconds
    if color is blue then
        "storage" mark slot at "camera" as finished in 30 seconds

"storage" check for finished
if any is finished then
    "storage" move fishined to "crane"
    "crane" pickup item at "intake"
    if color of finished is red then
        "crane" mdrop item at "red"
    if color of finished is green then
        "crane" drop item at "green"
    if color of finished is blue then
        "crane" drop item at "blue"
    "storage" mark slot at "intake" as empty
```
