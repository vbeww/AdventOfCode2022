class Warehouse(input: String) {
    val stacks: MutableList<MutableList<Char>> = mutableListOf()

    init {
        val lines = input.split("\n").asReversed()
        val numberOfStacks = lines.first().split(" ").last().let { it.toInt() }
        repeat(numberOfStacks) { stacks.add(mutableListOf()) }


        (1 until lines.size).forEach { lineNumber ->
            repeat(numberOfStacks) { stack ->
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
    fun moveCrates(instructions: List<Instruction>) {
        instructions.forEach { instruction ->
            val fromStack = stacks[instruction.from - 1]
            val toStack = stacks[instruction.to -1]
            repeat(instruction.moves) {
                toStack.add(fromStack.removeAt(fromStack.size -1))
            }
        }
    }
}