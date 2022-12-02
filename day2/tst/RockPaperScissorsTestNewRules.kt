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

    private val exampleCalories = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}
