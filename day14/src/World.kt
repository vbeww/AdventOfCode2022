class World(exampleInput: String) {
    private val initRocks = exampleInput.split("\n").map { line ->
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
    }.flatten()

    private val rocks = initRocks.toMutableList()

    private val lowest = rocks.map { it.second }.max()!!

    fun withinRock(sand: Pair<Int, Int>) = rocks.contains(sand)
    fun withinRock2(sand: Pair<Int, Int>) = sand.second == lowest + 2 || withinRock(sand)

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

    fun dropSand2(): Int {
        var numberOfSandDrops = 0
        var done = false
        while (!done) {
            var sand = 500 to 0
            var stopped = false
            while (!stopped) {
                var below = sand.first to sand.second + 1
                var left = sand.first - 1 to sand.second + 1
                var right = sand.first + 1 to sand.second + 1
                sand = when {
                    !withinRock2(below) -> below
                    !withinRock2(left) -> left
                    !withinRock2(right) -> right
                    else -> {
                        stopped = true
                        numberOfSandDrops++
                        rocks.add(sand)
                        if (!initRocks.contains(sand.first to sand.second + 2)) rocks.remove(sand.first to sand.second + 2)
                        if (sand.second == lowest + 1) {
                            print()
                        }
                        sand
                    }
                }
                done = sand == 500 to 0
            }
        }
        return numberOfSandDrops
    }

    fun dropSand3(): Int {
        var current = setOf(500 to 0)
        return (1..lowest + 1).sumBy { line ->
            current = current.map { sand ->
                listOf(
                        sand.first - 1 to sand.second + 1, // left
                        sand.first to sand.second + 1, // below
                        sand.first + 1 to sand.second + 1 // right
                ).filter { !withinRock(it) }
            }.flatten().toSet()
            current.size
        } + 1 // top sand grain
    }

    private fun print() {
        (10..20).forEach { y ->
            println((450..600).map { x ->
                when {
                    initRocks.contains(x to y) -> '#'
                    rocks.contains(x to y) -> 'O'
                    else -> '.'
                }
            }.joinToString(""))
        }
    }
}
