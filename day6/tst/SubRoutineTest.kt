import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SubRoutineTest {
    @Test
    fun `The device can identify the position of the subroutine`() {
        assertEquals(7, Device("mjqjpqmgbljsphdztnvjfqwrcgsmlb").markerPosition)
    }
}