class TetrisGame(private val gasDirections: String) {
    private val width = 7

    private var field = mutableListOf<Tile>()
    private val states = mutableMapOf<String, Pair<Tile, Long>>()

    fun height() = field.map { it.yPosition }.max() ?: 0

    fun play(times: Long) {
        var gasIndex = 0
        var round = 0L
        while (round < times) {
            var currentTile = Tile(2L to height() + 3, possibleTiles[(round % 5).toInt()])
            do {
                val moved = move(currentTile, gasDirections[gasIndex])
                gasIndex = (gasIndex + 1) % gasDirections.length
                currentTile = drop(moved)
                if (gasIndex == 0) {
                    val state = field.joinToString("", "${round % 5}") { "" + it.xPos }
                    states[state]?.apply {
                        val pair = repeatedlyExecute(this, round, currentTile, times)
                        currentTile = pair.first
                        round = pair.second
                    }
                    states[state] = currentTile to round
                    field = field.subList(maxOf(0, field.size - 15), field.size)
                }
//                print(currentTile)
            } while (moved != currentTile)
            field.add(currentTile)
            round++
        }
        print()
    }

    private fun repeatedlyExecute(exists: Pair<Tile, Long>, round: Long, currentTile: Tile, times: Long): Pair<Tile, Long> {
        var round1 = round
        var currentTile1 = currentTile
        val rocks = round1 - exists.second
        val height = currentTile1.yPosition - exists.first.yPosition
        val repeatLoop = (times - round1) / rocks
        round1 += repeatLoop * rocks
        field = field.subList(maxOf(0, field.size - 15), field.size).map { it.moveUp(repeatLoop * height) }
                .toMutableList()
        currentTile1 = currentTile1.moveUp(repeatLoop * height)
        return Pair(currentTile1, round1)
    }

    private fun print(currentTile: Tile? = null) {
        println((height() + 6 downTo maxOf(0, height() - 10)).joinToString("\n") { y ->
            (0 until 7L).joinToString("", "|", "|") { x ->
                when {
                    currentTile?.overlapsPosition(x to y) == true -> "@"
                    field.any { restingTile -> restingTile.overlapsPosition(x to y) } -> "#"
                    else -> "."
                }
            }
        })
        println("-".repeat(9))
        Thread.sleep(1000)
    }

    private fun drop(tile: Tile): Tile {
        val movingTile = tile.moveDown()
        val collided = movingTile.outOfBounds() || field.any { restingTile -> restingTile.overlaps(movingTile) }
        return if (collided) tile else movingTile
    }

    private fun move(tile: Tile, direction: Char): Tile {
        val movingTile = if (direction == '<') tile.moveLeft() else tile.moveRight()
        val collided = movingTile.outOfBounds() || field.any { restingTile -> restingTile.overlaps(movingTile) }
        return if (collided) tile else movingTile
    }


    private val possibleTiles = listOf(
            TileLayout("####"),

            TileLayout(".#.\n" +
                    "###\n" +
                    ".#."),

            TileLayout("###\n" +
                    "..#\n" +
                    "..#"),

            TileLayout("#\n" +
                    "#\n" +
                    "#\n" +
                    "#"),

            TileLayout("##\n" +
                    "##")
    )
}
