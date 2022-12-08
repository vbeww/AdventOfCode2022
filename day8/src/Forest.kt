class Forest(input: String) {
    private val forest = input.split("\n").map { it.map { tree -> Tree("$tree".toInt()) } }
    private val rotatedForest = forest.rotate90()

    fun numberOfVisibleTrees(): Int {
        forest.forEach { row ->
            markVisibleTrees(row)
            markVisibleTrees(row.reversed())

        }
        rotatedForest.forEach { row ->
            markVisibleTrees(row)
            markVisibleTrees(row.reversed())

        }
        return forest.flatten().filter { tree -> tree.visible }.count()
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

    fun highestScenicScore(): Int {
        var highest = 0
        (1..forest.size - 2).forEach { row ->
            (1..rotatedForest.size - 2).forEach { column ->
                val treeHeight = forest[row][column].height
                val left = forest[row].subList(0, column).reversed()
                val right = forest[row].subList(column + 1, rotatedForest.size)
                val up = rotatedForest[column].subList(0, row).reversed()
                val down = rotatedForest[column].subList(row + 1, forest.size)
                val scenicScore = score(treeHeight, left) * score(treeHeight, right) * score(treeHeight, up) * score(treeHeight, down)
                if (highest < scenicScore) highest = scenicScore
            }
        }
        return highest
    }

    private fun score(treeHeight: Int, trees: List<Tree>): Int {
        val index = trees.indexOfFirst { it.height >= treeHeight }
        return if (index == -1) trees.size else index + 1
    }
}

private fun <E> List<List<E>>.rotate90(): List<List<E>> {
    val rotatedList = mutableListOf<List<E>>()
    this[0].indices.forEach { columnIndex ->
        val row = mutableListOf<E>()
        this.indices.forEach { rowIndex ->
            row.add(this[rowIndex][columnIndex])
        }
        rotatedList.add(row)
    }
    return rotatedList
}
