package y2020.m10.d19

// Easy, 48%
// O(n) time, O(1) space
object LC27RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var removed = 0
        for (i in nums.indices) {
            if (removed > 0) nums[i - removed] = nums[i]
            if (nums[i] == `val`) removed++
        }

        return nums.size - removed
    }
}
