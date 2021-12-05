package y2021.d05

import spock.lang.Specification

class FieldTest extends Specification {

	void "should add vertical line to field"() {
		setup:
		Field field = new Field()
		Line line = new Line(x1: 1, y1: 1, x2: 1, y2: 2)
		when:
		field.addLine(line)
		then:
		field.numberAt(1, 0) == 0
		field.numberAt(1, 1) == 1
		field.numberAt(1, 2) == 1
		field.numberAt(1, 3) == 0
		field.numberAt(0, 1) == 0
		field.numberAt(2, 1) == 0
	}

	void "should add reverse vertical line to field"() {
		setup:
		Field field = new Field()
		Line line = new Line(x1: 1, y1: 2, x2: 1, y2: 1)
		when:
		field.addLine(line)
		then:
		field.numberAt(1, 0) == 0
		field.numberAt(1, 1) == 1
		field.numberAt(1, 2) == 1
		field.numberAt(1, 3) == 0
		field.numberAt(0, 1) == 0
		field.numberAt(2, 1) == 0
	}

	void "should add two lines"() {
		setup:
		Field field = new Field()
		Line line1 = new Line(x1: 1, y1: 1, x2: 1, y2: 2)
		Line line2 = new Line(x1: 1, y1: 2, x2: 1, y2: 3)
		when:
		field.addLine(line1)
		field.addLine(line2)
		then:
		field.numberAt(1, 0) == 0
		field.numberAt(1, 1) == 1
		field.numberAt(1, 2) == 2
		field.numberAt(1, 3) == 1
		field.numberAt(0, 4) == 0
	}

	void "should count overlaps"() {
		setup:
		Field field = new Field()
		Line line1 = new Line(x1: 1, y1: 1, x2: 1, y2: 2)
		Line line2 = new Line(x1: 1, y1: 2, x2: 1, y2: 3)
		when:
		field.addLine(line1)
		field.addLine(line2)
		then:
		field.numberOfOverlaps == 1
	}

	void "should add diagonal line to field"() {
		setup:
		Field field = new Field()
		Line line = new Line(x1: 1, y1: 1, x2: 2, y2: 2)
		when:
		field.addLine(line)
		then:
		field.numberAt(0, 0) == 0
		field.numberAt(1, 1) == 1
		field.numberAt(2, 2) == 1
		field.numberAt(3, 3) == 0
		field.numberAt(1, 0) == 0
		field.numberAt(2, 1) == 0
		field.numberAt(3, 2) == 0
		field.numberAt(0, 1) == 0
		field.numberAt(1, 2) == 0
		field.numberAt(2, 3) == 0
	}
}
