package y2021.m02.d01

class EDU_11_7_BitronicArrayMaximum {

    // O(log n) time, O(1) space
    fun findMax(arr: IntArray): Int {
        if (arr.isEmpty()) return -1
        if (arr.size == 1) return arr.first()
        if (arr.last() > arr.dropLast(1).last()) return arr.last()
        if (arr.first() > arr.drop(1).first()) return arr.first()

        var left = 0
        var right = arr.lastIndex
        var mid: Int
        while (left <= right) {
            mid = (right - left) / 2 + left
            val pre = arr[mid - 1]
            val num = arr[mid]
            val post = arr[mid + 1]

            if (num > pre && num > post) {
                return num
            }
            if (num > pre) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return arr[left]
    }
}
