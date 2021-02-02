package y2021.m02.d02

import java.util.*

class EDU_13_4_ConnectRopes {

    // O(n log n) time, O(n) space
    fun minimumCostToConnectRopes(ropeLengths: IntArray): Int {
        val minHeap = PriorityQueue<Int>()

        for (len in ropeLengths) {
            minHeap.offer(len)
        }

        var result = 0
        var totalLen = minHeap.poll()
        while (minHeap.isNotEmpty()) {
            totalLen += minHeap.poll()
            result += totalLen
        }

        return result
    }
}
