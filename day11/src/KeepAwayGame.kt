class KeepAwayGame(input: String) {
    val monkeys = input.split("\n\n").map {
        it.substring(it.indexOf("\n") + 1)
    }.map { Monkey(it) }

    fun playRounds(times: Int): Int {
        repeat(times) {
            monkeys.forEach { monkey ->
                monkey.inspectItems().forEach { thrownItem ->
                    monkeys[thrownItem.second].catch(thrownItem.first)
                }
            }
        }
        return monkeys.map { it.numberOfInspectedItems }.sortedDescending().take(2).let { it[0] * it[1] }
    }


}
