class Monkey(monkeyBrain: String, private val divideByThree: Boolean = true) {
    var numberOfInspectedItems = 0L
    var items = monkeyBrain.info(0, "Starting items: ")
            .split(",").map { it.trim().toLong() }

    val inspect = monkeyBrain.info(1, "Operation: new = old ").split(" ")
            .let { instruction ->
                { old: Long ->
                    val rightSide = if (instruction[1] == "old") old else instruction[1].toLong()
                    when (instruction[0]) {
                        "+" -> old + rightSide
                        else -> old * rightSide
                    }
                }
            }
    val test = monkeyBrain.info(2, "Test: divisible by ").toInt()
    val yesMonkey = monkeyBrain.info(3, "If true: throw to monkey ").toInt()
    val noMonkey = monkeyBrain.info(4, "If false: throw to monkey ").toInt()

    fun inspectItems(maximumTest: Long): List<Pair<Long, Int>> {
        val thrown = items
                .map { inspect(it) }
                .map { if (divideByThree) it / 3 else it % maximumTest }
                .map { it to if (it % test == 0L) yesMonkey else noMonkey }
        numberOfInspectedItems += thrown.size
        items = emptyList()
        return thrown
    }

    fun catch(item: Long) {
        items = items + item
    }
}

private fun String.info(line: Int, prefix: String) = this.split("\n")[line].trim().removePrefix(prefix)



