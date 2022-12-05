class Instructions(input: String) {
    val instructions = input.split("\n").map {
        it.split(" ").let {instruction ->
            Instruction(instruction[1].toInt(), instruction[3].toInt(), instruction[5].toInt())
        }
    }
}
