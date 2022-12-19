class TileLayout(s: String) {
    val height: Int
    private val layout: List<Pair<Int, Int>>

    init {
        val lines = s.split("\n")
        height = lines.size
        layout = lines.mapIndexed {i, line ->
             line.indices.filter { line[it] == '#' }.map { it to i }
        }.flatten()
    }

    fun relativePosition (position: Pair<Long, Long>) =
            layout.map { position.first + it.first to position.second + it.second }
}
