package y2020.m10.d16

import shared.ListNode

object LC19RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return null

        var fast = head
        var slow = head

        for (i in 1..n) {
            fast = fast!!.next
        }

        while (fast?.next != null) {
            fast = fast!!.next
            slow = slow!!.next
        }

        return if (fast == null && slow == head) {
            // Remove first node
            head.next
        } else {
            slow!!.next = slow!!.next!!.next
            head
        }
    }
}