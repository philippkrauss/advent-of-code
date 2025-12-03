def find_highest_number_and_index(line):
    max_value = -1
    max_index = -1
    for i in range(0, len(line)):
        value = int(line[i])
        if value > max_value:
            max_value = value
            max_index = i
    return max_value, max_index

end_result = 0
with open("./03/input", "r") as file:
    lines = file.readlines()
    for line in lines:
        line = line.strip()
        max_value_1, max_index_1 = find_highest_number_and_index(line[:-11])
        max_value_2, max_index_2 = find_highest_number_and_index(line[max_index_1 + 1:-10])
        max_value_3, max_index_3 = find_highest_number_and_index(line[max_index_1 + max_index_2 + 2:-9])
        max_value_4, max_index_4 = find_highest_number_and_index(line[max_index_1 + max_index_2 + max_index_3 + 3:-8])
        max_value_5, max_index_5 = find_highest_number_and_index(line[max_index_1 + max_index_2 + max_index_3 + max_index_4 + 4:-7])
        max_value_6, max_index_6 = find_highest_number_and_index(line[max_index_1 + max_index_2 + max_index_3 + max_index_4 + max_index_5 + 5:-6])
        max_value_7, max_index_7 = find_highest_number_and_index(line[max_index_1 + max_index_2 + max_index_3 + max_index_4 + max_index_5 + max_index_6 + 6:-5])
        max_value_8, max_index_8 = find_highest_number_and_index(line[max_index_1 + max_index_2 + max_index_3 + max_index_4 + max_index_5 + max_index_6 + max_index_7 + 7:-4])
        max_value_9, max_index_9 = find_highest_number_and_index(line[max_index_1 + max_index_2 + max_index_3 + max_index_4 + max_index_5 + max_index_6 + max_index_7 + max_index_8 + 8:-3])
        max_value_10, max_index_10 = find_highest_number_and_index(line[max_index_1 + max_index_2 + max_index_3 + max_index_4 + max_index_5 + max_index_6 + max_index_7 + max_index_8 + max_index_9 + 9:-2])
        max_value_11, max_index_11 = find_highest_number_and_index(line[max_index_1 + max_index_2 + max_index_3 + max_index_4 + max_index_5 + max_index_6 + max_index_7 + max_index_8 + max_index_9 + max_index_10 + 10:-1])
        max_value_12, _ = find_highest_number_and_index(line[max_index_1 + max_index_2 + max_index_3 + max_index_4 + max_index_5 + max_index_6 + max_index_7 + max_index_8 + max_index_9 + max_index_10 + max_index_11 + 11:])
        result = (max_value_1 * 100000000000 +
                  max_value_2 * 10000000000 +
                  max_value_3 * 1000000000 +
                  max_value_4 * 100000000 +
                  max_value_5 * 10000000 +
                  max_value_6 * 1000000 +
                  max_value_7 * 100000 +
                  max_value_8 * 10000 +
                  max_value_9 * 1000 +
                  max_value_10 * 100 +
                  max_value_11 * 10 +
                  max_value_12)
        end_result += result

print(end_result)

