package y2021.m02.d04

import java.util.*

class EDU_14_2_KthSmallestNumberInMSortedLists {

    // O(k log m) time, O(m) space [where m == lists.size]
    fun findKthSmallest(lists: List<Array<Int>>, k: Int): Int {
        // num to list index
        val minHeap = PriorityQueue<Pair<Int, Int>> { a, b -> a.first - b.first }

        val indices = Array(lists.size) { 0 }
        for (i in lists.indices) {
            val arr = lists[i]
            if (arr.isNotEmpty()) {
                minHeap.offer(arr[0] to i)
            }
        }

        var smallest = 0
        for (i in 0 until k) {
            val next = minHeap.poll()
            smallest = next.first
            val index = next.second
            indices[index] = indices[index] + 1

            val toAdd = lists[index].getOrNull(indices[index])
            if (toAdd != null) minHeap.offer(toAdd to index)
        }
        return smallest
    }
}
