package y2021.m02.d03

import java.util.*

// O(n log k) time, O(k) space
internal class EDU_13_7_KthLargestNumberInAStream(nums: IntArray, private val k: Int) {

    private val minHeap = PriorityQueue<Int>()

    init {
        for (num in nums) add(num)
    }

    // O(log k) time, O(k space) [more for init]
    fun add(num: Int): Int {
        if (minHeap.size < k) {
            minHeap.offer(num)
        } else if (minHeap.peek() < num) {
            minHeap.poll()
            minHeap.offer(num)
        }
        return minHeap.peek()
    }
}