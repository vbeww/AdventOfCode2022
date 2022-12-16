class SignalPairs(exampleInput: String) {
    private val pairs = exampleInput.split("\n\n")
            .map { signal ->
                signal.split("\n")
                        .map { Packet(it) }.let { it[0] to it[1] }
            }

    fun findCorrectOrderIndicesSum() =
            pairs.indices.filter { pairs[it].first < pairs[it].second }
                    .map { it + 1 }
                    .sum()

}
