class Game(exampleCalories: String) {
    val totalScore = exampleCalories.split("\n").map { Round(it).score }.sum()
}
