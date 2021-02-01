package y2021.m02.d01

class EDU_11_5_SearchInASortedInfiniteArray {
    class ArrayReader(private var arr: IntArray) {
        operator fun get(index: Int): Int {
            return if (index >= arr.size) Int.MAX_VALUE else arr[index]
        }
    }

    // O(log n) time, O(1) space
    fun search(reader: ArrayReader, key: Int): Int {
        var left = 0
        var right = 1
        while (reader[right] != Int.MAX_VALUE) {
            right *= 2
        }
        var mid: Int
        while (left <= right) {
            mid = (right - left) / 2 + left
            val num = reader[mid]

            when {
                num == key -> return mid
                num < key -> left = mid + 1
                else -> right = mid - 1
            }
        }

        return -1
    }
}
