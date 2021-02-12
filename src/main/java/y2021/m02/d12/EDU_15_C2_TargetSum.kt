package y2021.m02.d12

class EDU_15_C2_TargetSum {
    // O(n s) time, O(s) space [where s is sum of nums]
    fun findTargetSubsets(nums: IntArray, target: Int): Int {
        val sum = nums.sum()
        var prev = IntArray(sum * 2 + 1) { 0 }
        var curr = IntArray(sum * 2 + 1) { 0 }
        curr[sum] = 1

        for (num in nums) {
            prev = curr
            curr = IntArray(sum * 2 + 1) { 0 }

            for (i in prev.indices) {
                if (prev[i] == 0) continue
                curr[i + num] += prev[i]
                curr[i - num] += prev[i]
            }
        }
        return curr[target + sum]
    }
}
