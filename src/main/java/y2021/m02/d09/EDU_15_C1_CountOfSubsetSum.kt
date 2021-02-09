package y2021.m02.d09

class EDU_15_C1_CountOfSubsetSum {

    // O(n s) time, O(s) space
    fun countSubsets(nums: IntArray, sum: Int): Int {
        val dp = IntArray(sum + 1) { 0 }
        dp[0] = 1

        for (num in nums) {
            for (i in sum downTo 1) {
                val diff = i - num
                if (diff < 0) continue
                dp[i] = dp[i] + dp[diff]
            }
        }
        return dp[sum]
    }
}
