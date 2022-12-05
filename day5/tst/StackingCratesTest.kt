import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StackingCratesTest {
    @Test
    fun `input translates to stack of crates`() {
        val warehouse = Warehouse(exampleInput.split("\n\n")[0])
        assertEquals("NDP", warehouse.cratesOnTop())
    }

    @Test
    fun `input translates to a set of instructions`() {
        val instructions = Instructions("move 2 from 4 to 5")
        assertEquals(Instruction(2, 4, 5), instructions.instructions.first())
    }

    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}