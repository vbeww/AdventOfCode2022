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
    fun `count sub-folder size`() {
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

    @Test
    fun `count deep nested folders size`() {
        val filestore = Filestore("""
            ${'$'} cd /
            ${'$'} ls
            100 b.txt
            dir a
            300 b.txt
            ${'$'} cd a
            ${'$'} ls
            50 c.txt
            dir b
            ${'$'} cd b
            ${'$'} ls
            2 d.txt
        """.trimIndent())
        assertEquals(506, filestore.totalOfAtMost100_000())
    }

    @Test
    fun `count folders side-by-side size`() {
        val filestore = Filestore("""
            ${'$'} cd /
            ${'$'} ls
            100 b.txt
            dir a
            300 b.txt
            dir b
            ${'$'} cd a
            ${'$'} ls
            50 c.txt
            ${'$'} cd ..
            ${'$'} cd b
            ${'$'} ls
            2 d.txt
        """.trimIndent())
        assertEquals(504, filestore.totalOfAtMost100_000())
    }

    @Test
    fun `example listing`() {
        assertEquals(95437, Filestore(exampleInput).totalOfAtMost100_000())
    }

    @Test
    fun `Part 1`() {
        println("Part 1: ${Filestore(puzzleInput).totalOfAtMost100_000()}")
    }

    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}