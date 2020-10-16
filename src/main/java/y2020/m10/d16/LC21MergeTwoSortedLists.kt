package y2020.m10.d16

import shared.ListNode

// Easy, 54%
// O(n) time, O(1) space
object LC21MergeTwoSortedLists {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1

        val head: ListNode = ListNode(-1) // dummy node
        var one = l1
        var two = l2
        var tail = head

        while (one != null && two != null) {
            if (one.`val` < two.`val`) {
                tail.next = one
                one = one.next
            } else {
                tail.next = two
                two = two.next
            }
            tail = tail.next!!
        }

        if (one != null) tail.next = one
        if (two != null) tail.next = two

        return head.next
    }
}
