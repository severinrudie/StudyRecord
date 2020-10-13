package y2020.oct13th

import kotlin.math.abs

// TODO bad solution, rewrite
object LC6ZigZagConversion {
    fun zigZagConversion(s: String, numRows: Int): String {
        if (numRows > s.length) return s
        return (0 until numRows)
                .map { i -> getAllIndexesOnRow(s.length, numRows, i) }
                .flatten()
                .map { s[it] }
                .joinToString(separator = "")
    }

    fun getAllIndexesOnRow(stringLen: Int, numRows: Int, currRow: Int): List<Int> {
        val diagonalOffset = indexesToNextDiagonal(numRows, currRow)
        val columnOffset = indexesToNextColumn(numRows)

        val result = mutableListOf(currRow)
        while (true) {
            val nextDiagonal = diagonalOffset?.let { it + result.last() }
            val nextColumn = columnOffset + result.last()

            if (nextColumn == currRow) break

            if (nextDiagonal != null && nextDiagonal >= stringLen) break
            else if (nextDiagonal != null) result += nextDiagonal

            if (nextColumn >= stringLen) break
            else result += nextColumn
        }

        return result
    }

    fun indexesToNextDiagonal(numRows: Int, currRow: Int): Int? {
        val rowsAboveBottom = abs(currRow - (numRows - 1))

        // Top and bottom rows have no diagonals
        return if (rowsAboveBottom == 0 || rowsAboveBottom == (numRows - 1)) {
            null
        }
        else {
            rowsAboveBottom * 2
        }
    }

    fun indexesToNextColumn(numRows: Int): Int = if (numRows == 1) 1 else (numRows - 1) * 2
}