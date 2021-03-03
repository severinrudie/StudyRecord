package y2021.m03.d03

import kotlin.math.min

class LC1007MinimumDominoRotationsForEqualRow {
    // O(n) time, O(1) space
    fun minDominoRotations(A: IntArray, B: IntArray): Int {
        var fewest = Int.MAX_VALUE
        var anyValid = false

        for (num in 1..6) {
            var aGaps = 0
            var bGaps = 0
            var valid = true

            for (i in A.indices) {
                if (A[i] != num && B[i] != num) {
                    valid = false
                    break
                }
                if (A[i] != num) aGaps++
                if (B[i] != num) bGaps++
            }
            if (valid) fewest = min(fewest, min(aGaps, bGaps))
        }

        return if (fewest == Int.MAX_VALUE) -1 else fewest
    }
}
