class Warehouse(input: String) {
    val stacks: MutableList<MutableList<Char>> = mutableListOf()

    init {
        val lines = input.split("\n").asReversed()
        val numberOfStacks = lines.first().split(" ").last().let { it.toInt() }
        (0 until numberOfStacks).forEach { stacks.add(mutableListOf()) }


        (1 until lines.size).forEach { lineNumber ->
            (0 until numberOfStacks).forEach { stack ->
                val line = lines[lineNumber]
                val stackPositionOnLine = stack * 4 + 1
                if (stackPositionOnLine < line.length) {
                    val crate = line[stackPositionOnLine]
                    if (crate != ' ') stacks[stack].add(crate)
                }
            }
        }
    }

    fun cratesOnTop() = stacks.map { it.lastOrNull() ?: "" }.joinToString("")
}