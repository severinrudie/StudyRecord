package y2020.oct12th

object LC4MedianOfTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val combined = mergeSorted(nums1, nums2)
        return findMedian(combined)
    }

    fun mergeSorted(a1: IntArray, a2: IntArray): IntArray {
        if (a1.isEmpty()) return a2
        if (a2.isEmpty()) return a1

        val totalSize = a1.size + a2.size
        val result = IntArray(totalSize)

        var index1 = 0
        var index2 = 0

        for (i in 0 until totalSize) {
            val next = when {
                index1 > a1.lastIndex -> a2[index2].also { index2++ }
                index2 > a2.lastIndex -> a1[index1].also { index1++ }
                a1[index1] <= a2[index2] -> a1[index1].also { index1++ }
                else -> a2[index2].also { index2++ }
            }
            result[i] = next
        }
        return result
    }

    fun findMedian(arr: IntArray): Double {
        return if (arr.size % 2 == 0) {
            val lower = (arr.size - 1) / 2
            (arr[lower] + arr[lower+1]).toDouble() / 2
        } else {
            arr[arr.size / 2].toDouble()
        }
    }
}