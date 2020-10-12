package oct12th

object TwoSum {
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
