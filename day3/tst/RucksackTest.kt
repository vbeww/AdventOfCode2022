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

    private val exampleCalories = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}