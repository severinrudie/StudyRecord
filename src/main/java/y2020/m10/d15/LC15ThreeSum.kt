package y2020.m10.d15

// Medium, 27%
// O(n log n + n^2) time, O(n) space
object LC15ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        val result = mutableListOf<List<Int>>()

        for (i in nums.indices) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var j = i + 1
            var k = nums.lastIndex

            while (i < j && j < k) {
                val total = nums[i] + nums[j] + nums[k]

                if (j - 1 > i && nums[j] == nums[j - 1]) {
                    j++
                    continue
                }
                if (k < nums.lastIndex && nums[k] == nums[k + 1]) {
                    k--
                    continue
                }

                if (total == 0) result += listOf(nums[i], nums[j], nums[k])
                if (total < 0) j++
                else k--
            }
        }
        return result
    }
}
