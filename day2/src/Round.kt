import java.lang.IllegalArgumentException

class Round(round: String) {
    private val opponentMove = asMove(round[0])
    private val myMove = asMove(round[2])

    enum class Move(val value:Int) {
        Rock(1),
        Paper(2),
        Scissors(3)
    }

    private fun asMove(gesture: Char): Move {
        return when (gesture) {
            'A', 'X' -> Move.Rock
            'B', 'Y' -> Move.Paper
            'C', 'Z' -> Move.Scissors
            else -> throw IllegalArgumentException("Unknown gesture: $gesture")
        }
    }

    val score = myMove.value + 6
}