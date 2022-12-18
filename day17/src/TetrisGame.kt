class TetrisGame(private val gasDirections: String) {
    private val width = 7

    private val field = mutableListOf<Tile>()

    fun height():Int = field.map { it.yPosition }.max() ?: 0

    fun play(times: Int) {
        var gasIndex = 0
        repeat(times) { round ->
            var currentTile = Tile(2 to height() + 3, possibleTiles[(round) % 5])
            print(currentTile)
            do {
                val moved = move(currentTile, gasDirections[gasIndex])
                gasIndex = (gasIndex + 1) % gasDirections.length
                currentTile = drop(moved)
                print(currentTile)
            } while (moved != currentTile)
            field += currentTile
        }
        print()
    }

    private fun print(currentTile: Tile? = null) {
        println((height()+6 downTo  0).joinToString("\n") { y ->
            (0 until 7).joinToString("", "|", "|") { x ->
                when {
                    currentTile?.overlapsPosition(x to y) == true -> "@"
                    field.any { restingTile -> restingTile.overlapsPosition(x to y) } -> "#"
                    else -> "."
                }
            }
        })
        println("-".repeat(9))
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
