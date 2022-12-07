class Filestore(input: String) {
    val terminal = input.split("\n")

    fun totalOfAtMost100_000(): Long {
        return recursiveListing(0, "/").second
                .map { it.second }
                .filter { it <= 100_000L }
                .sum()

    }

    private fun recursiveListing(startPointer: Int, folder: String): Pair<Int, List<Pair<String, Long>>>{
        var pointer = startPointer + 1
        var totalFileSize = 0L
        var listOfFolders = mutableListOf<Pair<String, Long>>()
        var directSubFolders = mutableListOf<String>()
        do {
            pointer++
            if (pointer >= terminal.size) return pointer to (listOfFolders + (folder to totalFileSize))
            val line = terminal[pointer]
            if (line == "\$ cd ..") return pointer to (listOfFolders + (folder to totalFileSize))
            if (line.startsWith("\$ cd")) {
                val (newPointer, subFolders) = recursiveListing(pointer, line.split(" ")[2])
                listOfFolders.addAll(subFolders)
                totalFileSize += subFolders.filter { directSubFolders.contains(it.first)  }.map { it.second }.sum()
                pointer = newPointer
                continue
            }
            if (line.startsWith(("dir"))) {
                directSubFolders.add(line.split(" ")[1])
                continue
            }
            totalFileSize += line.split(" ").first().toLong()
        } while (true)
    }


}
