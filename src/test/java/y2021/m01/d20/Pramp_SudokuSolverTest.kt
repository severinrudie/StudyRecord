package y2021.m01.d20

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Pramp_SudokuSolverTest {

    val s = Pramp_SudokuSolver()

    @Test
    fun `get square`() = with(s) {
        assertEquals(0, getSquare(0, 0))
        assertEquals(0, getSquare(2, 2))
        assertEquals(1, getSquare(3, 2))
        assertEquals(3, getSquare(2, 3))
        assertEquals(8, getSquare(8, 8))
    }

    @Test
    fun `bit encoding`() = with(s) {
        assertTrue(0.withBit(1).containsBit(1))
        assertTrue(0.withBit(2).containsBit(2))
        assertTrue(1.withBit(2).containsBit(2))
        assertTrue(2.withBit(2).containsBit(2))
        assertTrue(3.withBit(2).containsBit(2))
        assertTrue(4.withBit(2).containsBit(2))

        val multiNum = 0.withBit(1)
            .withBit(3)
            .withBit(4)
            .withBit(6)
            .withBit(7)
            .withBit(9)

        listOf(
            1 to true,
            2 to false,
            3 to true,
            4 to true,
            5 to false,
            6 to true,
            7 to true,
            8 to false,
            9 to true
        ).forEach { assertTrue { multiNum.containsBit(it.first) == it.second } }

        var num = 0.withBit(5).withBit(8).withoutBit(8)
        assertTrue(num.containsBit(5))
        assertFalse(num.containsBit(8))

        num = 0.withBit(1)
            .withBit(2)
            .withBit(3)
            .withBit(4)
            .withBit(5)
            .withoutBit(4)

        assertTrue(num.containsBit(1))
        assertTrue(num.containsBit(2))
        assertTrue(num.containsBit(3))
        assertFalse(num.containsBit(4))
        assertTrue(num.containsBit(5))
    }

    @Test
    fun `load init nums`() = with(s) {
        val input = arrayOf(
            arrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            arrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            arrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            arrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            arrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            arrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            arrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            arrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            arrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )

        val solver = Pramp_SudokuSolver()
        solver.loadInitNumbers(input)

        with(solver.cols[0]) {
            listOf(5,6,8,4,7).forEach { assertTrue(this.containsBit(it)) }
            listOf(1,2,3,9).forEach { assertFalse(this.containsBit(it)) }
        }

        with(solver.rows[3]) {
            listOf(8,6,3).forEach { assertTrue(this.containsBit(it)) }
            listOf(1,2,4,5,7,9).forEach { assertFalse(this.containsBit(it)) }
        }

        with(solver.squares[3]) {
            listOf(8,4,7).forEach { assertTrue(this.containsBit(it)) }
            listOf(1,2,3,5,6,9).forEach { assertFalse(this.containsBit(it)) }
        }
    }

    @Test
    fun tc1() {
        val solver = Pramp_SudokuSolver()
        val input = arrayOf(
            arrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            arrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            arrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            arrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            arrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            arrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            arrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            arrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            arrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )

        assertTrue(solver.sudokuSolve(input))
    }

    @Test
    fun tc2() {
        val solver = Pramp_SudokuSolver()

        // 6/6 (x/y) should be unsolvable
        val input = arrayOf(
            arrayOf('5', '1', '6', '8', '4', '9', '7', '3', '2'),
            arrayOf('3', '.', '7', '6', '.', '5', '.', '.', '.'),
            arrayOf('8', '.', '9', '7', '.', '.', '.', '6', '5'),
            arrayOf('1', '3', '5', '.', '6', '.', '9', '.', '7'),
            arrayOf('4', '7', '2', '5', '9', '1', '.', '.', '6'),
            arrayOf('9', '6', '8', '3', '7', '.', '.', '5', '.'),
            arrayOf('2', '5', '3', '1', '8', '6', '.', '7', '4'),
            arrayOf('6', '8', '4', '2', '.', '7', '5', '.', '.'),
            arrayOf('7', '9', '1', '.', '5', '.', '6', '.', '8')
        )

        assertFalse(solver.sudokuSolve(input))
    }
}
