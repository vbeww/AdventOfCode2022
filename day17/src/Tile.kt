class Tile(private val position: Pair<Long, Long>, private val layout: TileLayout) {
    val xPos = position.first
    val yPosition = position.second + layout.height

    private val positions = layout.relativePosition(position)

    fun overlaps(otherTile: Tile) = positions.any {  otherTile.positions.contains(it) }
    fun overlapsPosition(position: Pair<Long, Long>) = positions.contains(position)
    fun moveRight() = Tile(position.first + 1 to position.second, layout)
    fun moveLeft() = Tile(position.first - 1 to position.second, layout)
    fun moveDown() = Tile(position.first to position.second - 1, layout)

    override fun toString(): String {
        return positions.toString()
    }

    fun outOfBounds() = positions.any {
        it.second < 0 || it.first !in 0 until 7
    }

    fun moveUp(height: Long) = Tile(xPos to position.second + height, layout)
}
