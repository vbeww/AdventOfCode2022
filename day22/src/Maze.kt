class Maze(layout: String) {
    private val map = layout.split("\n").mapIndexed { row, line ->
        line.mapIndexed { column, tile ->
            (row to column) to tile
        }.filter { it.second != ' ' }
    }.flatten().toMap()

    private var currentPosition = map.keys.filter { it.first == 0 }.minBy { it.second }!!
    private var direction = 0

    fun walk(instructions: String): Int {
        var i = 0
        while (i < instructions.length) {
            val (newIndex, steps) = readSteps(i, instructions)
            var newPosition = stepForward()
            var step = 0
            while (step < steps && map[newPosition] != '#') {
                currentPosition = newPosition
                newPosition = stepForward()

                step++
            }
            direction = turn(newIndex, instructions)
            i = newIndex + 1
        }
        return (currentPosition.first + 1) * 1000 + (currentPosition.second + 1) * 4 + direction
    }

    private fun turn(newIndex: Int, instructions: String) = when {
        newIndex >= instructions.length -> direction
        instructions[newIndex] == 'L' -> direction + 3
        instructions[newIndex] == 'R' -> direction + 1
        else -> direction
    } % 4

    private fun stepForward(): Pair<Int, Int> {
        val forward = when (direction) {
            0 -> currentPosition.first to currentPosition.second + 1
            1 -> currentPosition.first + 1 to currentPosition.second
            2 -> currentPosition.first to currentPosition.second - 1
            else -> currentPosition.first - 1 to currentPosition.second
        }
        return if (map.containsKey(forward)) forward
        else when (direction) {
            0 -> map.keys.filter { it.first == forward.first }.minBy { it.second }
            1 -> map.keys.filter { it.second == forward.second }.minBy { it.first }
            2 -> map.keys.filter { it.first == forward.first }.maxBy { it.second }
            else -> map.keys.filter { it.second == forward.second }.maxBy { it.first }
        }!!
    }

    private fun readSteps(index: Int, instructions: String): Pair<Int, Int> {
        var i = index
        while (i < instructions.length && instructions[i] in '0'..'9') i++
        return i to instructions.substring(index, i).toInt()
    }

}
