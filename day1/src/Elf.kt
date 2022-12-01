class Elf(caloriesList: String) {
    private val calories = caloriesList.split("\n").map { it.toLong()}
    fun totalCalories(): Long {
        return calories.sum()
    }

}
