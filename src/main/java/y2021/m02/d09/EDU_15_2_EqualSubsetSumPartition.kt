package y2021.m02.d09

class EDU_15_2_EqualSubsetSumPartition {
    // O(n s) time, O(s) space [where s == sum of nums]
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 != 0) return false
        val half = sum / 2

        val dp = BooleanArray(half + 1) { false }
        dp[0] = true

        for (num in nums) {
            for (i in half downTo 1) {
                val prev = i - num
                if (prev < 0) continue
                if (dp[prev]) dp[i] = true
            }
        }
        return dp[half]
    }
}
