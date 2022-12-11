import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RopeTest {
    @Test
    fun singleStep() {
        assertEquals(1, Rope("R 1").groundCovered)
        assertEquals(1, Rope("L 1").groundCovered)
        assertEquals(1, Rope("U 1").groundCovered)
        assertEquals(1, Rope("D 1").groundCovered)
    }

    @Test
    fun multipleSteps() {
        assertEquals(5, Rope("R 5").groundCovered)
        assertEquals(3, Rope("L 3").groundCovered)
        assertEquals(2, Rope("U 2").groundCovered)
        assertEquals(4, Rope("D 4").groundCovered)
    }

    @Test
    fun aroundTheTail() {
        val instructions = """
            R 1
            U 1
            L 2
            D 2
            R 2
            U 2
        """.trimIndent()
        assertEquals(1, Rope(instructions).groundCovered)
    }

    @Test
    fun aroundTheCorner() {
        val instructions = """
            R 5
            U 5
        """.trimIndent()
        assertEquals(9, Rope(instructions).groundCovered)
    }

    @Test
    fun backAndForth() {
        val instructions = """
            R 5
            L 5
        """.trimIndent()
        assertEquals(5, Rope(instructions).groundCovered)
    }

    @Test
    fun backAndForthLonger() {
        val instructions = """
            R 5
            L 10
        """.trimIndent()
        assertEquals(9, Rope(instructions).groundCovered)
    }

    @Test
    fun example() {
        assertEquals(13, Rope(exampleInput).groundCovered)
    }

    @Test
    fun part1() {
        println( "Part 1: " + Rope(puzzleInput).groundCovered)
    }

    @Test
    fun exampleLongerRope() {
        assertEquals(1, Rope(exampleInput, 10).groundCovered)
        assertEquals(36, Rope(largerExampleInput, 10).groundCovered)
    }

    @Test
    fun part2() {
        println( "Part 2: " + Rope(puzzleInput, 10).groundCovered)
    }

    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val largerExampleInput = javaClass.getResource("/example2.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}