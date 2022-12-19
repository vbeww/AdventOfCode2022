import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Testris {
    @Test
    fun `all to the right`() {
        val game = TetrisGame(">")
        game.play(5)

        assertEquals(13, game.height())
    }

    @Test
    fun `all to the left`() {
        val game = TetrisGame("<")
        game.play(5)

        assertEquals(11, game.height())
    }

    @Test
    fun `wiggle`() {
        val game = TetrisGame("<>")
        game.play(5)

        assertEquals(11, game.height())
    }

    @Test
    fun `leftThenRight`() {
        val game = TetrisGame("<<<>>>")
        game.play(5)

        assertEquals(7, game.height())
    }

    @Test
    fun `example`() {
        val game = TetrisGame(exampleInput)
        game.play(2022)

        assertEquals(3068, game.height())
    }

    @Test
    fun `Part 1`() {
        val game = TetrisGame(puzzleInput)
        game.play(2022)

        println("Part 1: " + game.height())
    }

    @Test
    fun `example 2`() {
        val game = TetrisGame(exampleInput)
        game.play(1000000000000)

        assertEquals(1514285714288, game.height())
    }

    @Test
    fun `Part 2`() {
        val game = TetrisGame(puzzleInput)
        game.play(1000000000000)

        println("Part 2: " + game.height())
    }


    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}