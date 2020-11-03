package shared

data class ListNode @JvmOverloads constructor(
        @JvmField val `val`: Int,
        @JvmField var next: ListNode? = null,
        val containsCycle: Boolean = false
) {
    override fun toString(): String {
        if (this.containsCycle) return "$`val` (cycle)"

        var fast = this.next;
        var slow = this;
        while (fast?.next != null && fast.next!!.next != null) {
            fast = fast.next!!.next
            slow = slow.next!!
            if (fast == slow) return "$`val` (cycle)"
        }

        return `val`.toString() + if (next != null) " -> " + next!!.toString() else ""
    }

    companion object {
        fun from(vararg list: Int): ListNode? = from(false, *list)

        fun from(shouldCycle: Boolean = false, vararg list: Int): ListNode? =
                when (shouldCycle) {
                    true -> from(cycleFrom = 0, list = list)
                    false -> from(cycleFrom = null, list = list)
                }

        fun from(cycleFrom: Int?, vararg list: Int): ListNode? {
            if (list.isEmpty()) return null
            val containsCycle = cycleFrom != null

            val dummy = ListNode(-1, containsCycle = containsCycle)
            var curr = dummy;
            var cycleStart: ListNode? = null

            for (i in list.indices) {
                curr.next = ListNode(list[i], containsCycle = containsCycle)
                curr = curr.next!!
                if (i == cycleFrom) cycleStart = curr
            }
            if (cycleFrom != null) curr.next = cycleStart

            return dummy.next!!
        }
    }
}
