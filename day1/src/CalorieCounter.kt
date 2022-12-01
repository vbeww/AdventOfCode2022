class CalorieCounter(input: String) {
    private val elves = input.split("\n\n").map { Elf(it) }
    fun numberOfElves() = elves.size
    fun highestAmountOfCalories() = elves.map { it.totalCalories }.max() ?: 0
}