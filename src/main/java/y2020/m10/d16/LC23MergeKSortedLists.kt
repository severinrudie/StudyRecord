package y2020.m10.d16

import shared.ListNode

// Hard, 41%
// O(nm) time, O(1) space
object LC23MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var smallest = Int.MAX_VALUE
        var fromList = -1
        val head = ListNode(-1) // dummy node
        var tail = head

        while (true) {
            lists
                    .mapIndexed { i, node -> i to node }
                    .filter { it.second != null }
                    .forEach { (i, node) ->
                        if (node!!.`val` < smallest) {
                            smallest = node.`val`
                            fromList = i
                        }
                    }

            if (fromList == -1) {
                break
            } else {
                tail.next = lists[fromList]!!
                tail = tail.next!!
                lists[fromList] = lists[fromList]!!.next
                tail.next = null
            }

            fromList = -1
            smallest = Int.MAX_VALUE
        }

        return head
    }
}
