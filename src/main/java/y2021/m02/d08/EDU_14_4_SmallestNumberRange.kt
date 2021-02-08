package y2021.m02.d08

import java.util.*

class EDU_14_4_SmallestNumberRange {
    data class Wrapper(val valIndex: Int, val listIndex: Int)

    // O(n log k) time, O(k) space [where k is lists.size]
    fun findSmallestRange(lists: List<IntArray>): IntArray {
        val minHeap = PriorityQueue<Wrapper> { a,b -> lists[a.listIndex][a.valIndex] - lists[b.listIndex][b.valIndex] }
        fun Wrapper.num() = lists[this.listIndex][this.valIndex]

        var maxSeen = Int.MIN_VALUE
        var smallestRange = Int.MAX_VALUE
        var resultL = 0
        var resultR = 0

        for (i in lists.indices) {
            val list = lists[i]
            if (list.isNotEmpty()) {
                val wrapper = Wrapper(0, i)
                minHeap.offer(wrapper)
                maxSeen = Math.max(maxSeen, wrapper.num())
            }
        }

        while (minHeap.size == lists.size) {
            val lowest = minHeap.poll()
            val currRange = maxSeen - lowest.num()
            if (currRange < smallestRange) {
                smallestRange = currRange
                resultL = lowest.num()
                resultR = maxSeen
            }

            if (lists[lowest.listIndex].lastIndex >= lowest.valIndex + 1) {
                val next = Wrapper(lowest.valIndex + 1, lowest.listIndex)
                minHeap.offer(next)
                maxSeen = Math.max(maxSeen, next.num())

            }
        }
        return intArrayOf(resultL, resultR)
    }
}
