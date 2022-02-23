```python
#############Setup#############
create crane named "fishing rod"
    with position at 30 named "intake"
    with position at 120 named "red"
    with posttion at 140 named "green"
    with position at 160 named "blue"

create storage named "disc"
    with 8 slots
    with position at slot 3 named "crane"
    with position at slot 6 named "camera"
    with position at slot 1 named "intake"

create camera named "scanner"
    with color red
    with color blue
    with color green

########logic loop (variable delay)#############
if capacity in "storage" is not full then 
    "disc" move empty slot to "intake"
    "disc" mark slot at "intake" as full
    "disc" move slot at "intake" to "camera"
    "scanner" scan color into itemcolor
    "disc" mark slot at "camera" as itemcolor
    if itemcolor is red then
        "disc" mark slot at "camera" as finished in 10 seconds
    if itemcolor is green then
        "disc" mark slot at "camera" as finished in 20 seconds
    if itemcolor is blue then
        "disc" mark slot at "camera" as finished in 30 seconds

for each item in "disc" that is finished then
    "disc" move slot to "crane"
    "fishing rod" pickup item at "intake"
    if color of item is red then
        "fishing rod" drop item at "red"
    if color of item is green then
        "fishing rod" drop item at "green"
    if color of item is blue then
        "fishing rod" drop item at "blue"
    "disc" mark slot at "intake" as empty
```
