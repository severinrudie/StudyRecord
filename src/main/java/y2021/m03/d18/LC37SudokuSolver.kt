package y2021.m03.d18

class LC37SudokuSolver {
    class Solution {
        // Redid this one as practice
        fun solveSudoku(board: Array<CharArray>): Unit {
            val rows = IntArray(9) { 0 }
            val cols = IntArray(9) { 0 }
            val subs = IntArray(9) { 0 }

            for (row in board.indices) {
                for (col in board[0].indices) {
                    val c = board[row][col]
                    if (c == '.') continue
                    val num = c - '0'

                    val sub = getSub(row, col)
                    rows[row] = rows[row].with(num)
                    cols[col] = cols[col].with(num)
                    subs[sub] = subs[sub].with(num)
                }
            }

            recurse(board, rows, cols, subs, 0, 0)
        }

        fun recurse(
            board: Array<CharArray>,
            rows: IntArray,
            cols: IntArray,
            subs: IntArray,
            row: Int,
            col: Int
        ): Boolean {
            if (col > board[0].lastIndex) {
                return if (row == board.lastIndex) true
                else recurse(board, rows, cols, subs, row + 1, 0)
            }
            // if filled, do nothing
            if (board[row][col] != '.') return recurse(board, rows, cols, subs, row, col + 1)

            for (i in 1..9) {
                val sub = getSub(row, col)
                val invalidPlacement = rows[row].contains(i) ||
                        cols[col].contains(i) ||
                        subs[sub].contains(i)
                if (invalidPlacement) continue

                rows[row] = rows[row].with(i)
                cols[col] = cols[col].with(i)
                subs[sub] = subs[sub].with(i)
                board[row][col] = '0' + i

                if (recurse(board, rows, cols, subs, row, col + 1)) return true

                rows[row] = rows[row].without(i)
                cols[col] = cols[col].without(i)
                subs[sub] = subs[sub].without(i)
                board[row][col] = '.'
            }
            return false
        }

        fun getSub(row: Int, col: Int): Int {
            return (row / 3) * 3 + (col / 3)
        }

        fun Int.with(other: Int): Int {
            return this or (1 shl other)
        }

        fun Int.without(other: Int): Int {
            return this xor (1 shl other)
        }

        fun Int.contains(other: Int): Boolean {
            return (this shr other) and 1 == 1
        }
    }
}
