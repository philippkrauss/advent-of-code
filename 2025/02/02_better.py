result = 0

def is_invalid_id(number):
    string = str(number)
    length = len(string)
    for parts in range(2, 9):  # Check for 2 to 8 equal parts
        part_length = length // parts
        if length % parts == 0:  # Only divide if evenly divisible
            parts_list = [string[i * part_length:(i + 1) * part_length] for i in range(parts)]
            if all(part == parts_list[0] for part in parts_list):
                return True
    return False

with open("input", "r") as file:
    input_string = file.read()
    ranges = [line.split("-") for line in input_string.split(",")]
    for r in ranges:
        for number in range(int(r[0]), int(r[1]) + 1):
            if is_invalid_id(number):
                result += number

print(result)