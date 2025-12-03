position = 50
zero_count = 0

with open("./01/input", "r") as file:
    lines = file.readlines()
    for line in lines:
        line = line.strip()
        direction = line[:1]
        rotations = int(line[1:])
        if (direction == "L"):
            position -= rotations
        else:
            position += rotations
        position %= 100
        if (position == 0):
            zero_count += 1
        print((direction, rotations, position))

print("Zero count ", zero_count)