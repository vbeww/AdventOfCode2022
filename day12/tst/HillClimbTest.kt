import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HillClimbTest {
    @Test
    fun `climb straight hill`() {
        val hill = Hill("SabcdefghijklmnopqrstuvwxyzE")
        assertEquals(27, hill.part1())
    }

    @Test
    fun `climb example`() {
        val hill = Hill(exampleInput)
        assertEquals(31, hill.part1())
    }

    @Test
    fun `Part 1`() {
        val hill = Hill(puzzleInput)
        println("Part 1: " + hill.part1())
    }

    @Test
    fun `Part 2`() {
        val hill = Hill(puzzleInput)
        println("Part 2: " + hill.part2())
    }


    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}