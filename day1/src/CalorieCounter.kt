class CalorieCounter(input: String) {
    private val elfCalories = input.split("\n\n").map { Elf(it).totalCalories }
    fun numberOfElves() = elfCalories.size
    fun highestAmountOfCalories() = elfCalories.max() ?: 0
    fun sumOfTopThree() = elfCalories.sortedDescending().take(3).sum()
}