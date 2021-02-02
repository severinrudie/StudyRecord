package y2021.m02.d02

import java.util.*

class EDU_13_2_KthSmallestNumber {
    // O(n log k) time, O(k) space
    fun findKthSmallestNumber(nums: IntArray, k: Int): Int {
        val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())

        for (num in nums) {
            println(" ")
            if (maxHeap.size < k) maxHeap.offer(num)
            else if (maxHeap.peek() > num) {
                maxHeap.poll()
                maxHeap.offer(num)
            }
        }
        return maxHeap.peek()
    }
}
