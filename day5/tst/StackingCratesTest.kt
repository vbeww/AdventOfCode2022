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

    @Test
    fun `applying instruction changes stacks`() {
        val warehouse = Warehouse(exampleInput.split("\n\n")[0])
        val instruction = Instruction(1, 2, 3)
        warehouse.moveCrates(listOf(instruction))

        assertEquals("NCD", warehouse.cratesOnTop())
    }

    @Test
    fun `applying instruction with multiple moves changes stacks`() {
        val warehouse = Warehouse(exampleInput.split("\n\n")[0])
        val instruction = Instruction(2, 2, 3)
        warehouse.moveCrates(listOf(instruction))

        assertEquals("NMC", warehouse.cratesOnTop())
    }

    @Test
    fun `input with large numbers translates to a set of instructions`() {
        val instructions = Instructions("move 24 from 41 to 25")
        assertEquals(Instruction(24, 41, 25), instructions.instructions.first())
    }

    @Test
    fun `rearrange example warehouse`() {
        val warehouse = Warehouse(exampleInput.split("\n\n")[0])
        val instructions = Instructions(exampleInput.split("\n\n")[1]).instructions
        warehouse.moveCrates(instructions)

        assertEquals("CMZ", warehouse.cratesOnTop())
    }

    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}