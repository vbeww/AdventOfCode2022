class Group(firstRucksack: Rucksack, secondRucksack: Rucksack, thirdRucksack: Rucksack) {
    private val badge = firstRucksack.findPossibleBadge(secondRucksack, thirdRucksack)
    val badgePriority = if (badge <= 'Z') badge - 'A' + 27 else badge - 'a' + 1
}
