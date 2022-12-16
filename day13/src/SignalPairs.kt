class SignalPairs(exampleInput: String) {
    private val pairs = exampleInput.split("\n\n")
            .map { signal ->
                signal.split("\n")
                        .map { Packet(it) }.let { it[0] to it[1] }
            }

    private val dividerTwo = Packet("[[2]]")
    private val dividerSix = Packet("[[6]]")

    private val allPacketsWithDividers = pairs.map { listOf(it.first, it.second) }.flatten() +
             dividerTwo + dividerSix

    fun findCorrectOrderIndicesSum() =
            pairs.indices.filter { pairs[it].first < pairs[it].second }
                    .map { it + 1 }
                    .sum()

    fun findDividerPositions(): Int {
        val sorted = allPacketsWithDividers.sorted()
        return (sorted.indexOf(dividerTwo) + 1) * (sorted.indexOf(dividerSix) + 1)
    }


}
