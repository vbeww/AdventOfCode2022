class Rucksack(private val contents:String){
    private val left = contents.substring(0 until contents.length/2)
    private val right = contents.substring((contents.length/2) until contents.length)
    val mistake = left.first { right.contains(it) }
    fun findPossibleBadge(secondRucksack: Rucksack, thirdRucksack: Rucksack) =
            contents.filter { secondRucksack.contents.contains(it) }.first { thirdRucksack.contents.contains(it) }
}