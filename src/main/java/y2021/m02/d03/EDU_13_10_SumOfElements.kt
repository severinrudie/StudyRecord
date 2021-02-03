package y2021.m02.d03

import java.util.*
import kotlin.Comparator

class EDU_13_10_SumOfElements {
    // O(n log k2) time, O(k) space
    fun findSumOfElements(nums: IntArray, k1: Int, k2: Int): Int {
        val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())

        // n log k2
        for (num in nums) {
            if (maxHeap.size < k2) {
                maxHeap.offer(num)
            } else if (maxHeap.peek() > num) {
                maxHeap.poll()
                maxHeap.offer(num)
            }
        }

        // (k2 - k1) log k2
        val num2 = maxHeap.poll()
        for (i in k1 + 1 until k2) maxHeap.poll()
        val num1 = maxHeap.poll()

        // n
        var sum = 0
        for (num in nums) {
            if (num in num1 + 1 until num2) sum += num
        }

        return sum
    }
}