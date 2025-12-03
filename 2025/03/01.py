end_result = 0
with open("./03/input", "r") as file:
    lines = file.readlines()
    for line in lines:
        line = line.strip()
        max_value_1 = -1
        max_index_1 = -1
        max_value_2 = -1
        for i in range(0, len(line) - 1):
            value = int(line[i])
            if value > max_value_1:
                max_value_1 = value
                max_index_1 = i
        for i in range(max_index_1 + 1, len(line)):
            value = int(line[i])
            if value > max_value_2:
                max_value_2 = value
        result = max_value_1 * 10 + max_value_2
        end_result += result

print(end_result)

end_result = 0
def find_highest_number_and_index(line):
    max_value = -1
    max_index = -1
    for i in range(0, len(line)):
        value = int(line[i])
        if value > max_value:
            max_value = value
            max_index = i
    return max_value, max_index

with open("./03/input", "r") as file:
    lines = file.readlines()
    for line in lines:
        line = line.strip()
        max_value_1, max_index_1 = find_highest_number_and_index(line[:-1])
        max_value_2, _ = find_highest_number_and_index(line[max_index_1 + 1:])
        result = max_value_1 * 10 + max_value_2
        end_result += result

print(end_result)