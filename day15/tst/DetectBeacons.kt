import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DetectBeacons {

    @Test
    fun `example 2 free spot`() {
        val map = SensorMap(exampleInput)
        assertEquals(56_000_011L, map.freeSpotInArea(20))
    }

    @Test
    fun `Part 2`() {
        val map = SensorMap(puzzleInput)
        println("Part 2: " +  map.freeSpotInArea(4_000_000))
    }

    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
}