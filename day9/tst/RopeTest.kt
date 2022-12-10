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

    @Test
    fun multipleSteps() {
        assertEquals(5, Rope("R 5").groundCovered)
        assertEquals(3, Rope("L 3").groundCovered)
        assertEquals(2, Rope("U 2").groundCovered)
        assertEquals(4, Rope("D 4").groundCovered)
    }
}