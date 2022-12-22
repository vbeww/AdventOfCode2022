class Maze(layout: String) {
    private val map = layout.split("\n").mapIndexed { row, line ->
        line.mapIndexed { column, tile ->
            (row to column) to tile
        }.filter { it.second != ' ' }
    }.flatten().toMap()

    private val currentPosition = map.keys.filter { it.first == 0 }.minBy { it.second }!!

    fun walk(instructions: String): Int {
        val newPosition = currentPosition.first to currentPosition.second + 1
        return newPosition.first * 1000 + newPosition.second * 4 + 0
    }

}
