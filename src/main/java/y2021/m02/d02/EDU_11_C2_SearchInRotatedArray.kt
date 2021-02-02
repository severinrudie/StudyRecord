package y2021.m02.d02

import java.lang.RuntimeException

class EDU_11_C2_SearchInRotatedArray {

    // O(log n) time, O(1) space
    fun search(arr: IntArray, key: Int): Int {
        fun Int.adjusted() = if (this >= 0) {
            this % arr.size
        } else {
            arr.size + this
        }

        var left = findStart(arr)
        var right = (left + arr.lastIndex).adjusted()

        while (left != right) {
            val mid = if (left < right) {
                (right - left) / 2 + left
            } else {
                ((arr.lastIndex - left + right) / 2 + left).adjusted()
            }

            if (arr[mid] < key) {
                left = (mid + 1).adjusted()
            } else {
                right = (mid - 1).adjusted()
            }
        }
        return left
    }

    fun findStart(arr: IntArray): Int {
        if (arr.size < 2) return arr.lastIndex - 1

        var left = 0
        var right = arr.lastIndex

        while (left <= right) {
            val mid = (right - left) / 2 + left

            if (mid == 0 || arr[mid] < arr[mid - 1]) return mid
            if (arr[right] < arr[mid]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        throw RuntimeException()
    }
}
