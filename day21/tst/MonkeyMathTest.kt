import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MonkeyMathTest {
    @Test
    fun directValue() {
        assertEquals(4L, MonkeyGroup("""root: 4""").valueOf("root"))
    }

    @Test
    fun simpleSum() {
        val group = MonkeyGroup("""
            root: pppw + sjmn
            pppw: 6
            sjmn: 7
        """.trimIndent())
        assertEquals(13L, group.valueOf("root"))
    }

    @Test
    fun simpleMultiple() {
        val group = MonkeyGroup("""
            root: pppw * sjmn
            pppw: 4
            sjmn: 9
        """.trimIndent())
        assertEquals(36L, group.valueOf("root"))
    }

    @Test
    fun simpleMinus() {
        val group = MonkeyGroup("""
            root: pppw - sjmn
            pppw: 22
            sjmn: 2
        """.trimIndent())
        assertEquals(20L, group.valueOf("root"))
    }

    @Test
    fun simpleDivide() {
        val group = MonkeyGroup("""
            root: pppw / sjmn
            pppw: 8
            sjmn: 4
        """.trimIndent())
        assertEquals(2L, group.valueOf("root"))
    }

    @Test
    fun example() {
        val group = MonkeyGroup(exampleInput)
        assertEquals(152L, group.valueOf("root"))
    }

    @Test
    fun part1() {
        val group = MonkeyGroup(puzzleInput)
        println("Part 1: " +  group.valueOf("root"))
    }


    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}