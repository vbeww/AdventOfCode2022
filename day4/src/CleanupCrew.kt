class CleanupCrew(input: String) {
    private val pairs = input.split("\n").map { elfPair ->
        elfPair.split(",").let { Elf(it[0]) to Elf(it[1]) }
    }

    fun numberOfOverlappingPairs() = pairs.count {
        it.first.containsSections(it.second) || it.second.containsSections(it.first)
    }

    fun numberOfPartlyOverlappingPairs() = pairs.count {
        it.first.containsStartSection(it.second) || it.second.containsStartSection(it.first)
    }
}