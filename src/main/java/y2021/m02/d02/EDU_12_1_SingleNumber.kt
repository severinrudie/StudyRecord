package y2021.m02.d02

class EDU_12_1_SingleNumber {

    // O(n) time, O(1) space
    fun findSingleNumber(arr: IntArray): Int {
        var mask = 0
        for (num in arr) {
            mask = mask xor num
        }
        return mask
    }
}
