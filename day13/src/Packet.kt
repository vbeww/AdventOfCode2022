class Packet(packet: String) : Comparable<Packet> {
    private val contents = mutableListOf<Any>()


    init {
        var i = 1
        while (i < packet.length - 1) {
            if (packet[i] == '[') {
                val (newIndex, subPacket) = readSubPacket(packet, i)
                i = newIndex
                contents.add(subPacket)
                continue
            }
            if (packet[i] != ',') {
                val (newIndex, value) = readNumber(packet, i)
                i = newIndex
                contents.add(value)
                continue
            }
            i++
            continue
        }
    }

    private fun readSubPacket(packet: String, i: Int): Pair<Int, Packet> {
        var i1 = i
        var nextPacket = ""
        var openBrackets = 0
        while (openBrackets != 0) {
            val char = packet[i1]
            nextPacket += char
            if (char == '[') openBrackets++
            if (char == ']') openBrackets--
            i1++
        }
        return i1 to Packet(nextPacket)
    }

    private fun readNumber(packet: String, i: Int): Pair<Int, Int> {
        var i1 = i
        var numberString = ""
        while (packet[i1] != ',' && packet[i1] != ']') {
            numberString += packet[i1]
            i1++
        }
        return i1 to numberString.toInt()
    }

    override operator fun compareTo(other: Packet): Int {
        if (contents.indices.any { i ->
                    if (other.contents.size < i) return@any false
                    val a = contents[i]
                    val b = other.contents[i]
                    if (a is Int && b is Int) return@any a < b
                    false
                }) {
            return -1
        }

        return 1
    }
}