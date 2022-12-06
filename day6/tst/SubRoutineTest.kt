import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SubRoutineTest {
    @Test
    fun `The device can identify the position of the packet marker`() {
        assertEquals(7, Device("mjqjpqmgbljsphdztnvjfqwrcgsmlb").packetMarkerPosition)
    }

    @Test
    fun `Confirm other examples`() {
        assertEquals(5, Device("bvwbjplbgvbhsrlpgdmjqwftvncz").packetMarkerPosition)
        assertEquals(6, Device("nppdvjthqldpwncqszvftbrmjlhg").packetMarkerPosition)
        assertEquals(10, Device("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").packetMarkerPosition)
        assertEquals(11, Device("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").packetMarkerPosition)
    }

    @Test
    fun `Part 1`() {
        println("Part 1: ${Device(puzzleInput).packetMarkerPosition}")
    }

    @Test
    fun `The device can identify the position of the message marker`() {
        assertEquals(19, Device("mjqjpqmgbljsphdztnvjfqwrcgsmlb").messageMarkerPosition)
    }

    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}