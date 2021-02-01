package y2021.m02.d01

import kotlin.math.min

class EDU_11_6_MinimumDifferenceElement {

    fun searchMinDiffElement(arr: List<Int>, key: Int): Int {
        when {
            arr.isEmpty() -> return -1
            arr[0] > key -> return arr[0]
            arr.last() < key -> return arr.last()
        }

        var left = 0
        var right = arr.lastIndex
        var mid: Int

        var smallestTooBigIndex = Int.MAX_VALUE

        while (left <= right) {
            mid = (right - left) / 2 + left
            val num = arr[mid]

            if (num == key) return num
            if (num > key) {
                right = mid - 1
                smallestTooBigIndex = min(smallestTooBigIndex, mid)
            } else {
                left = mid + 1
            }
        }

        return arr[smallestTooBigIndex - 1]
    }
}
