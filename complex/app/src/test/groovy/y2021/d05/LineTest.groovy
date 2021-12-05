package y2021.d05

import spock.lang.Specification

class LineTest extends Specification {

	def "should parse from string"() {
		expect:
		Line.fromString('0,1 -> 2,3') == new Line(x1: 0, y1: 1, x2: 2, y2: 3)
	}
}
