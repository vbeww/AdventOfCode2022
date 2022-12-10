import java.lang.IllegalArgumentException

class Rope(instructions: String) {
    val groundCovered: Int

    init {
        var currentHead = 0 to 0
        var currentTail = 0 to 0
        val tailTrail = mutableSetOf(0 to 0)
        instructions.split("\n").map { it.split(" ") }.map { it[0] to it[1].toInt() }.forEach { instruction ->
            currentHead = when (instruction.first) {
                "R" -> currentHead.first + instruction.second to currentHead.second
                "L" -> currentHead.first - instruction.second to currentHead.second
                "U" -> currentHead.first to currentHead.second - instruction.second
                "D" -> currentHead.first to currentHead.second + instruction.second
                else -> throw IllegalArgumentException("Unexpected input $instruction")
            }
        }
        groundCovered = tailTrail.size
    }
}

