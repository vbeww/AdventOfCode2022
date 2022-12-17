import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Testris {
    @Test
    fun `all to the right`() {
        val game = TetrisGame(">")
        game.play(5)

        assertEquals(13, game.height())
    }
}