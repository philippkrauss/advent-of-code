int increases = 0
int currentValue = readFirstValue()

new File('input.txt').eachLine { String line ->
	if (Integer.parseInt(line) > currentValue) {
		increases++
	}
	currentValue = Integer.parseInt(line)
}

println 'number of increases: ' + increases

static int readFirstValue() {
	int firstValue = 0
	new File("input.txt").withReader { firstValue = Integer.parseInt(it.readLine()) }
	firstValue
}
