String firstLine = ""
new File("input.txt").withReader { firstLine = it.readLine() }

def zeroCount = firstLine.collect { 0 }
def oneCount = firstLine.collect { 0 }
new File('input.txt').eachLine { String line ->
	line.eachWithIndex { String character, int index ->
		if (character == '0') {
			zeroCount[index] = zeroCount[index] + 1
		} else {
			oneCount[index] = oneCount[index] + 1
		}
	}
}
String gammaRate = ''
String epsilonRate = ''
zeroCount.eachWithIndex { int entry, int index ->
	int zeros = entry
	int ones = oneCount[index]
	if (ones > zeros) {
		gammaRate += '1'
		epsilonRate += '0'
	} else {
		gammaRate += '0'
		epsilonRate += '1'

	}
}
println 'part 1 - power consumption: ' + Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2)


int getSumAtPosition(List<String> input, int position) {
	int zeros = 0;
	int ones = 0
	input.collect { Integer.parseInt(it[position]) }.inject(0, { result, i ->
		result + i
	})
}

int getMostCommonAtPosition(List<String> list, int position) {
	int sum = getSumAtPosition(list, position)
	int size = list.size()
	return (sum >= size / 2) ? 1 : 0
}
int getLeastCommonAtPosition(List<String> list, int position) {
	return 1 - getMostCommonAtPosition(list, position)
}
List<String> oxygenInput = new File('input.txt') as String[]

int position = 0;
while(oxygenInput.size() > 1 || position > firstLine.size()) {
	int mostCommon = getMostCommonAtPosition(oxygenInput, position)
	oxygenInput = oxygenInput.findAll {it[position] == "$mostCommon"}
	position++
}

List<String> co2Input = new File('input.txt') as String[]

position = 0;
while(co2Input.size() > 1 || position > firstLine.size()) {
	int leastCommon = getLeastCommonAtPosition(co2Input, position)
	co2Input = co2Input.findAll {it[position] == "$leastCommon"}
	position++
}

String oxygenGeneratorRating = oxygenInput[0]
String co2Rating = co2Input[0]
println 'part 2 - life support rating: ' + Integer.parseInt(oxygenGeneratorRating, 2) * Integer.parseInt(co2Rating, 2)
