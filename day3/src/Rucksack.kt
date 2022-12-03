class Rucksack(contents:String){
    private val left = contents.substring(0 until contents.length/2)
    private val right = contents.substring((contents.length/2) until contents.length)
    val mistake = left.filter { right.contains(it) }.first()
}