package y2020.m10.d12

object LC1TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val encountered = mutableMapOf<Int, Int>()
        nums.forEachIndexed { i, num ->
            val difference = target - num
            if (encountered.contains(difference)) {
                return intArrayOf(i, encountered[difference]!!)
            }
            encountered += num to i
        }
        throw IllegalArgumentException()
    }
}
