package y2021.m02.d09

class EDU_15_4_MinimumSubsetDifference {

    // O(n s) time, O(s) space [where s == sum of nums]
    fun canPartition(nums: IntArray): Int {
        val sum = nums.sum()
        val isEven = sum %2 == 0
        val half: Int = sum / 2

        val dp = BooleanArray(half + 1) { false }
        dp[0] = true

        for (num in nums) {
            for (i in half downTo 1) {
                val lower = i - num
                if (lower < 0) continue
                if (dp[lower]) dp[i] = true
            }
        }

        for (i in half downTo 0) {
            if (dp[i] == false) continue
            return (half - i) * 2 + if (isEven) 0 else 1
        }
        return sum
    }
}