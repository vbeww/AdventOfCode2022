class Monkey(monkeyBrain: String) {
    var items = monkeyBrain.info(0, "Starting items: ")
            .split(",").map { it.trim().toInt() }

    val inspect = monkeyBrain.info(1, "Operation: new = old ").split(" ")
            .let { instruction ->
                { old: Int ->
                    val rightSide = if (instruction[1] == "old") old else instruction[1].toInt()
                    when (instruction[0]) {
                        "+" -> old + rightSide
                        else -> old * rightSide
                    } / 3
                }
            }
    val test = monkeyBrain.info(2, "Test: divisible by ").toInt()
    val yesMonkey = monkeyBrain.info(3, "If true: throw to monkey ").toInt()
    val noMonkey = monkeyBrain.info(4, "If false: throw to monkey ").toInt()

    fun inspectItems(): List<Pair<Int, Int>> {
        val thrown = items.map { worryLevel -> inspect(worryLevel) }.map { worryLevel ->
            worryLevel to if (worryLevel % test == 0) yesMonkey else noMonkey
        }
        items = emptyList()
        return thrown
    }
}

private fun String.info(line: Int, prefix: String) = this.split("\n")[line].trim().removePrefix(prefix)



