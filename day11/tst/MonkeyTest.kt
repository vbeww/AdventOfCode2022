import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MonkeyTest {
    @Test
    fun `Test parsing monkey brain with times`() {
        val monkey = Monkey("""  
  Starting items: 79, 98
  Operation: new = old * 19
  Test: divisible by 23
    If true: throw to monkey 2
    If false: throw to monkey 3
""".trimIndent())
        assertEquals(listOf(79, 98), monkey.startingItems)
        assertEquals(38, monkey.operation(2))
        assertEquals(23, monkey.test)
        assertEquals(2, monkey.yesMonkey)
        assertEquals(3, monkey.noMonkey)
    }


    fun `Test parsing monkey brain with plus`() {
        val monkey = Monkey("""  
  Starting items: 54, 65, 75, 74
  Operation: new = old + 6
  Test: divisible by 19
    If true: throw to monkey 2
    If false: throw to monkey 0
""".trimIndent())
        assertEquals(listOf(54, 65, 75, 74), monkey.startingItems)
        assertEquals(9, monkey.operation(3))
        assertEquals(19, monkey.test)
        assertEquals(2, monkey.yesMonkey)
        assertEquals(0, monkey.noMonkey)
    }
}