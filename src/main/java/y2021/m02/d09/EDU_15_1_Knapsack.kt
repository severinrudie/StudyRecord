package y2021.m02.d09

import kotlin.math.max

class EDU_15_1_Knapsack {

    // Top down DP
    // O(n c) time, O(n c) space [where c is capacity]
    fun solveKnapsack(
        profits: IntArray,
        weights: IntArray,
        capacity: Int,
        currIndex: Int = 0,
        // [index][capacity] -> return value
        memoized: Array<IntArray> = Array(profits.size) { IntArray(capacity + 1) { -1 } }
    ): Int {
        if (currIndex > profits.lastIndex) return 0
        val mem = memoized[currIndex][capacity]
        if (mem != -1) return mem
        val currWeight = weights[currIndex]
        val currProfit = profits[currIndex]
        if (currWeight > capacity) return 0

        val with = currProfit + solveKnapsack(profits, weights, capacity - currWeight, currIndex + 1)
        val without = solveKnapsack(profits, weights, capacity, currIndex + 1)

        val solution = max(with, without)
        memoized[currIndex][capacity] = solution
        return solution
    }
}
