class KeepAwayGame(input: String, divideByThree: Boolean = true) {
    private val monkeys = input.split("\n\n").map {
        it.substring(it.indexOf("\n") + 1)
    }.map { Monkey(it, divideByThree) }

    private val maximumTest = monkeys.map { it.test }.fold(1) { acc, value -> acc * value }.toLong()

    fun playRounds(times: Int): Long {
        repeat(times) { round() }
        return monkeys.map { it.numberOfInspectedItems }.sortedDescending().take(2).let { it[0] * it[1] }
    }

    private fun round() {
        monkeys.forEach { monkey ->
            monkey.inspectItems(maximumTest).forEach { thrownItem ->
                monkeys[thrownItem.second].catch(thrownItem.first)
            }
        }
    }
}
