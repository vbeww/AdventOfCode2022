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
        assertEquals(listOf(79L, 98L), monkey.items)
        assertEquals(38, monkey.inspect(2))
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
        assertEquals(listOf(54L, 65L, 75L, 74L), monkey.items)
        assertEquals(15, monkey.inspect(9))
        assertEquals(17, monkey.inspect(11))
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

        val thrownItems = monkey0.inspectItems(0)

        assertEquals(listOf(500L to 3, 620L to 3), thrownItems)
    }

    @Test
    fun `Monkeys can catch items`() {
        val monkey = Monkey("""  
  Starting items: 79, 98
  Operation: new = old * 19
  Test: divisible by 23
    If true: throw to monkey 2
    If false: throw to monkey 3
""".trimIndent())
        monkey.catch(15)
        assertEquals(listOf(79L, 98L, 15L), monkey.items)
    }

    @Test
    fun `Monkeys count their inspected items`() {
        val monkey = Monkey("""  
  Starting items: 79, 98
  Operation: new = old * 19
  Test: divisible by 23
    If true: throw to monkey 2
    If false: throw to monkey 3
""".trimIndent())
        assertEquals(0, monkey.numberOfInspectedItems)
        monkey.inspectItems(0)
        assertEquals(2, monkey.numberOfInspectedItems)
    }


    @Test
    fun `Monkeys are correctly parsed`() {
        val keepAwayGame = KeepAwayGame(exampleInput)

        assertEquals(4, keepAwayGame.monkeys.size)

        val monkey0 = keepAwayGame.monkeys[0]
        assertEquals(listOf(79L, 98L), monkey0.items)
        assertEquals(38, monkey0.inspect(2))
        assertEquals(23, monkey0.test)
        assertEquals(2, monkey0.yesMonkey)
        assertEquals(3, monkey0.noMonkey)
    }

    @Test
    fun `After playing 20 rounds the most played multiplies to 10605`() {
        val result = KeepAwayGame(exampleInput).playRounds(20)
        assertEquals(10605, result)
    }

    @Test
    fun `Part 1`() {
        val result = KeepAwayGame(puzzleInput).playRounds(20)
        println("Part 1: $result")
    }

    @Test
    fun `After playing 10000 rounds the most played multiples to 2713310158`() {
        val result = KeepAwayGame(exampleInput, false).playRounds(10_000)
        assertEquals(2713310158, result)
    }

    @Test
    fun `Part 2`() {
        val result = KeepAwayGame(puzzleInput, false).playRounds(10_000)
        println("Part 2: $result")
    }

    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}