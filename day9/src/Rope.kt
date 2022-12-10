import java.lang.IllegalArgumentException
import kotlin.math.abs

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
            currentTail = follow(tailTrail, currentHead, currentTail)
        }
        groundCovered = tailTrail.size
    }

    private fun follow(tailTrail: MutableSet<Pair<Int, Int>>, currentHead: Pair<Int, Int>, currentTail: Pair<Int, Int>): Pair<Int, Int> {
        var movingTail = currentTail
        while (!movingTail.nextTo(currentHead)){
            movingTail = movingTail.getCloser(currentHead)
            tailTrail.add(movingTail)
        }
        return movingTail
    }
}

private fun Pair<Int, Int>.getCloser(other: Pair<Int, Int>): Pair<Int, Int> {
    val distance = if (this.first != other.first && this.second != other.second) 0 else 1
    return first.closer(other.first, distance) to second.closer(other.second, distance)
}

private fun Int.closer(other: Int, distance: Int): Int {
    return when {
        this - other > distance -> this - 1
        this - other < -distance -> this + 1
        else -> this
    }
}

private fun Pair<Int, Int>.nextTo(other: Pair<Int, Int>): Boolean {
    if (abs(this.first - other.first) > 1) return false
    if (abs(this.second - other.second) > 1) return false
    return true
}

