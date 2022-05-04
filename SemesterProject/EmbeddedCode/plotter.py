import matplotlib.pyplot as plt

data = open("data.csv").readlines()
inputs = []
outputs = []
time = []
for line in data:
    print(line)
    splitData = line.split(",")
    time.append(splitData[0].split("->")[0])
    inputs.append(float(splitData[0].split(":")[1].strip()))
    outputs.append(float(splitData[1].split(":")[1].strip()))

_, axis = plt.subplots(1, 2)

#for time in time:
#    print(time)

axis[0].plot(range(len(inputs)), inputs)
axis[0].axhline(52, 0, len(inputs))
axis[0].set_title("Input")
axis[1].plot(range(len(outputs)), outputs)
axis[1].set_title("Output")

plt.show()
