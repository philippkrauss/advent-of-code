package y2021.d04

import spock.lang.Specification

class Day4Test extends Specification {
	private static final String INPUT = '''7,4,9

22 13 17 11  0
 8  2 23  4 24
21  9 14 16  7
 6 10  3 18  5
 1 12 20 15 19

 3 15  0  2 22
 9 18 13 17  5
19  8  7 25 23
20 11 10 24  4
14 21 16 12  6
'''
	def "read rolls from input"() {
		when:
		Day4 day4 = new Day4(INPUT)
		then:
		day4.rolls == '7,4,9'
	}

	def "read boards from input"() {
		when:
		Day4 day4 = new Day4(INPUT)
		then:
		day4.boards.size() == 2
		day4.boards[0].numberAt(0, 0) == 22
	}

	def "remove boards"() {
		when:
		Day4 day4 = new Day4(INPUT)
		then:
		day4.boards.size() == 2
		day4.removeBoard(day4.boards[0])
		day4.boards.size() == 1
	}
}
