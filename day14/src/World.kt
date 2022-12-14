class World(exampleInput: String) {
    private val rocks = exampleInput.split("\n").map { line ->
        line.split(" -> ").map {
            val coordinate = it.split(",")
            coordinate[0].toInt() to coordinate[1].toInt()
        }.let { coordinates ->
            (0 until coordinates.size - 1).map { i ->
                val xPositions = listOf(coordinates[i].first, coordinates[i + 1].first).sorted()
                val yPositions = listOf(coordinates[i].second, coordinates[i + 1].second).sorted()
                (xPositions[0]..xPositions[1]).map { x ->
                    (yPositions[0]..yPositions[1]).map { y ->
                        x to y
                    }
                }.flatten()
            }
        }.flatten()
    }.flatten().toMutableList()

    private val lowest = rocks.map { it.second }.max()!!

    fun withinRock(sand: Pair<Int, Int>) = rocks.contains(sand)
    fun dropSand(): Int {
        var numberOfSandDrops = 0
        var outOfBounds = false
        while (!outOfBounds) {
            var sand = 500 to 0
            var stopped = false
            while (!stopped && !outOfBounds) {
                val below = sand.first to sand.second + 1
                val left = sand.first - 1 to sand.second + 1
                val right = sand.first + 1 to sand.second + 1
                sand = when {
                    !withinRock(below) -> below
                    !withinRock(left) -> left
                    !withinRock(right) -> right
                    else -> {
                        stopped = true
                        numberOfSandDrops++
                        rocks.add(sand)
                        sand
                    }
                }
                if (sand.second >= lowest) {
                    outOfBounds = true
                }
            }
        }
        return numberOfSandDrops
    }
}
