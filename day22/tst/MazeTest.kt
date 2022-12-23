import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MazeTest {
    @Test
    fun exampleMaze() {
        val maze = Maze(exampleMaze)
        val password = maze.walk("1")
        assertEquals(1040, password)
    }

    @Test
    fun walkIntoTheWall() {
        val maze = Maze(exampleMaze)
        val password = maze.walk("10")
        assertEquals(1044, password)
    }

    @Test
    fun stepForwardTurnToFaceDownwards() {
        val maze = Maze(exampleMaze)
        val password = maze.walk("1R")
        assertEquals(1041, password)
    }

    @Test
    fun stepForwardTurnToFaceUpwards() {
        val maze = Maze(exampleMaze)
        val password = maze.walk("1L")
        assertEquals(1043, password)
    }

    @Test
    fun forwardRightForward() {
        val maze = Maze(exampleMaze)
        val password = maze.walk("2R1")
        assertEquals(2045, password)
    }

    @Test
    fun shortWalkWithinBounds() {
        val maze = Maze(exampleMaze)
        val password = maze.walk("2R4R5L3R2")
        assertEquals(8018, password)
    }

    @Test
    fun shortWalkOutOfBounds() {
        val maze = Maze(exampleMaze)
        val password = maze.walk("1L1L2L1L1")
        assertEquals(9036, password)
    }

    @Test
    fun exampleWalk() {
        val maze = Maze(exampleMaze)
        val password = maze.walk(exampleInstructions)
        assertEquals(6032, password)
    }

    @Test
    fun part1() {
        val maze = Maze(puzzleMaze)
        val password = maze.walk(puzzleInstructions)
        println("Part 1: $password")
    }

    private val exampleInput = javaClass.getResource("/example.txt").readText()
    private val exampleMaze = exampleInput.split("\n\n")[0]
    private val exampleInstructions = exampleInput.split("\n\n")[1]
    private val puzzleInput = javaClass.getResource("/input.txt").readText()
    private val puzzleMaze = puzzleInput.split("\n\n")[0]
    private val puzzleInstructions = puzzleInput.split("\n\n")[1]
}