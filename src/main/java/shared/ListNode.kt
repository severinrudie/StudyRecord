package shared

data class ListNode @JvmOverloads constructor(
        @JvmField val `val`: Int,
        @JvmField var next: ListNode? = null
) {
    override fun toString(): String {
        return `val`.toString() + if (next != null) " -> " + next!!.toString() else ""
    }

    companion object {
        fun from(vararg list: Int): ListNode? = from(false, *list)

        fun from(shouldCycle: Boolean = false, vararg list: Int): ListNode? {
            if (list.isEmpty()) return null

            val dummy = ListNode(-1)
            var curr = dummy;

            for (i in list) {
                curr.next = ListNode(i)
                curr = curr.next!!
            }

            if (shouldCycle) curr.next = dummy.next

            return dummy.next!!
        }
    }
}
