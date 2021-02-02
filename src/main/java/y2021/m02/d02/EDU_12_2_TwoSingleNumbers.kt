package y2021.m02.d02

class EDU_12_2_TwoSingleNumbers {

    // O(n) time, O(1) space
    // Bit shifting is crazy...
    fun findSingleNumbers(nums: IntArray): Pair<Int, Int> {

        var mask = 0
        for (num in nums) {
            mask = mask xor num
        }

        var rightmostDifferentBit = 1
        while (rightmostDifferentBit and mask == 0) {
            rightmostDifferentBit = rightmostDifferentBit shl 1
        }

        var num1 = 0
        var num2 = 0
        for (num in nums) {
            if (num and rightmostDifferentBit > 0) {
                num1 = num1 xor num
            } else {
                num2 = num2 xor num
            }
        }

        return num1 to num2
    }
}