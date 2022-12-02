import java.lang.IllegalArgumentException

class RoundNewRule(round: String) {
    private val opponentMove = asMove(round[0])
    private val myMove = asCounterMove(round[2])


    enum class Move(val value:Int) {
        Rock(1),
        Paper(2),
        Scissors(3)
    }

    private fun asMove(gesture: Char): Move {
        return when (gesture) {
            'A' -> Move.Rock
            'B' -> Move.Paper
            'C' -> Move.Scissors
            else -> throw IllegalArgumentException("Unknown gesture: $gesture")
        }
    }
    private fun asCounterMove(gesture: Char): Move {
        return when (gesture) {
            'X' -> opponentMove.beats()
            'Y' -> opponentMove
            'Z' -> opponentMove.beats().beats()
            else -> throw IllegalArgumentException("Unknown gesture: $gesture")
        }
    }

    private val points = when(round[2]) {
        'X' -> 0
        'Y' -> 3
        'Z' -> 6
        else -> throw IllegalArgumentException("Unknown gesture: ${round[2]}")
    }

    val score = myMove.value + points

    /* Alternative with a score lookup table:
        val score when(round) {
            "A X" -> 3
            "A Y" -> 4
            "A Z" -> 8
            "B X" -> 1
            "B Y" -> 5
            "B Z" -> 9
            "C X" -> 2
            "C Y" -> 6
            "C Z" -> 7
            else -> throw IllegalArgumentException("Unknown combination of gestures: $round")
        }
    */
}

private fun RoundNewRule.Move.beats() = when (this)  {
    RoundNewRule.Move.Rock -> RoundNewRule.Move.Scissors
    RoundNewRule.Move.Paper -> RoundNewRule.Move.Rock
    RoundNewRule.Move.Scissors -> RoundNewRule.Move.Paper
}
