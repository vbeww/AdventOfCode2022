import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * A = Rock
 * B = Paper
 * C = Scissors
 * X = Lose
 * Y = Draw
 * Z = Win
 */
class RockPaperScissorsTestNewRules {
    @Test
    fun `draw hand scores`() {
        assertEquals(4, RoundNewRule("A Y").score)
        assertEquals(5, RoundNewRule("B Y").score)
        assertEquals(6, RoundNewRule("C Y").score)
    }

    @Test
    fun `lose hand scores`() {
        assertEquals(3, RoundNewRule("A X").score)
        assertEquals(1, RoundNewRule("B X").score)
        assertEquals(2, RoundNewRule("C X").score)
    }

    @Test
    fun `win hand scores`() {
        assertEquals(8, RoundNewRule("A Z").score)
        assertEquals(9, RoundNewRule("B Z").score)
        assertEquals(7, RoundNewRule("C Z").score)
    }

    @Test
    fun `full game score` () {
        assertEquals(12, Game(exampleInput).totalScoreNewRules)
    }

    @Test
    fun `Part 2` () {
        println("Part 2: ${Game(puzzleInput).totalScoreNewRules}")
    }

    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}
