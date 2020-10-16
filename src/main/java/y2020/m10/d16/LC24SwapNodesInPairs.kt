package y2020.m10.d16

import shared.ListNode

// Hard, 51%
// O(n) time, O(1) space
object LC24SwapNodesInPairs {
    tailrec fun swapPairs(
            head: ListNode?,
            prev: ListNode? = ListNode(0).apply { this.next = head }
    ): ListNode? {
        if (head == null) return null

        // [.., 0, 1, 2, 3]
        val one = prev?.next
        val two = one?.next
        val three = two?.next

        if (one == null || two == null) return head

        prev.next = two
        // 0 -> 2 -> 3
        // 1 ->
        two.next = one
        // 0 -> 2 -> 1   3
        //        <-
        one.next = three
        // 0 -> 2 -> 1 -> 3

        return if (head == one) {
            swapPairs(head = two, prev = one)
        } else {
            swapPairs(head = head, prev = one)
        }
    }
}