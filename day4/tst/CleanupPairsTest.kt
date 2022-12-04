import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CleanupPairsTest {
    @Test
    fun `an Elf knows if his cleanup sections contain anothers Elfs sections fully`() {
        assertTrue(Elf("2-4").containsSections(Elf("3-3")))
        assertTrue(Elf("2-8").containsSections(Elf("4-8")))
    }
}