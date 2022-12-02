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

}