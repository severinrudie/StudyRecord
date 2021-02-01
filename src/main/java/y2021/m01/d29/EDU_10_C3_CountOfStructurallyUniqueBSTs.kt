package y2021.m01.d29

import java.util.HashMap
import kotlin.math.max

class EDU_10_C3_CountOfStructurallyUniqueBSTs {
    fun countTrees(n: Int): Int {
        val memoizer: MutableMap<String, Int> = HashMap()
        return countTrees(1, n, memoizer)
    }

    // O(2^n) time, O(2^n) space
    // [EDU says space is O(n) for the memoization map... but shouldn't it be O(2^n) for the call stack?]
    fun countTrees(start: Int, end: Int, memoizer: MutableMap<String, Int>): Int {
        val key = "$start:$end"
        memoizer[key]?.let { return it }
        if (start > end) return 0
        if (start == end) return 1

        var total = 0
        for (i in start..end) {
            val left = max(countTrees(start, i - 1, memoizer), 1)
            val right = max(countTrees(i + 1, end, memoizer), 1)
            total += left * right
        }
        memoizer[key] = total
        return total
    }
}