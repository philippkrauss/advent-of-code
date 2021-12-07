package y2021.d06

class Day6 {
	static void main(String... args) {
		String input = new File(Day6.class.getResource('input.txt').file).readLines().get(0)
		String[] values = input.split(',')
		def lanternFish = values.collect {
			it as Integer
		}
		int numberOfGenerations = 80
		(1..numberOfGenerations).each {
			def newLanternFish = [] as ArrayList
			long t0 = System.currentTimeMillis()
			println 'computing generation ' + it
			lanternFish.forEach {
				int age = it
				age = age - 1
				if (age < 0) {
					newLanternFish << (6 as Integer)
					newLanternFish << (8 as Integer)
				} else {
					newLanternFish << (age as Integer)
				}
			}
			lanternFish = newLanternFish
			long t1 = System.currentTimeMillis()
			println 'generation ' + it + ' computation took ' + (t1 - t0) + ', size: ' + lanternFish.size()
		}
	}
}
