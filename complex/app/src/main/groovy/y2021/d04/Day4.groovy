package y2021.d04

class Day4 {
	String rolls
	List<BingoBoard> boards = []

	Day4(String input) {
		LinkedList<String> lines = new LinkedList<>(Arrays.asList(input.split('\n')))
		rolls = lines.pollFirst()
		List<String> currentBoard = []
		lines.each { String line ->
			if (!line && currentBoard) {
				boards << new BingoBoard(currentBoard)
				currentBoard.clear()
			} else if (line) {
				currentBoard << line
			}
		}
		if (currentBoard) {
			boards << new BingoBoard(currentBoard)
		}
	}

	void mark(int roll) {
		boards.each { it.mark(roll) }
	}

	BingoBoard getWinner() {
		boards.find { it.winner }
	}

	void removeBoard(BingoBoard board) {
		boards.remove(board)
	}

	static void main(String[] args) {
		Day4 day4 = new Day4(new File(Day4.class.getResource('input.txt').file).text)
		LinkedList<String> rolls = day4.rolls.split(',') as LinkedList

		BingoBoard firstWinner = null
		int firstWinnerRoll = 0
		BingoBoard lastWinner = null
		int lastWinnerRoll = 0

		while (rolls) {
			int currentRoll = rolls.pollFirst() as Integer
			day4.mark(currentRoll)
			while (day4.winner) {
				if (!firstWinner) {
					firstWinner = day4.winner
					firstWinnerRoll = currentRoll
				}
				lastWinner = day4.winner
				lastWinnerRoll = currentRoll
				day4.removeBoard(day4.winner)
			}
		}
		println 'day 4 part 1: ' + firstWinner.score * firstWinnerRoll
		println 'day 4 part 2: ' + lastWinner.score * lastWinnerRoll
	}

}
