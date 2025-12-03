position = 50
zero_count = 0

with open("./01/input", "r") as file:
    lines = file.readlines()
    for line in lines:
        line = line.strip()
        direction = line[:1]
        rotations = int(line[1:])
        for i in range(abs(rotations)):
            if direction == "R":
                position += 1
            else:
                position -= 1
            if position == 100 or position == -100:
                position = 0
            if position == 0:
                zero_count += 1

print("Zero count", zero_count)
