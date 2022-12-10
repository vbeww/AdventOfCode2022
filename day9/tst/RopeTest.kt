import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RopeTest {
    @Test
    fun singleStep() {
        assertEquals(1, Rope("R 1").groundCovered)
        assertEquals(1, Rope("L 1").groundCovered)
        assertEquals(1, Rope("U 1").groundCovered)
        assertEquals(1, Rope("D 1").groundCovered)
    }
}