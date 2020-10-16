package shared

class ListNode(val `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return `val`.toString() + if (next != null) next!!.toString() else ""
    }

    override fun equals(other: Any?): Boolean {
        return this.toString() == other.toString()
    }
}
