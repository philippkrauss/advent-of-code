result = 0
with open("input", "r") as file:
    input_string = file.read()
    print(input_string)
    ranges = [line.split("-") for line in input_string.split(",")]
    print("ranges: ", ranges)
    for r in ranges:
        for number in range(int(r[0]), int(r[1]) + 1):
            id_is_invalid = False
            string = str(number)
            firstpart, secondpart = string[:len(string)//2], string[len(string)//2:]
            if firstpart == secondpart:
                id_is_invalid = True
            thirdpart_index = len(string) // 3
            firstpart_3, secondpart_3, thirdpart_3 = string[:thirdpart_index], string[thirdpart_index:2*thirdpart_index], string[2*thirdpart_index:]
            if firstpart_3 == secondpart_3 == thirdpart_3:
                id_is_invalid = True
            fourthpart_index = len(string) // 4
            firstpart_4 = string[:fourthpart_index]
            secondpart_4 = string[fourthpart_index:2*fourthpart_index]
            thirdpart_4 = string[2*fourthpart_index:3*fourthpart_index]
            fourthpart_4 = string[3*fourthpart_index:]
            if firstpart_4 == secondpart_4 == thirdpart_4 == fourthpart_4:
                id_is_invalid = True
            fifthpart_index = len(string) // 5
            firstpart_5 = string[:fifthpart_index]
            secondpart_5 = string[fifthpart_index:2*fifthpart_index]
            thirdpart_5 = string[2*fifthpart_index:3*fifthpart_index]
            fourthpart_5 = string[3*fifthpart_index:4*fifthpart_index]
            fifthpart_5 = string[4*fifthpart_index:]
            if firstpart_5 == secondpart_5 == thirdpart_5 == fourthpart_5 == fifthpart_5:
                id_is_invalid = True
            sixthpart_index = len(string) // 6
            firstpart_6 = string[:sixthpart_index]
            secondpart_6 = string[sixthpart_index:2*sixthpart_index]
            thirdpart_6 = string[2*sixthpart_index:3*sixthpart_index]
            fourthpart_6 = string[3*sixthpart_index:4*sixthpart_index]
            fifthpart_6 = string[4*sixthpart_index:5*sixthpart_index]
            sixthpart_6 = string[5*sixthpart_index:]
            if firstpart_6 == secondpart_6 == thirdpart_6 == fourthpart_6 == fifthpart_6 == sixthpart_6:
                id_is_invalid = True
            seventhpart_index = len(string) // 7
            firstpart_7 = string[:seventhpart_index]
            secondpart_7 = string[seventhpart_index:2*seventhpart_index]
            thirdpart_7 = string[2*seventhpart_index:3*seventhpart_index]
            fourthpart_7 = string[3*seventhpart_index:4*seventhpart_index]
            fifthpart_7 = string[4*seventhpart_index:5*seventhpart_index]
            sixthpart_7 = string[5*seventhpart_index:6*seventhpart_index]
            seventhpart_7 = string[6*seventhpart_index:]
            if firstpart_7 == secondpart_7 == thirdpart_7 == fourthpart_7 == fifthpart_7 == sixthpart_7 == seventhpart_7:
                id_is_invalid = True
            eighthpart_index = len(string) // 8
            firstpart_8 = string[:eighthpart_index]
            secondpart_8 = string[eighthpart_index:2*eighthpart_index]
            thirdpart_8 = string[2*eighthpart_index:3*eighthpart_index]
            fourthpart_8 = string[3*eighthpart_index:4*eighthpart_index]
            fifthpart_8 = string[4*eighthpart_index:5*eighthpart_index]
            sixthpart_8 = string[5*eighthpart_index:6*eighthpart_index]
            seventhpart_8 = string[6*eighthpart_index:7*eighthpart_index]
            eighthpart_8 = string[7*eighthpart_index:]
            if firstpart_8 == secondpart_8 == thirdpart_8 == fourthpart_8 == fifthpart_8 == sixthpart_8 == seventhpart_8 == eighthpart_8:
                id_is_invalid = True
            if id_is_invalid:
                result += number
print(result)
