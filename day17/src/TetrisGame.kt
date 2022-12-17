class TetrisGame(private val gasDirections: String) {
    fun play(times: Int) {
    }

    fun height() = 13

    private val field = mutableMapOf<Pair<Int, Int>, Tile>()

    private val possibleTiles = listOf(
            Tile("####"),

            Tile(".#.\n" +
                    "###\n" +
                    ".#."),

            Tile("..#\n" +
                    "..#\n" +
                    "###"),

            Tile("#\n" +
                    "#\n" +
                    "#\n" +
                    "#"),

            Tile("##\n" +
                    "##")
    )
}
