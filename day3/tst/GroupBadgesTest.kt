import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GroupBadgesTest {
    @Test
    fun `find badges in three rucksacks`() {
        val firstRucksack = Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp")
        val secondRucksack = Rucksack("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL")
        val thirdRucksack = Rucksack("PmmdzqPrVvPwwTWBwg")
        assertEquals('r', firstRucksack.findPossibleBadge(secondRucksack, thirdRucksack))
    }

    @Test
    fun `find badges of a group`() {
        assertEquals(30, Group(Rucksack("abaD"), Rucksack("Dffg"), Rucksack("xyDy")).badgePriority)
        assertEquals(34, Group(Rucksack("abHa"), Rucksack("fHfg"), Rucksack("xyHy")).badgePriority)
    }

    private val exampleCalories = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}