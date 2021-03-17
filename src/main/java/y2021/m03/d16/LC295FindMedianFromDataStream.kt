package y2021.m03.d16

import java.util.*

class LC295FindMedianFromDataStream {
    // O(n) space
    class MedianFinder() {

        // min heap
        val topHalf = PriorityQueue<Int>()
        // max heap
        val bottomHalf = PriorityQueue<Int> { a,b -> b - a }

        // O(log n)
        fun addNum(num: Int) {
            topHalf.offer(num)
            while (
                bottomHalf.size > 0 &&
                topHalf.size > 0 &&
                bottomHalf.peek() > topHalf.peek()
            ) {
                topHalf.offer(bottomHalf.poll())
            }
            while (topHalf.size > bottomHalf.size + 1) {
                bottomHalf.offer(topHalf.poll())
            }
        }

        // O(1)
        fun findMedian(): Double {
            return if (topHalf.size == bottomHalf.size) {
                topHalf.peek().toDouble() / 2 + bottomHalf.peek().toDouble() / 2
            } else {
                topHalf.peek().toDouble()
            }
        }
    }
}