class Maze(layout: String) {
    private val map = layout.split("\n").mapIndexed { row, line ->
        line.mapIndexed { column, tile ->
            (row to column) to tile
        }.filter { it.second != ' ' }
    }.flatten().toMap()

    private var currentPosition = map.keys.filter { it.first == 0 }.minBy { it.second }!!

    fun walk(instructions: String): Int {
        var i = 0
        val (newIndex, steps) = readSteps(i, instructions)
        var newPosition = currentPosition.first to currentPosition.second + 1
        var step = 0
        while (step < steps && map[newPosition] != '#') {
            currentPosition = newPosition
            newPosition = newPosition.first to newPosition.second + 1
            step++
        }
        i = newIndex
        return currentPosition.first * 1000 + currentPosition.second * 4 + 0
    }

    private fun readSteps(index: Int, instructions: String): Pair<Int, Int> {
        var i = index
        while (i < instructions.length && instructions[i] in '0'..'9') i++
        return i to instructions.substring(index, i).toInt()
    }

}
