class Expedition(input: String) {

    private val ruckSacks = input.split("\n").map { Rucksack(it) }
    private val groupsBadges = (0 until ruckSacks.size step 3).map { index ->
        ruckSacks[index].findPossibleBadge(ruckSacks[index + 1], ruckSacks[index + 2])
    }
    val totalMistakePriority = ruckSacks.sumBy { it.mistake.priority }
    val totalBadgePriority = groupsBadges.sumBy { it.priority }
}

private val Char.priority: Int
    get() = if (this <= 'Z') this - 'A' + 27 else this - 'a' + 1
