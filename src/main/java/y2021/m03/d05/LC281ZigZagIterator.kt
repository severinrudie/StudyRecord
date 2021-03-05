package y2021.m03.d05

// O(1) time, O(n) space
class LC281ZigZagIterator(private val vecs: Array<IntArray>) {
    constructor(v1: IntArray, v2: IntArray) : this(arrayOf(v1, v2))

    var col = 0
    var row = 0
    val longest = vecs.map { it.size }.maxOrNull()!!

    // O(a) time, O(1) space [where a is the number of arrays]
    fun hasNext(): Boolean {
        while (col < longest) {
            if (col < vecs[row].size) {
                return true
            } else {
                iterate()
            }
        }
        return false
    }

    // O(1) time, O(1) space
    fun next(): Int {
        val next = vecs[row][col]
        iterate()
        return next
    }

    // O(1) time, O(1) space
    private fun iterate() {
        if (row == vecs.lastIndex) {
            row = 0
            col++
        } else {
            row++
        }
    }
}
