import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NoSpaceLeftTest {
    @Test
    fun `file size of single folder`() {
        val filestore = Filestore("""
            ${'$'} cd /
            ${'$'} ls
            dir a
            300 b.txt
        """.trimIndent())
        assertEquals(300, filestore.totalOfAtMost100_000())
    }
}