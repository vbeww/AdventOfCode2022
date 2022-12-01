import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CalorieCounterTest {
    @Test
    fun `elves have total of calories`() {
        val caloriesList = """
1000
2000
3000
        """.trimIndent()
        val elf = Elf(caloriesList)

        assertEquals(6000, elf.totalCalories())

    }
}