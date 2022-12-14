class Hill(map: String) {
    private val terrain: MutableMap<Pair<Int, Int>, Char>
    private val width: Int
    private val height: Int

    init {
        val lines = map.split("\n")
        terrain = lines.indices.map { y ->
            lines[0].indices.map { x ->
                (x to y) to lines[y][x]
            }
        }.flatten().toMap().toMutableMap()
        width = lines[0].length
        height = lines.size
    }

    fun part1(): Int {
        return climb('S', 'E') { current, next ->
            terrain.getValue(current) == 'S' && terrain.getValue(next) in 'a'..'b'
                    || terrain.getValue(next) >= 'a' && terrain.getValue(next).toInt() <= terrain.getValue(current).toInt() + 1
                    || terrain.getValue(next) == 'E' && (terrain.getValue(current) == 'z' || terrain.getValue(current) == 'y')
        }
    }

    fun part2(): Int {
        return climb('E', 'a') { current, next ->
            terrain.getValue(current).toInt() - 1 <= terrain.getValue(next).toInt()
        }
    }

    private fun climb(start: Char, end: Char, canClimb: (current: Pair<Int, Int>, next: Pair<Int, Int>) -> Boolean): Int {
        var steps = 0
        var current = setOf(terrain.filter { it.value == start }.keys.first())
        while (current.isNotEmpty() && current.none { terrain[it] == end }) {
            val nextSteps = current.map { position ->
                position.possibleAdjacent(width, height).filter { canClimb(position, it) }
            }.flatten().toSet()
            current.forEach {
                terrain[it] = '▓'
            }
            current = nextSteps
            steps++
        }
        return steps
    }
}

private fun Pair<Int, Int>.possibleAdjacent(width: Int, height: Int): Set<Pair<Int, Int>> {
    val set = mutableSetOf<Pair<Int, Int>>()
    if (this.first != 0) set.add(this.first - 1 to this.second)
    if (this.second != 0) set.add(this.first to this.second - 1)
    if (this.first < width - 1) set.add(this.first + 1 to this.second)
    if (this.second < height - 1) set.add(this.first to this.second + 1)
    return set
}
