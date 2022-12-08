class Forest(input: String) {
    private val allTheTrees = input.split("\n").map { it.map { tree -> Tree("$tree".toInt()) } }

    fun numberOfVisibleTrees(): Int {
        allTheTrees.forEach { row ->
            markVisibleTrees(row)
            markVisibleTrees(row.reversed())

        }
        allTheTrees.rotate90().forEach { row ->
            markVisibleTrees(row)
            markVisibleTrees(row.reversed())

        }
        return allTheTrees.flatten().filter { tree -> tree.visible }.count()
    }

    private fun markVisibleTrees(trees: List<Tree>) {
        var highestTree = -1
        trees.forEach { tree ->
            if (tree.height > highestTree) {
                highestTree = tree.height
                tree.visible = true
            }
        }
    }
}

private fun <E> List<List<E>>.rotate90(): List<List<E>> {
    val rotatedList = mutableListOf(mutableListOf<E>())
    (this[0].indices).forEach { colomIndex ->
        val row = mutableListOf<E>()
        (this.indices).forEach {rowIndex ->
            row.add(this[rowIndex][colomIndex])
        }
        rotatedList.add(row)
    }
    return rotatedList
}
