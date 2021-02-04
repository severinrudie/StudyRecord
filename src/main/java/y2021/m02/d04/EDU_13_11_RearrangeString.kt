package y2021.m02.d04

import java.util.*

class EDU_13_11_RearrangeString {

    // O(n log n) time, O(n) space
    // Note, this counts 'P' and 'p' as different letters
    fun rearrangeString(str: String): String? {
        val counts = str.groupBy { it }.map { it.key to it.value.size }
        val maxHeap = PriorityQueue<Pair<Char, Int>> { a,b -> b.second - a.second }
        counts.forEach { maxHeap += it }

        var result = ""
        var prev: Pair<Char, Int>? = null
        while (maxHeap.isNotEmpty()) {
            val next = maxHeap.poll()
            if (prev != null && prev.second > 0) maxHeap += prev

            result += next.first
            prev = next.first to next.second - 1
        }

        return if (prev != null && prev.second > 0) null
        else result
    }

}
