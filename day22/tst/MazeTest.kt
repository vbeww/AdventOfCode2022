import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MazeTest {
    @Test
    fun exampleMaze() {
        val maze = Maze(exampleMaze)
        val password = maze.walk("1")
        assertEquals(36, password)
    }

    @Test
    fun walkIntoTheWall() {
        val maze = Maze(exampleMaze)
        val password = maze.walk("10")
        assertEquals(40, password)
    }

    @Test
    fun stepForwardTurnToFaceDownwards() {
        val maze = Maze(exampleMaze)
        val password = maze.walk("1R")
        assertEquals(37, password)
    }

    @Test
    fun stepForwardTurnToFaceUpwards() {
        val maze = Maze(exampleMaze)
        val password = maze.walk("1L")
        assertEquals(39, password)
    }

    @Test
    fun forwardRightForward() {
        val maze = Maze(exampleMaze)
        val password = maze.walk("2R1")
        assertEquals(1041, password)
    }

    @Test
    fun shortWalkWithinBounds() {
        val maze = Maze(exampleMaze)
        val password = maze.walk("2R4R5L3R2")
        assertEquals(7014, password)
    }


    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val exampleMaze = exampleInput.split("\n\n")[0]
    private val exampleInstructions = exampleInput.split("\n\n")[1]
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
    private val puzzleMaze = puzzleInput.split("\n\n")[0]
    private val puzzleInstructions = puzzleInput.split("\n\n")[1]
}