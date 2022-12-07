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

    @Test
    fun `file size of multiple files in single folder`() {
        val filestore = Filestore("""
            ${'$'} cd /
            ${'$'} ls
            100 b.txt
            dir a
            300 b.txt
        """.trimIndent())
        assertEquals(400, filestore.totalOfAtMost100_000())
    }

    @Test
    fun `folders larger then 100_000 are not counted`() {
        val filestore = Filestore("""
            ${'$'} cd /
            ${'$'} ls
            100000 b.txt
            dir a
            300 b.txt
        """.trimIndent())
        assertEquals(0, filestore.totalOfAtMost100_000())
    }

    @Test
    fun `also count sub-folder size`() {
        val filestore = Filestore("""
            ${'$'} cd /
            ${'$'} ls
            100 b.txt
            dir a
            300 b.txt
            ${'$'} cd a
            ${'$'} ls
            50 c.txt
        """.trimIndent())
        assertEquals(500, filestore.totalOfAtMost100_000())
    }
}