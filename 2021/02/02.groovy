int depth = 0
int horizontal = 0

new File('input.txt').eachLine { String line ->
	String command = line.split()[0]
	int value = Integer.parseInt(line.split()[1])
	switch (command) {
		case 'forward':
			horizontal += value
			break
		case 'down':
			depth += value
			break;
		case 'up':
			depth -= value
			break
	}
}
println 'part 1: ' +  depth * horizontal

depth = 0
horizontal = 0
int aim = 0

new File('input.txt').eachLine { String line ->
	String command = line.split()[0]
	int value = Integer.parseInt(line.split()[1])
	switch (command) {
		case 'forward':
			horizontal += value
			depth += aim * value
			break
		case 'down':
			aim += value
			break;
		case 'up':
			aim -= value
			break
	}
}

println 'part 2: ' +  depth * horizontal
