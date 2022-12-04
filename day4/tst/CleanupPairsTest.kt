import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CleanupPairsTest {
    @Test
    fun `an Elf knows if his cleanup sections contain another Elf's sections fully`() {
        assertTrue(Elf("2-4").containsSections(Elf("3-3")))
        assertTrue(Elf("2-8").containsSections(Elf("4-8")))
        assertTrue(Elf("7-9").containsSections(Elf("9-9")))
        assertTrue(Elf("7-9").containsSections(Elf("7-7")))
    }

    @Test
    fun `an Elf knows if his cleanup sections does not contain part of another Elf's sections`() {
        assertFalse(Elf("92-123").containsSections(Elf("12-17")))
        assertFalse(Elf("3-3").containsSections(Elf("2-4")))
        assertFalse(Elf("4-4").containsSections(Elf("2-4")))
    }
}