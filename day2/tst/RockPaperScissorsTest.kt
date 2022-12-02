import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * A & X = Rock
 * B & Y = Paper
 * C & Z = Scissors
 */
class RockPaperScissorsTest {
    @Test
    fun `winning hand scores`() {
        assertEquals(7, Round("C X").score)
        assertEquals(8, Round("A Y").score)
        assertEquals(9, Round("B Z").score)
    }

    @Test
    fun `draw hand scores`() {
        assertEquals(4, Round("A X").score)
        assertEquals(5, Round("B Y").score)
        assertEquals(6, Round("C Z").score)
    }

    @Test
    fun `losing hand scores`() {
        assertEquals(1, Round("B X").score)
        assertEquals(2, Round("C Y").score)
        assertEquals(3, Round("A Z").score)
    }

    @Test
    fun `full game score` () {
        assertEquals(15, Game(exampleCalories).totalScore)
    }

    @Test
    fun `Part 1` () {
        println("Part 1: ${Game(puzzleInput).totalScore}")
    }
    
    private val exampleCalories = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}
