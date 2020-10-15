package y2020.m10.d13

// O(n) time
// O(n) space
object L4MedianOfTwoSortedArraysTry2 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var i1 = 0
        var i2 = 0
        val merged = mutableListOf<Int>()

        while (i1 < nums1.size || i2 < nums2.size) {
            val one = nums1.getOrNull(i1) ?: Int.MAX_VALUE
            val two = nums2.getOrNull(i2) ?: Int.MAX_VALUE

            if (one < two) {
                i1++
                merged += one
            } else {
                i2++
                merged += two
            }
        }

        val size = merged.size
        return if (size % 2 == 1) {
            merged[size / 2].toDouble()
        } else {
            (merged[size / 2].toDouble() + merged[(size / 2) - 1].toDouble()) / 2
        }
    }
}