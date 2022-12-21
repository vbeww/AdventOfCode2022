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
}