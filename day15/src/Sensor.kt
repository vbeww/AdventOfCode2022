import kotlin.math.abs

class Sensor(private val position: Pair<Int, Int>, val detectedBeacon: Pair<Int, Int>) {
    private val distance = abs(position.first - detectedBeacon.first) + abs(position.second - detectedBeacon.second)

    fun positionsAt(yPos: Int, min: Int, max: Int): IntRange {
        val verticalDistance = maxOf(position.second, yPos) - minOf(position.second, yPos)
        if (verticalDistance > distance) return -1..-1
        val from = position.first - (distance - verticalDistance)
        val to = position.first + (distance - verticalDistance)
        return maxOf(minOf(from, to), min)..minOf(maxOf(from, to), max)
    }

    fun suggestNewSpot(possibleSpot: Pair<Int, Int>, size: Int): Pair<Int, Int> {
        val positionsAtYPos = positionsAt(possibleSpot.second, 0, size)
        return when {
            !positionsAtYPos.contains(possibleSpot.first) -> possibleSpot
            positionsAtYPos.last == size -> 0 to possibleSpot.second + 1
            else -> positionsAtYPos.last + 1 to possibleSpot.second
        }
    }
}
