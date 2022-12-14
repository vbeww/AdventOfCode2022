import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RockAndSand {
    @Test
    fun `world should know which positions are within rock`() {
        val world = World("100,5 -> 100,10")

        assertTrue(world.withinRock(100 to 7))
        assertTrue(world.withinRock(100 to 5))
        assertTrue(world.withinRock(100 to 10))

        assertFalse(world.withinRock(100 to 11))
        assertFalse(world.withinRock(100 to 4))
        assertFalse(world.withinRock(101 to 5))
        assertFalse(world.withinRock(99 to 7))
    }

    @Test
    fun `create example world`() {
        val world = World(exampleInput)

        assertTrue(world.withinRock(498 to 5))
        assertTrue(world.withinRock(497 to 6))
        assertTrue(world.withinRock(502 to 5))
        assertTrue(world.withinRock(500 to 9))

        assertFalse(world.withinRock(500 to 6))
    }

    @Test
    fun `create puzzle world if it doesn't take too long`() {
        World(puzzleInput)
    }

    @Test
    fun `drop sand on single line`() {
        val world = World("495,10 -> 505,10")

        assertEquals(25, world.dropSand())
    }

    @Test
    fun `drop sand on example world`() {
        val world = World(exampleInput)

        assertEquals(24, world.dropSand())
    }

    @Test
    fun `drop sand on puzzle world`() {
        val world = World(puzzleInput)

        println("Part 1: " + world.dropSand())
    }

    @Test
    fun `drop sand in way 2 on single line`() {
        val world = World("495,10 -> 505,10")

        assertEquals(124, world.dropSand2())
    }

    @Test
    fun `drop sand in way 2 on example world`() {
        val world = World(exampleInput)

        assertEquals(93, world.dropSand2())
    }

    @Test
    fun `drop sand in way 2 on puzzle world`() {
        val world = World(puzzleInput)

        println("Part 2: " + world.dropSand2())
    }

    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}