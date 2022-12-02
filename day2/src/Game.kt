class Game(exampleCalories: String) {
    val totalScoreNewRules = exampleCalories.split("\n").map { RoundNewRule(it).score }.sum()
    val totalScore = exampleCalories.split("\n").map { Round(it).score }.sum()
}
