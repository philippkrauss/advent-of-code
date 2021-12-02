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

Queue<Integer> queue = new ArrayDeque<Integer>()
int currentSum = 0
increases = 0
new File('input.txt').eachLine { String line ->
	int current = Integer.parseInt(line)
	queue << current
	if (queue.size() > 3) {
		queue.poll()
	}
	if (queue.size() == 3) {
		if (queue.value.sum() > currentSum && currentSum != 0) {
			increases++
		}
		currentSum = queue.value.sum()
	}
}

println 'number of summed increases: ' + increases
