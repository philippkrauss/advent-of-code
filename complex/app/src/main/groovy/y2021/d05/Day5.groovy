package y2021.d05

class Day5 {
	static void main(String... args) {
		String input = new File(Day5.class.getResource('input.txt').file).text
		LinkedList<String> lines = new LinkedList<>(Arrays.asList(input.split('\n')))
		Field field1 = new Field()
		Field field2 = new Field()
		lines.each {
			if (!it) return
			Line line = Line.fromString(it)
			if (line.horizontalOrVertical) {
				field1.addLine(line)
			}
			field2.addLine(line)
		}
		println 'part 1: ' + field1.numberOfOverlaps
		println 'part 2: ' + field2.numberOfOverlaps
	}
}
