import java.lang.IllegalArgumentException
import kotlin.math.abs

class Rope(instructions: String, knots: Int = 2) {
    val groundCovered: Int

    init {
        var rope = MutableList(knots) { 0 to 0 }
        val tailTrail = mutableSetOf(0 to 0)
        instructions.split("\n").map { it.split(" ") }.map { it[0] to it[1].toInt() }.forEach { instruction ->
            val head = rope[0]
            rope[0] = when (instruction.first) {
                "R" -> head.first + instruction.second to head.second
                "L" -> head.first - instruction.second to head.second
                "U" -> head.first to head.second - instruction.second
                "D" -> head.first to head.second + instruction.second
                else -> throw IllegalArgumentException("Unexpected input $instruction")
            }
            moveRope(rope, tailTrail)
        }
        groundCovered = tailTrail.size
    }

    private fun moveRope(rope: MutableList<Pair<Int, Int>>, tailTrail: MutableSet<Pair<Int, Int>>) {
        while (!(1 until rope.size).all { rope[it].nextTo(rope[it - 1]) }) {
            (1 until rope.size).forEach {
                if (!rope[it].nextTo(rope[it - 1])) {
                    rope[it] = rope[it].getCloser(rope[it - 1])
                    if (it == rope.size - 1) tailTrail.add(rope[it])
                }
            }
        }
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

