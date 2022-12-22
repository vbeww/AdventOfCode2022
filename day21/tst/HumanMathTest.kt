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

    @Test
    fun simpleMinusTestRight() {
        val group = MonkeyGroup("""
            root: pppw + sjmn
            pppw: 6
            sjmn: abcd - humn
            humn: 4
            abcd: 13
        """.trimIndent())
        assertEquals(7L, group.whatShouldIShout())
    }

    @Test
    fun simpleMinusTestLeft() {
        val group = MonkeyGroup("""
            root: pppw + sjmn
            pppw: 6
            sjmn: humn - abcd
            humn: 4
            abcd: 1
        """.trimIndent())
        assertEquals(7L, group.whatShouldIShout())
    }

    @Test
    fun simpleDivideTestRight() {
        val group = MonkeyGroup("""
            root: pppw + sjmn
            pppw: 6
            sjmn: abcd / humn
            humn: 4
            abcd: 18
        """.trimIndent())
        assertEquals(3L, group.whatShouldIShout())
    }

    @Test
    fun simpleDivideTestLeft() {
        val group = MonkeyGroup("""
            root: pppw + sjmn
            pppw: 6
            sjmn: humn / abcd
            humn: 4
            abcd: 9
        """.trimIndent())
        assertEquals(54L, group.whatShouldIShout())
    }

    @Test
    fun example() {
        val group = MonkeyGroup(exampleInput)
        assertEquals(301L, group.whatShouldIShout())
    }

    @Test
    fun part2() {
        val group = MonkeyGroup(puzzleInput)
        println("Part 2: " +  group.whatShouldIShout())
    }

    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}