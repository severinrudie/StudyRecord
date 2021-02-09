package y2021.m02.d09

import kotlin.math.max

class EDU_15_1_Knapsack2 {

    // Bottom up DP
    // O(n c) time, O(c) space [where c is capacity]
    fun solveKnapsack(
        profits: IntArray,
        weights: IntArray,
        capacity: Int,
    ): Int {

        val dp = IntArray(capacity + 1)

        for (i in profits.indices) {
            val currProfit = profits[i]
            val currWeight = weights[i]
            for (currCap in 1..capacity) {
                if (currWeight > currCap) continue
                val with = currProfit + dp[currCap - currWeight]
                val without = dp[currCap]

                dp[currCap] = max(with, without)
            }
        }
        return dp[capacity]
    }
}
