import org.junit.jupiter.api.Test
import java.io.File
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

    @Test
    fun part1() {

    }

    private val exampleCalories = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}