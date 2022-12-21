import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HumanMathTest {
    @Test
    fun simplePlusRight() {
        val group = MonkeyGroup("""
            root: pppw + sjmn
            pppw: 6
            sjmn: abcd + humn
            humn: 4
            abcd: 5
        """.trimIndent())
        assertEquals(1L, group.whatShouldIShout())
    }

    @Test
    fun simplePlusLeft() {
        val group = MonkeyGroup("""
            root: pppw + sjmn
            pppw: 6
            sjmn: humn + abcd
            humn: 4
            abcd: 5
        """.trimIndent())
        assertEquals(1L, group.whatShouldIShout())
    }

    @Test
    fun simpleTimesRight() {
        val group = MonkeyGroup("""
            root: pppw + sjmn
            pppw: 6
            sjmn: abcd * humn
            humn: 4
            abcd: 3
        """.trimIndent())
        assertEquals(2L, group.whatShouldIShout())
    }

    @Test
    fun simpleTimesLeft() {
        val group = MonkeyGroup("""
            root: pppw + sjmn
            pppw: 6
            sjmn: humn * abcd
            humn: 4
            abcd: 1
        """.trimIndent())
        assertEquals(6L, group.whatShouldIShout())
    }
}