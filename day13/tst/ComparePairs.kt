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
}