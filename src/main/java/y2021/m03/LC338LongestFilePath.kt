package y2021.m03

import kotlin.math.max

class LC338LongestFilePath {
    // O(n) time, O(n) space
    fun lengthLongestPath(input: String): Int {
        val items = input.split("\n")
        val currLens = IntArray(items.size) { 0 }
        var maxLen = 0

        for (item in items) {
            val tabCount = item.lastIndexOf("\t") + 1
            val prevLen = if (tabCount == 0) 0 else currLens[tabCount - 1]
            val currLen = item.length + prevLen - tabCount
            currLens[tabCount] = currLen

            if (item.contains('.')) maxLen = max(currLen + tabCount, maxLen)
        }

        return maxLen
    }
}
