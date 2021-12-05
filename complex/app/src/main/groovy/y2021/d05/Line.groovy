package y2021.d05

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Line {
	int x1, x2, y1, y2

	static Line fromString(String s) {
		String[] splitted = s.split(' -> ')
		String[] start = splitted[0].split(',')
		String[] end = splitted[1].split(',')
		new Line(x1: start[0] as int,
				y1: start[1] as int,
				x2: end[0] as int,
				y2: end[1] as int)
	}

	boolean isHorizontalOrVertical() {
		return x1 == x2 || y1 == y2
	}
}
