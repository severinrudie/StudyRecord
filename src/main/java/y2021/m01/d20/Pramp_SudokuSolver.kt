package y2021.m01.d20

class Pramp_SudokuSolver {

    lateinit var rows: IntArray
    lateinit var cols: IntArray
    lateinit var squares: IntArray

    fun sudokuSolve(board: Array<CharArray>): Boolean {
        loadInitNumbers(board)
        return sudokuSolve(board, 0, 0)
    }

    fun loadInitNumbers(board: Array<CharArray>) {
        rows = IntArray(9)
        cols = IntArray(9)
        squares = IntArray(9)

        for (y in board.indices) {
            for (x in board.indices) {
                val c = board[y][x]
                if (c == '.') continue
                val num = Character.getNumericValue(c)
                addToBoard(num, x, y)
            }
        }
    }

    fun sudokuSolve(board: Array<CharArray>, x: Int, y: Int): Boolean {
        // if outside board, return true
        if (y > 8) return true
        val nextXY = when {
            x == 8 -> 0 to y + 1 // end of the row, move to the next
            else -> x + 1 to y
        }
        val c = board[y][x]
        // if the square already contains a number, move on
        if (c in '1'..'9') return sudokuSolve(board, nextXY.first, nextXY.second)

        for (num in 1..9) {
            if (!num.canFitIn(x, y)) continue

            addToBoard(num, x, y)

            if (sudokuSolve(board, nextXY.first, nextXY.second)) return true

            removeFromBoard(num, x, y)
        }
        return false
    }

    fun Int.canFitIn(x: Int, y: Int) = !rows[y].containsBit(this) &&
            !cols[x].containsBit(this) &&
            !squares[getSquare(x, y)].containsBit(this)

    fun addToBoard(num: Int, x: Int, y: Int) {
        rows[y] = rows[y].withBit(num)
        cols[x] = cols[x].withBit(num)
        val square = getSquare(x, y)
        squares[square] = squares[square].withBit(num)
    }

    fun removeFromBoard(num: Int, x: Int, y: Int) {
        rows[y] = rows[y].withoutBit(num)
        cols[x] = cols[x].withoutBit(num)
        val square = getSquare(x, y)
        squares[square] = squares[square].withoutBit(num)
    }

    fun Int.withBit(num: Int): Int = this or (1 shl num)

    fun Int.withoutBit(num: Int): Int = this and (1 shl num).inv()

    fun Int.containsBit(num: Int): Boolean = (this shr num) and 1 == 1

    fun getSquare(x: Int, y: Int): Int = (x / 3) + ((y / 3) * 3)
}
