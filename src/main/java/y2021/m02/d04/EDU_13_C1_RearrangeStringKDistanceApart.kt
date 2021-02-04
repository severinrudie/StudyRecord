package y2021.m02.d04

import java.util.*

class EDU_13_C1_RearrangeStringKDistanceApart {

    // O(n log n) time, O(n) space
    fun reorganizeString(str: String, k: Int): String? {
        val counts = str.groupBy { it }.map { it.key to it.value.size }
        val maxQueue = PriorityQueue<Pair<Char, Int>> { a,b -> b.second - a.second }
        counts.forEach { maxQueue += it }

        var result = ""
        val used = LinkedList<Pair<Char, Int>>()
        while (maxQueue.isNotEmpty()) {
            val next = maxQueue.poll()
            result += next.first
            used.addFirst(next.first to next.second - 1)

            if (used.size == k -1) {
                val oldest = used.removeLast()
                if (oldest.second >= 1) maxQueue.offer(oldest)
            }
        }

        return if (used.any { it.second > 0 } ) null
        else result
    }
}
