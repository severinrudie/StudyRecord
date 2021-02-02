package y2021.m02.d02

import java.util.*


class EDU_13_1_KLargestNumbers {

    // O(n log k) time, O(k) space
    fun findKLargestNumbers(nums: IntArray, k: Int): List<Int> {
        val minHeap = PriorityQueue<Int>()

        for (num in nums) {
            if (minHeap.size < k) {
                minHeap.offer(num)
            } else if (minHeap.peek() < num) {
                minHeap.poll()
                minHeap.offer(num)
            }
        }

        return minHeap.toList()
    }
}
