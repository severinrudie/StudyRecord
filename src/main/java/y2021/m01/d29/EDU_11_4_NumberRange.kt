package y2021.m01.d29

class EDU_11_4_NumberRange {

    // O(log n) time, O(n) space
    fun findRange(arr: List<Int>, key: Int): List<Int> {
        var left = 0
        var right = arr.lastIndex
        var mid: Int
        var foundNum = false

        while (left <= right) {
            mid = (right - left) / 2 + left
            val num = arr[mid]
            if (num == key) foundNum = true

            if (num >= key) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        val rangeLeft = left

        right = arr.lastIndex
        while (left <= right) {
            mid = (right - left) / 2 + left
            val num = arr[mid]

            if (num <= key) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        val rangeRight = right

        return if (!foundNum) listOf(-1, -1)
        else listOf(rangeLeft, rangeRight)
    }
}
