package y2020.m10.d15

import java.util.*

// Medium, 36%
// O(n) time, O(n + m) space
object LC6ZigZagConversionTry2 {
    fun convert(s: String, numRows: Int): String {
        val matrix = List(numRows) { LinkedList<Char>() }

        var down = true
        var row = 0
        for (c in s) {
            matrix[row] += c
            when (row) {
                0 -> down = true
                numRows -1 -> down = false
                else -> { /* noop */ }
            }
            if (down && row < numRows - 1) row++
            else if (!down && row > 0) row--
        }

        return matrix.joinToString(separator = "") { it.joinToString(separator = "") }
    }
}