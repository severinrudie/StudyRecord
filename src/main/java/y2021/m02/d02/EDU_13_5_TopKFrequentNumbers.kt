package y2021.m02.d02

import java.util.*


class EDU_13_5_TopKFrequentNumbers {

    // O(n + n log n) time, O(n) space
    fun findTopKFrequentNumbers(nums: IntArray, k: Int): List<Int> {
        val counts = nums.groupBy { it }
            .map { entry -> entry.key to entry.value.size }

        val minHeap = PriorityQueue<Pair<Int, Int>>(Comparator.comparingInt { it.second })
        for (entry in counts) {
            if (minHeap.size < k) {
                minHeap.offer(entry)
            } else if (minHeap.peek().second < entry.second) {
                minHeap.poll()
                minHeap.offer(entry)
            }
        }

        return minHeap.map { it.first }
    }
}
