package y2021.m02.d04

import java.util.*

class EDU_13_c3_FrequencyStack {
    val counts = mutableMapOf<Int, Int>()
    val maxHeap = PriorityQueue<Pair<Int, Int>> { a,b -> b.second - a.second }

    // to push n times, O(n log n) time, O(n) space
    fun push(num: Int) {
        val curr = counts[num] ?: 0
        counts[num] = curr + 1
        maxHeap.offer(num to curr + 1)
    }

    // to pop n times, O(n log n) time, O(n) space
    fun pop(): Int {
        val next = maxHeap.poll()
        counts[next.first] = counts[next.first] ?: 0 - 1
        return next.first
    }
}
