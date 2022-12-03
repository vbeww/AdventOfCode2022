import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RucksackTest {
    @Test
    fun `find item in both compartments`() {
        assertEquals('d', Rucksack("abcdefgd").mistake)
        assertEquals('d', Rucksack("abcddefg").mistake)
        assertEquals('y', Rucksack("xyzwyu").mistake)
        assertEquals('Y', Rucksack("xYzwYu").mistake)
    }

    @Test
    fun `same letter different case doesn't matter`() {
        assertEquals('a', Rucksack("abcaBC").mistake)
        assertEquals('b', Rucksack("abcAbC").mistake)
        assertEquals('c', Rucksack("abcABc").mistake)
    }

    @Test
    fun `turn mistake into correct priority`() {
        assertEquals(1, Rucksack("abcaBC").priorityOfMistake)
        assertEquals(2, Rucksack("abcAbC").priorityOfMistake)
        assertEquals(3, Rucksack("abcABc").priorityOfMistake)
        assertEquals(27, Rucksack("AbcABC").priorityOfMistake)
        assertEquals(28, Rucksack("aBcABC").priorityOfMistake)
        assertEquals(29, Rucksack("abCABC").priorityOfMistake)
    }

    @Test
    fun `check the example elves bags`() {
        val totalPriority = exampleCalories.split("\n").sumBy { Rucksack(it).priorityOfMistake }
        assertEquals(157, totalPriority)
    }

    @Test
    fun `check the puzzle elves bags for Part 1`() {
        val totalPriority = puzzleInput.split("\n").sumBy { Rucksack(it).priorityOfMistake }
        println("Part 1: $totalPriority")
    }

    private val exampleCalories = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}