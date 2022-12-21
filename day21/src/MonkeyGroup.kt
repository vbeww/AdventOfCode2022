class MonkeyGroup(group: String) {
    private val monkeys = group.split("\n").map { it.split(": ") }.map {
        it[0] to it[1]
    }.toMap()

    fun valueOf(name: String): Long {
        val monkey = monkeys[name]!!
        if (monkey.contains(Regex("[+*\\-/]"))) {
            val math = monkey.split(" ")
            return when (math[1]) {
                "+" -> valueOf(math[0]) + valueOf(math[2])
                "-" -> valueOf(math[0]) - valueOf(math[2])
                "/" -> valueOf(math[0]) / valueOf(math[2])
                else -> valueOf(math[0]) * valueOf(math[2])
            }
        }
        return monkey.toLong()
    }

    fun whatShouldIShout(): Long {
        val humanMonkeys = relatesToHuman()
        val rootMonkey = monkeys["root"]!!
        val equals = rootMonkey.split(" + ")
        val humanRelated = equals.first {  humanMonkeys.contains(it) }
        val shouldEqual = valueOf(equals.first { !humanMonkeys.contains(it) })

        return humanShout(humanMonkeys, humanRelated, shouldEqual)
    }

    private fun humanShout(humanMonkeys: List<String>, name:String, requiredValue: Long): Long {
        val monkeyMath = monkeys[name]!!.split(" ")
        val indexOfHumanMonkey = monkeyMath.indexOfFirst { humanMonkeys.contains(it) }
        val ohterMonkeyValue = valueOf (monkeyMath[if (indexOfHumanMonkey == 0) 2 else 0])
        val newRequiredValue = when (monkeyMath[1]) {
            "+" -> requiredValue - ohterMonkeyValue
            "*" -> requiredValue / ohterMonkeyValue
            "-" -> if (indexOfHumanMonkey == 0) requiredValue + ohterMonkeyValue else ohterMonkeyValue - requiredValue
            else -> if (indexOfHumanMonkey == 0) requiredValue * ohterMonkeyValue else ohterMonkeyValue / requiredValue
        }
        if (monkeyMath[indexOfHumanMonkey] == "humn") return newRequiredValue
        return humanShout(humanMonkeys, monkeyMath[indexOfHumanMonkey], newRequiredValue)
    }

    private fun relatesToHuman(): List<String> {
        val humanRelated = mutableListOf("humn")
        var current = "humn"
        while (current != "root") {
            current = monkeys.keys.first { monkeys[it]!!.contains(current) }
            humanRelated.add(current)
        }
        return humanRelated.toList()
    }

}
