class Filestore(input: String) {
    val terminal = input.split("\n")

    fun totalOfAtMost100_000(): Long {
        return recursiveListing(0, "/").second
                .map { it.second }
                .filter { it <= 100_000L }
                .sum()
    }

    fun removeSmallestToMakeSpace(): Long {
        val folderSizes = recursiveListing(0, "/").second
        val diskSpaceToClean = folderSizes.last { it.first == "/" }.second - 40_000_000L
        folderSizes.forEach { println(it) }
        return folderSizes.map { it.second }.filter { it >= diskSpaceToClean }.min()!!
    }

    private fun recursiveListing(startPointer: Int, folder: String, level: String = ">"): Pair<Int, List<Pair<String, Long>>>{
        var pointer = startPointer + 1
        var totalFileSize = 0L
        var listOfFolders = mutableListOf<Pair<String, Long>>()
        var directSubFolders = mutableListOf<String>()
        do {
            pointer++
            if (pointer >= terminal.size) return pointer to (listOfFolders + (folder to totalFileSize))
            val line = terminal[pointer]
            if (line == "\$ cd ..") {
                val subfolderSize = listOfFolders + (folder to totalFileSize)
                println("$level $folder $totalFileSize")
                return pointer to (subfolderSize)
            }
            if (line.startsWith("\$ cd")) {
                val (newPointer, subFolders) = recursiveListing(pointer, line.split(" ")[2], "--$level")
                listOfFolders.addAll(subFolders)
                totalFileSize += subFolders.filter { directSubFolders.contains(it.first)  }.map { it.second }.sum()
                pointer = newPointer
                continue
            }
            if (line.startsWith(("dir"))) {
                directSubFolders.add(line.split(" ")[1])
                continue
            }
            println("$level $line")
            totalFileSize += line.split(" ").first().toLong()
        } while (true)
    }


}
