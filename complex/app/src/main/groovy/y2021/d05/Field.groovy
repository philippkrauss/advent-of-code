package y2021.d05

class Field {
	private static int XMAX = 1000
	private static int YMAX = 1000
	private List<List<Integer>> field = []

	Field() {
		(0..XMAX).each {
			List<Integer> row = []
			(0..YMAX).each {
				row << 0
			}
			field << row
		}
	}

	void addLine(Line line) {
		if (line.horizontalOrVertical) {
			(line.x1..line.x2).each { Integer x ->
				(line.y1..line.y2).each { Integer y ->
					int currentValue = field[x][y]
					field[x][y] = ++currentValue
				}
			}
		} else {
			int currentX = line.x1
			int currentY = line.y1
			int xIncrease = line.x1 > line.x2 ? -1 : 1
			int yIncrease = line.y1 > line.y2 ? -1 : 1
			do {
				int currentValue = field[currentX][currentY]
				field[currentX][currentY] = ++currentValue
				currentX += xIncrease
				currentY += yIncrease
			} while (currentX != line.x2 + xIncrease)
		}
	}

	int numberAt(int x, int y) {
		field[x][y]
	}

	int getNumberOfOverlaps() {
		int overlaps = 0;
		(0..XMAX).each { Integer x ->
			List<Integer> row = []
			(0..YMAX).each { Integer y ->
				if (field[x][y] > 1) {
					overlaps++
				}
			}
		}
		overlaps
	}
}
