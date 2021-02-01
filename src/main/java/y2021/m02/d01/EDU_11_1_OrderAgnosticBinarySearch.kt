package y2021.m02.d01

class EDU_11_1_OrderAgnosticBinarySearch {

    // O(log n) time, O(1) space
    fun search(arr: IntArray, key: Int): Int {
        var left = 0
        var right = arr.lastIndex
        var mid: Int
        val ascending = arr[left] < arr[right]

        while (left <= right) {
            mid = ((right - left) / 2) + left
            val num = arr[mid]
            if (num == key) return mid

            val tooSmall = num < key

            if (ascending == tooSmall) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return -1
    }
}
