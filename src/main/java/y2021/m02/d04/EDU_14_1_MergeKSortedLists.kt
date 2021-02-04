package y2021.m02.d04

import shared.ListNode
import java.util.*

class EDU_14_1_MergeKSortedLists {
    // O(n log k) time, O(k) space
    fun merge(lists: Array<ListNode>): ListNode {
        val minHeap = PriorityQueue<ListNode> { a,b -> a.`val` - b.`val` }

        for (node in lists) {
            minHeap.offer(node)
        }

        val head = minHeap.poll()
        minHeap.offer(head.next)
        head.next = null

        var tail = head
        while (minHeap.isNotEmpty()) {
            val next = minHeap.poll()
            tail.next = next
            if (next.next != null) minHeap.offer(next.next)
            next.next = null
            tail = next
        }

        return head
    }
}
