class TetrisGame(private val gasDirections: String) {
    private val width = 7

    private val field = mutableListOf<Tile>()

    fun height():Int = field.map { it.yPosition }.max() ?: 0

    fun play(times: Int) {
        repeat(times) { round ->
            print()
            var currentTile = Tile(2 to height() + 3, possibleTiles[(round) % 5])
            do {
                val moved = move(currentTile)
                currentTile = drop(moved)
            } while (moved != currentTile)
            field += currentTile
        }
        print()
    }

    private fun print() {
        println((height() downTo  0).joinToString("\n") { y ->
            (0 until 7).joinToString("", "|", "|") { x ->
                if (field.any { restingTile -> restingTile.overlapsPosition(x to y) }) "#" else "."
            }
        })
    }

    private fun drop(tile: Tile): Tile {
        val movingTile = tile.moveDown()
        val collided = movingTile.outOfBounds() || field.any { restingTile -> restingTile.overlaps(movingTile) }
        return if (collided) tile else movingTile
    }

    private fun move(tile: Tile): Tile {
        val movingTile = tile.moveRight()
        val collided = movingTile.outOfBounds() || field.any { restingTile -> restingTile.overlaps(movingTile) }
        return if (collided) tile else movingTile
    }


    private val possibleTiles = listOf(
            TileLayout("####"),

            TileLayout(".#.\n" +
                    "###\n" +
                    ".#."),

            TileLayout("..#\n" +
                    "..#\n" +
                    "###"),

            TileLayout("#\n" +
                    "#\n" +
                    "#\n" +
                    "#"),

            TileLayout("##\n" +
                    "##")
    )
}
