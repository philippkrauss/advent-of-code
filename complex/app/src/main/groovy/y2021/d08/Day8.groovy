package y2021.d08

class Day8 {
	static void main(String... args) {
		String[] lines = new File(Day8.class.getResource('input.txt').file)
		List<Integer> counts = [0, 0, 0, 0, 0, 0, 0, 0]
		lines.each { String line ->
			String[] splitted = line.split('[|]')
			String input = splitted[0]
			String output = splitted[1]
			output.split(' ').each { String signal ->
				int currentCount = counts[signal.length()]
				counts[signal.size()] = new Integer(currentCount + 1)
			}
		}
		println "part 1: 1, 4, 7 or 8: ${counts[2] + counts[4] + counts[3] + counts[7]} times"
	}
}
