package shared

data class ListNode(val `val`: Int, var next: ListNode? = null) {
    override fun toString(): String {
        return `val`.toString() + if (next != null) " -> " + next!!.toString() else ""
    }
}

//
//    override fun equals(other: Any?): Boolean {
//        return (other is ListNode) &&
//                (this.next == other.next) &&
//                (this.`val` == other.`val`)
//    }
//}
