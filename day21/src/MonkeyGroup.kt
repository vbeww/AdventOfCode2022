class MonkeyGroup(group: String) {
    private val monkeys = group.split("\n").map { it.split(": ") }.map {
        it[0] to it[1]
    }.toMap()

    fun valueOf(name: String): Long {
        val monkey = monkeys[name]!!
        if (monkey.contains(Regex("[+*]"))) {
            val math = monkey.split(" ")
            return when (math[1]) {
                "+" -> valueOf(math[0]) + valueOf(math[2])
                else -> valueOf(math[0]) * valueOf(math[2])
            }
        }
        return monkey.toLong()
    }

}
