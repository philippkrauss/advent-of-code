package y2021.d04

import spock.lang.Specification

class BingoBoardTest extends Specification {
	private static List<String> INPUT = [
				"14 21 17 24  4",
				"10 16 15  9 19",
				"18  8 23 26 20",
				"22 11 13  6  5",
				" 2  0 12  3  7",
		]
	def "should instantiate bingo board"() {
		when:
		BingoBoard board = new BingoBoard(INPUT)
		then:
		board.numberAt(0, 0) == 14
		board.numberAt(4, 0) == 2
		board.numberAt(0, 4) == 4
		board.numberAt(4, 4) == 7
		board.numberAt(2, 1) == 8
	}
	def "should mark board rows"() {
		setup:
		BingoBoard board = new BingoBoard(INPUT)
		expect:
		!board.winner
		board.mark(14)
		!board.winner
		board.mark(21)
		!board.winner
		board.mark(17)
		!board.winner
		board.mark(24)
		!board.winner
		board.mark(4)
		board.winner
	}
	def "should mark board columns"() {
		setup:
		BingoBoard board = new BingoBoard(INPUT)
		expect:
		!board.winner
		board.mark(14)
		!board.winner
		board.mark(10)
		!board.winner
		board.mark(18)
		!board.winner
		board.mark(22)
		!board.winner
		board.mark(2)
		board.winner
	}
	def "should calculate board score"() {
		setup:
		BingoBoard board = new BingoBoard(INPUT)
		expect:
		board.score == 325
		board.mark(14)
		board.score == 311
	}
}
