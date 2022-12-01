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

        assertEquals(6000, Elf(caloriesListFirstElf).totalCalories)
        assertEquals(63071, Elf(caloriesListSecondtElf).totalCalories)
    }

    @Test
    fun `calorie counter has multiple elves`() {
        assertEquals(5, CalorieCounter(exampleCalories).numberOfElves())
    }

    @Test
    fun `calorie counter provides the elf with the highest number of calories`() {
        assertEquals(24000, CalorieCounter(exampleCalories).highestAmountOfCalories())
    }

    @Test
    fun `calorie counter provides the sum of calories of the top 3 elves`() {
        assertEquals(45000, CalorieCounter(exampleCalories).sumOfTopThree())
    }

    @Test
    fun part1() {
        println(CalorieCounter(puzzleInput).highestAmountOfCalories())
    }

    @Test
    fun part2() {
        println(CalorieCounter(puzzleInput).sumOfTopThree())
    }

    private val exampleCalories = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}