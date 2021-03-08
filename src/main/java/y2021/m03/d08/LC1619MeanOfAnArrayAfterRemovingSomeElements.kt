package y2021.m03.d08

class LC1619MeanOfAnArrayAfterRemovingSomeElements {
    // O(n logn) time, O(n) space [could be easily rewritten to use O(1) space
    fun trimMean(arr: IntArray): Double {
        return arr.sorted()
            .drop((arr.size * .05).toInt())
            .dropLast((arr.size * .05).toInt())
            .average()
    }
}