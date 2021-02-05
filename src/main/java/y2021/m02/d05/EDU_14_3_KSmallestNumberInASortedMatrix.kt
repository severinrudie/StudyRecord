package y2021.m02.d05

import java.util.*

class EDU_14_3_KSmallestNumberInASortedMatrix {

    data class Position(val row: Int, val col: Int)

    // Uses the "treat the matrix as k sorted lists" approach

    // Where s is the smaller of height and width
    // O(k log s) time, O(k) space
    fun findKthSmallest(matrix: Array<IntArray>, k: Int): Int {
        if (matrix.isEmpty() || matrix[0].isEmpty() || k > matrix.size * matrix[0].size) return -1
        val vertical = matrix.size > matrix[0].size

        // num to row/col
        val minHeap = PriorityQueue<Pair<Int, Position>> { a, b -> a.first - b.first }

        if (vertical) {
            for (i in matrix[0].indices) {
                minHeap.offer(matrix[0][i] to Position(row = 0, col = i))
            }
        } else {
            for (i in matrix.indices) {
                minHeap.offer(matrix[i][0] to Position(row = i, col = 0))
            }
        }

        for (i in 1..k) {
            val (smallest, pos) = minHeap.poll()

            val nextPos = if (vertical) {
                pos.copy(row = pos.row + 1)
            } else {
                pos.copy(col = pos.col + 1)
            }
            val nextNum = matrix.getOrNull(nextPos.row)?.getOrNull(nextPos.col)

            if (nextNum != null) minHeap.add(nextNum to nextPos)

            if (i == k) return smallest
        }
        throw RuntimeException() // TODO better exception
    }
}
