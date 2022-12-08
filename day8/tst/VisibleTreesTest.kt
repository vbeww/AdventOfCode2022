import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VisibleTreesTest {
    @Test
    fun `two by two field has all trees visible`() {
        val forest = Forest("""
            11
            11
        """.trimIndent())
        assertEquals(4, forest.numberOfVisibleTrees)
    }
}