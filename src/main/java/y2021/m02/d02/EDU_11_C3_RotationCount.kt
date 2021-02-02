package y2021.m02.d02

import java.lang.RuntimeException

class EDU_11_C3_RotationCount {

    // O(log n) time, O(1) space
    // Note, fails in certain edge cases where duplicate numbers are allowed
    fun countRotations(arr: IntArray): Int {
        if (arr.size < 2) return 0
        if (arr[0] < arr.last()) return 0

        var left = 0
        var right = arr.lastIndex

        while (left <= right) {
            val mid = (right - left) / 2 + left

            if (arr[mid] > arr[left]) {
                left = mid + 1
            } else if (mid == 0 || arr[mid] < arr[mid - 1]) {
                return mid
            } else {
                right = mid - 1
            }
        }

        throw RuntimeException()
    }
}
