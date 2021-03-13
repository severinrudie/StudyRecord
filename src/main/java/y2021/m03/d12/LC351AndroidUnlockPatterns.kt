package y2021.m03.d12

import kotlin.math.*

class LC351AndroidUnlockPatterns {

    // Done during a rush during a mock interview. Does not pass all cases
    class Solution {
        var np = 0
        fun numberOfPatterns(m: Int, n: Int, currPath: MutableList<Int> = mutableListOf()): Int {
            if (currPath.size >= n) return 0

            var count = 0
            for (i in 1..9) {
                currPath += i
                if (isValid(currPath)) {
                    println(currPath)
                    if (currPath.size >= m) count++
                    count += numberOfPatterns(m, n, currPath)
                }
                currPath -= i
            }
            return count
        }

        fun isValid(path: List<Int>): Boolean {
            val seen = mutableSetOf<Int>()
            var last = path[0]

            for (num in path) {
                seen += num
                if (seen.size < 2) continue
                if (betweenNums(num, last).any { !seen.contains(it) }) return false
                last = num
            }
            if (path.size != seen.size) return false
            return true
        }

        fun betweenNums(a: Int, b: Int): Set<Int> {
            val (aRow, aCol) = getRowCol(a)
            val (bRow, bCol) = getRowCol(b)
            val big = max(a, b)
            val small = min(a, b)

            val extra = if (aRow == bRow) {
                setOf(getNum(aRow, 1))
            } else if (aCol == bCol) {
                setOf(getNum(1, aCol))
            } else if (big == 9 && small == 1 || big == 7 && small == 3) {
                setOf(5)
            } else if (abs(aCol - bCol) + abs(aRow - bRow) < 3) {
                emptySet()
            } else if (abs(aRow - bRow) > 1) {
                // knight jump
                emptySet()
            } else {
                // knight jump
                emptySet()
            }

            return setOf(a, b) + extra
        }

        fun getRowCol(num: Int): Pair<Int, Int> = (num - 1) / 3 to (num - 1) % 3

        fun getNum(row: Int, col: Int): Int = row * 3 + col + 1
    }
}