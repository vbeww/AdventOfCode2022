import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SubRoutineTest {
    @Test
    fun `The device can identify the position of the packet marker`() {
        assertEquals(7, Device("mjqjpqmgbljsphdztnvjfqwrcgsmlb").packetMarkerPosition)
    }

    @Test
    fun `Confirm other packet marker examples`() {
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

    @Test
    fun `Confirm other message marker examples`() {
        assertEquals(23, Device("bvwbjplbgvbhsrlpgdmjqwftvncz").messageMarkerPosition)
        assertEquals(23, Device("nppdvjthqldpwncqszvftbrmjlhg").messageMarkerPosition)
        assertEquals(29, Device("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").messageMarkerPosition)
        assertEquals(26, Device("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").messageMarkerPosition)
    }

    @Test
    fun `Part 2`() {
        println("Part 2: ${Device(puzzleInput).messageMarkerPosition}")
    }

    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}