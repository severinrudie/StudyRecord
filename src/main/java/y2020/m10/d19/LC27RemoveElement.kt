package y2020.m10.d19

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
