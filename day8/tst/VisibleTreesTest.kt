import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VisibleTreesTest {
    @Test
    fun `two by two field has all trees visible`() {
        val forest = Forest("""
            11
            11
        """.trimIndent())
        assertEquals(4, forest.numberOfVisibleTrees())
    }

    @Test
    fun `three by three field with middle tree highest has all trees visible`() {
        val forest = Forest("""
            111
            121
            111
        """.trimIndent())
        assertEquals(9, forest.numberOfVisibleTrees())
    }

    @Test
    fun `three by three field with middle tree lowest has the middle tree hidden`() {
        val forest = Forest("""
            111
            101
            111
        """.trimIndent())
        assertEquals(8, forest.numberOfVisibleTrees())
    }

    @Test
    fun `Example forrest`() {
        val forest = Forest(exampleInput)
        assertEquals(21, forest.numberOfVisibleTrees())
    }

    @Test
    fun `Part 1`() {
        val forest = Forest(puzzleInput)
        println("Part 1: " + forest.numberOfVisibleTrees())
    }

    @Test
    fun `highest scenic score example forest`() {
        val forest = Forest(exampleInput)
        assertEquals(8, forest.highestScenicScore())
    }

    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}