package y2020.m10.d19

import shared.ListNode

// Hard, 43%
// O(2n) time, O(k) space (stack)
object LC25ReverseNodesInKGroup {
    fun reverseKGroup(head: ListNode?, groupSize: Int): ListNode? {
        val dummyNode = ListNode(-1).apply { next = head }
        var prev = dummyNode

        while (canReverse(prev, groupSize)) {
            prev = reverse(prev, groupSize)
        }

        return dummyNode.next
    }

    fun canReverse(prev: ListNode, groupSize: Int): Boolean {
        var curr: ListNode? = prev.next
        for (i in 0 until groupSize) {
            if (curr == null) return false
            curr = curr.next
        }
        return true
    }

    /**
     * @returns the new tail
     */
    fun reverse(prev: ListNode, groupSize: Int): ListNode {
        val head = prev.next!!
        val (tail, followingNode) = recurse(head, groupSize)

        head.next = followingNode
        prev.next = tail

        return head
    }

    /**
     * @returns the `new tail` to `the following node`
     */
    fun recurse(curr: ListNode, remaining: Int): Pair<ListNode, ListNode?> {
        val next = curr.next
        if (remaining == 1) {
            return curr to next
        }

        val tail = recurse(curr.next!!, remaining - 1)
        next!!.next = curr
        return tail
    }
}
