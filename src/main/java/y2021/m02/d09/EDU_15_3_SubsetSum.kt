package y2021.m02.d09

class EDU_15_3_SubsetSum {
    // O(n s) time, O(s) space
    fun canPartition(nums: IntArray, sum: Int): Boolean {
        val dp = BooleanArray(sum + 1) { false }
        dp[0] = true

        for (num in nums) {
            for (i in sum downTo 1) {
                val lower = i - num
                if (lower < 0) continue
                if (dp[lower]) dp[i] = true
            }
        }
        return dp[sum]
    }

}