import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CalorieCounterTest {
    @Test
    fun `elves have total of calories`() {
        val caloriesListFirstElf = """
1000
2000
3000
        """.trimIndent()
        val caloriesListSecondtElf = """
35747
27324
        """.trimIndent()

        val firstElf = Elf(caloriesListFirstElf)
        assertEquals(6000, firstElf.totalCalories)

        val secondElf = Elf(caloriesListSecondtElf)
        assertEquals(63071, secondElf.totalCalories)
    }

    @Test
    fun `calorie counter has multiple elves`() {

        val calorieCounter = CalorieCounter(exampleCalories)

        assertEquals(5, calorieCounter.numberOfElves())
    }

    @Test
    fun `calorie counter provides the elf with the highest number of calories`() {

        val calorieCounter = CalorieCounter(exampleCalories)

        assertEquals(24000, calorieCounter.highestAmountOfCalories())
    }

    private val exampleCalories = """
1000
2000
3000

4000

5000
6000

7000
8000
9000

10000
        """.trimIndent()
}