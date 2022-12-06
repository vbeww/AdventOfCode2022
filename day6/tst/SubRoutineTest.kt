import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SubRoutineTest {
    @Test
    fun `The device can identify the position of the subroutine`() {
        assertEquals(7, Device("mjqjpqmgbljsphdztnvjfqwrcgsmlb").markerPosition)
    }

    @Test
    fun `Confirm other examples`() {
        assertEquals(5, Device("bvwbjplbgvbhsrlpgdmjqwftvncz").markerPosition)
        assertEquals(6, Device("nppdvjthqldpwncqszvftbrmjlhg").markerPosition)
        assertEquals(10, Device("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").markerPosition)
        assertEquals(11, Device("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").markerPosition)

    }
}