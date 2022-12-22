import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MazeTest {
    @Test
    fun exampleMaze() {
        val maze = Maze(exampleInput)
        val password = maze.walk("1")
        assertEquals(36, password)
    }


    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val exampleMaze = exampleInput.split("\n\n")[0]
    private val exampleInstructions = exampleInput.split("\n\n")[1]
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
    private val puzzleMaze = puzzleInput.split("\n\n")[0]
    private val puzzleInstructions = puzzleInput.split("\n\n")[1]
}