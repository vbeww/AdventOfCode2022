import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ComparePairs {
    @Test
    fun `compare two simple examples` () {
        val packet1 = Packet("[1,1,3,1,1]")
        val packet2 = Packet("[1,1,5,1,1]")

        assertTrue(packet1 < packet2)
        assertFalse(packet2 < packet1)
    }

    @Test
    fun `compare examples with one side package` () {
        val packet1 = Packet("[[1],[2,3,4]]")
        val packet2 = Packet("[[1],4]")

        assertTrue(packet1 < packet2)
        assertFalse(packet2 < packet1)
    }

    @Test
    fun `test simple comparisons` () {
        val packet1 = Packet("[3]")
        val packet2 = Packet("[5]")
        val packet3 = Packet("[5]")

        assertTrue(packet1 < packet2)
        assertFalse(packet2 < packet1)

        assertFalse(packet3 < packet3)
        assertFalse(packet3 > packet3)
        assertTrue(packet3 == packet3)
    }

    @Test
    fun `test longer list` () {
        val packet1 = Packet("[3]")
        val packet2 = Packet("[3,5]")

        assertTrue(packet1 < packet2)
        assertFalse(packet2 < packet1)
    }

    @Test
    fun `example` () {
        assertEquals(13, SignalPairs(exampleInput).findCorrectOrderIndicesSum())
    }


    @Test
    fun `Part 1` () {
        println("Part 1 : " + SignalPairs(puzzleInput).findCorrectOrderIndicesSum())
    }

    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}