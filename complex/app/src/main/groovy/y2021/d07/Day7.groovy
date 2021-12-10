package y2021.d07

class Day7 {
	static void main(String... args) {
		String input = new File(Day7.class.getResource('input.txt').file).readLines().get(0)
		List<Integer> data = input.split(',').collect { it as Integer }
		data = data.toSorted()
		Map<Integer, Integer> countedData = data.countBy { it }
		Integer max = data.last()

		println "part 1: ${calculateMinFuel(max, countedData)}"
		println "part 2: ${calculateMinFuel2(max, countedData)}"
	}

	static int calculateMinFuel(int max, Map<Integer, Integer> countedData) {
		int minPosition = 0
		int minValue = Integer.MAX_VALUE
		(0..max).each { Integer target ->
			int fuelForTarget = countedData.inject(0, { counter, entry ->
				int currentPosition = entry.key
				int count = entry.value
				int consumedFuel = count * Math.abs(target - currentPosition)
				counter + consumedFuel
			})
			if (fuelForTarget < minValue) {
				minPosition = target
				minValue = fuelForTarget
			}
		}
		return minValue
	}

	static int calculateMinFuel2(int max, Map<Integer, Integer> countedData) {
		int minPosition = 0
		int minValue = Integer.MAX_VALUE
		(0..max).each { Integer target ->
			int fuelForTarget = countedData.inject(0, { counter, entry ->
				int currentPosition = entry.key
				int count = entry.value
				int consumedFuel = count * calculateFuelComplex(Math.abs(target - currentPosition))
				counter + consumedFuel
			})
			if (fuelForTarget < minValue) {
				minPosition = target
				minValue = fuelForTarget
			}
		}
		return minValue
	}

	static int calculateFuelComplex(int diff) {
		if (diff == 0)
			return 0
		if (diff == 1)
			return 1
		return diff + calculateFuelComplex(diff - 1)
	}



}
