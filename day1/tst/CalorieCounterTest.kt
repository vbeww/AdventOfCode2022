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
}