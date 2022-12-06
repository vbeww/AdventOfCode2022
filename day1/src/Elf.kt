class Elf(caloriesList: String) {
    val totalCalories= caloriesList.split("\n").sumBy { it.toInt()}
}
