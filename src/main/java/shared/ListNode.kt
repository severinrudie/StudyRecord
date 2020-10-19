package shared

data class ListNode(val `val`: Int, var next: ListNode? = null) {
    override fun toString(): String {
        return `val`.toString() + if (next != null) " -> " + next!!.toString() else ""
    }

    companion object {
        fun from(vararg list: Int): ListNode? {
            if (list.isEmpty()) return null

            val dummy = ListNode(-1)
            list.fold(dummy) { last, value ->
                val curr = ListNode(value)
                last.next = curr
                return@fold curr
            }
            return dummy.next!!
        }
    }
}

//
//    override fun equals(other: Any?): Boolean {
//        return (other is ListNode) &&
//                (this.next == other.next) &&
//                (this.`val` == other.`val`)
//    }
//}
