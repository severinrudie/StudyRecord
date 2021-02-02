package y2021.m02.d02

class EDU_11_C1_SearchBitronicArray {

    // O(log n) time, O(1) space
    fun search(arr: IntArray, key: Int): Int {
        val midpoint = findMidpoint(arr)
        val leftTarget = search(arr, 0, midpoint, key, true)
        if (leftTarget != null) return leftTarget
        val rightTarget = search(arr, midpoint, arr.lastIndex, key, false)
        return rightTarget!!
    }

    private fun findMidpoint(arr: IntArray): Int {
        if (arr.size < 2) return arr.size - 1

        var left = 0
        var right = arr.lastIndex

        while (left <= right) {
            val mid = (right - left) / 2 + left
            val num = arr[mid]

            if (mid == arr.lastIndex || mid == 0) return mid
            if (num > arr[mid - 1] && num > arr[mid + 1]) return mid
            if (num < arr[mid - 1]) right = mid - 1
            else left = mid + 1
        }
        return left
    }

    private fun search(arr: IntArray, l: Int, r: Int, target: Int, ascending: Boolean): Int? {
        var left = l
        var right = r
        var mid: Int

        while (left <= right) {
            mid = (right - left) / 2 + left
            val num = arr[mid]

            if (num == target) return mid
            if (num < target == ascending) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return null
    }
}
