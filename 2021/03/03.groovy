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
