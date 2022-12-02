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

    private val points = when {
        opponentMove == myMove -> 3
        opponentMove == Move.Rock && myMove == Move.Paper -> 6
        opponentMove == Move.Paper && myMove == Move.Scissors -> 6
        opponentMove == Move.Scissors && myMove == Move.Rock -> 6
        else -> 0
    }

    val score = myMove.value + points
}