package y2021.m03.d03

import kotlin.math.max

class LC904FruitIntoBasket {
    // O(n) time, O(1) space
    fun totalFruit(tree: IntArray): Int {
        if (tree.size < 2) return tree.size

        val counts = mutableMapOf<Int, Int>()
        var longest = 0

        var l = 0
        var r = 0

        while (r < tree.size) {
            if (counts.size <= 2) {
                val num = tree[r]
                counts[num] = (counts[num] ?: 0) + 1
                r++
            } else {
                val num = tree[l]
                counts[num] = counts[num]!! - 1
                if (counts[num] == 0) counts.remove(num)
                l++
            }
            if (counts.size <= 2) {
                longest = max(longest, r - l)
            }
        }
        return longest
    }
}
