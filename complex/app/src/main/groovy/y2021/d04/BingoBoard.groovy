package y2021.d04

class BingoBoard {

	private List<List<BoardMember>> board = []

	BingoBoard(List<String> input) {
		board = input.collect { String line ->
			line.split().collect { String number ->
				new BoardMember(number: Integer.parseInt(number))
			}
		}
	}

	private BoardMember memberAt(int row, int col) {
		return board[row][col]
	}

	int numberAt(int row, int col) {
		return memberAt(row, col).number
	}

	void mark(int number) {
		board.forEach {
			it.forEach { BoardMember member ->
				if (member.number == number) {
					member.marked = true
				}
			}
		}
	}

	boolean isWinner() {
		for (int row = 0; row < 5; row++) {
			boolean rowMarked = true
			for (int col = 0; col < 5; col++) {
				rowMarked &= memberAt(row, col).marked
			}
			if (rowMarked) {
				return true
			}
		}
		for (int col = 0; col < 5; col++) {
			boolean colMarked = true
			for (int row = 0; row < 5; row++) {
				colMarked &= memberAt(row, col).marked
			}
			if (colMarked) {
				return true
			}
		}
		return false
	}

	int getScore() {
		int score = 0
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				if (!memberAt(row, col).marked) {
					score += numberAt(row, col)
				}
			}
		}
		return score
	}
}

class BoardMember {
	int number
	boolean marked = false
}
