class Expedition(input: String) {
    private val ruckSacks = input.split("\n").map { Rucksack(it) }
    private val groups = (0 until ruckSacks.size step 3).map { index ->
        Group(ruckSacks[index], ruckSacks[index + 1], ruckSacks[index + 2])
    }
    val totalMistakePriority = ruckSacks.sumBy { it.priorityOfMistake }
    val totalBadgePriority = groups.sumBy { it.badgePriority }
}
