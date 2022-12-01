class Elf(caloriesList: String) {
    val totalCalories= caloriesList.split("\n").map { it.toLong()}.sum()
}
