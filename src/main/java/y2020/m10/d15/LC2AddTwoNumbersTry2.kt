package y2020.m10.d15

import shared.ListNode

// Medium, 34%
// O(n)
object LC2AddTwoNumbersTry2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1

        var carry = 0
        var node1 = l1
        var node2 = l2

        val head = ListNode(-1) // dummy node
        var tail = head
        while (node1 != null && node2 != null) {
            val next = node1.`val` + node2.`val` + carry
            val singles = next % 10
            carry = (next - singles) / 10

            val nextNode = ListNode(singles)
            tail.next = nextNode
            tail = nextNode
            node1 = node1.next
            node2 = node2.next
        }

        var lastHead = if (node1 != null) node1 else node2
        while (lastHead != null) {
            val next = lastHead.`val` + carry
            val singles = next % 10
            carry = (next - singles) / 10

            val nextNode = ListNode(singles)
            tail.next = nextNode
            tail = nextNode
            lastHead = lastHead.next
        }

        while (carry != 0) {
            val single = carry % 10
            carry = (carry - single) / 10
            tail.next = ListNode(single)
        }

        return head.next
    }
}