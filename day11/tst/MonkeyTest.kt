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
        assertEquals(listOf(79, 98), monkey.items)
        assertEquals(12, monkey.inspect(2))
        assertEquals(23, monkey.test)
        assertEquals(2, monkey.yesMonkey)
        assertEquals(3, monkey.noMonkey)
    }

    @Test
    fun `Test parsing monkey brain with plus`() {
        val monkey = Monkey("""  
  Starting items: 54, 65, 75, 74
  Operation: new = old + 6
  Test: divisible by 19
    If true: throw to monkey 2
    If false: throw to monkey 0
""".trimIndent())
        assertEquals(listOf(54, 65, 75, 74), monkey.items)
        assertEquals(3, monkey.inspect(3))
        assertEquals(5, monkey.inspect(10))
        assertEquals(19, monkey.test)
        assertEquals(2, monkey.yesMonkey)
        assertEquals(0, monkey.noMonkey)
    }

    @Test
    fun `Monkey 0 throws 500 and 620 to monkey 3`() {
        val monkey0 = Monkey("""  
  Starting items: 79, 98
  Operation: new = old * 19
  Test: divisible by 23
    If true: throw to monkey 2
    If false: throw to monkey 3
""".trimIndent())

        val thrownItems = monkey0.inspectItems()

        assertEquals(listOf(500 to 3, 620 to 3), thrownItems)
    }
}