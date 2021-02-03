package y2021.m02.d03

import java.util.*

class EDU_13_8_KClosestNumbers2 { // more efficient approach

    // O(log n + k) time, O(1) space
    fun findClosestElements(arr: IntArray, outputSize: Int, target: Int): List<Int> {

        val closestIndex = findClosestNum(arr, target)

        var left = closestIndex
        var right = closestIndex

        while (right - left + 1 < outputSize) {
            if (right == arr.lastIndex) {
                left--
                continue
            } else if (left == 0) {
                right++
                continue
            }
            val rDiff = arr[right + 1] - target
            val lDiff = target - arr[left - 1]

            if (rDiff > lDiff) {
                left--
            } else {
                right++
            }
        }

        val result = mutableListOf<Int>()
        for (i in left..right) {
            result += arr[i]
        }

        return result
    }

    fun findClosestNum(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.lastIndex
        var mid: Int
        while (left <= right) {
            mid = (right - left) / 2 + left

            if (arr[mid] == target || left == right) return mid
            if (arr[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return left
    }
}
