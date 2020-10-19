package y2020.m10.d19

object LC26RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var removed = 0
        var last = nums.first()
        for (i in 1..nums.lastIndex) {
            if (nums[i] == last) {
                removed++
            }
            last = nums[i]
            swap(nums, i, i - removed)
        }
        return nums.size - removed
    }

    fun swap(nums: IntArray, i1: Int, i2: Int) {
        if (i1 == i2) return
        val temp = nums[i1]
        nums[i1] = nums[i2]
        nums[i2] = temp
    }
}