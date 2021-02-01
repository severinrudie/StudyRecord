package y2021.m01.d29

class EDU_11_2_CeilingOfAKey {

    // O(log n) time, O(1) space
    fun searchCeilingOfANumber(arr: IntArray, key: Int): Int {
        var left = 0
        var right = arr.lastIndex
        var mid: Int

        while (left <= right) {
            mid = (right - left) / 2 + left
            val num = arr[mid]
            if (num >= key && (mid == 0 || arr[mid - 1] < key)) return mid

            if (num < key) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return -1
    }
}