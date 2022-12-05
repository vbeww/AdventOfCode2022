class Instructions(input: String) {
    val instructions = input.split("\n").map {
        Instruction("${it[5]}".toInt(), "${it[12]}".toInt(), "${it[17]}".toInt())
    }
}
