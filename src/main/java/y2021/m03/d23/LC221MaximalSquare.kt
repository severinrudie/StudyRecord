package y2021.m03.d23

import kotlin.math.*

class LC221MaximalSquare {
    // O(hw) time, O(w) space
    fun maximalSquare(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty() || matrix.first().isEmpty()) return 0
        val lastRow = IntArray(matrix.first().size) { 0 }

        var best = 0
        var upLeft = 0

        for (rowI in matrix.indices) {
            val row = matrix[rowI]
            for (colI in row.indices) {
                val tile = matrix[rowI][colI]
                val temp = lastRow[colI]
                lastRow[colI] = if (tile == '0') {
                    0
                } else if (rowI == 0 || colI == 0) {
                    1
                } else {
                    val up = lastRow[colI]
                    val left = lastRow[colI - 1]

                    min(up, min(left, upLeft)) + 1
                }
                upLeft = temp
                best = max(best, lastRow[colI] * lastRow[colI])
            }
        }
        return best
    }
}
