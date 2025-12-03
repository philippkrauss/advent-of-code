result = 0
with open("input", "r") as file:
    input_string = file.read()
    print(input_string)
    ranges = [line.split("-") for line in input_string.split(",")]
    print("ranges: ", ranges)
    for r in ranges:
        for number in range(int(r[0]), int(r[1]) + 1):
            string = str(number)
            firstpart, secondpart = string[:len(string)//2], string[len(string)//2:]
            if firstpart == secondpart:
                result += number
print(result)