package y2020.m10.d15

// Medium, 46%
// O(n log n + n^2) time, O(1) space
object LC16ThreeSumClosest {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()

        var minDistance = Int.MAX_VALUE
        var bestSum = 0

        for (i in nums.indices) {
            var j = i + 1
            var k = nums.lastIndex

            loop@while (i < j && j < k) {
                val total = nums[i] + nums[j] + nums[k]
                val distance = distance(total, target)

                if (distance < minDistance) {
                    minDistance = distance
                    bestSum = total
                }

                when {
                    distance == 0 -> break@loop
                    total < target -> j++
                    else -> k--
                }
            }
        }

        return bestSum
    }

    fun distance(first: Int, second: Int): Int {
        val bigger = Math.max(first, second)
        val smaller = Math.min(first, second)
        return Math.abs(bigger - smaller)
    }
}