package y2021.m01.d29

import java.lang.IllegalArgumentException

class EDU_11_3_NextLetter {
    // O(log n) time, O(1) space
    fun searchNextLetter(letters: CharArray, key: Char): Char {
        var left = 0
        var right = letters.lastIndex
        var mid: Int

        while (left <= right) {
            mid = (right - left) / 2 + left
            val c = letters[mid]
            if (mid == letters.lastIndex) return letters[0]
            if (c == key) return letters[mid + 1]
            if (c > key && (mid == 0 || letters[mid - 1] < key)) return letters[mid]

            if (c < key) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        throw IllegalArgumentException()
    }
}
