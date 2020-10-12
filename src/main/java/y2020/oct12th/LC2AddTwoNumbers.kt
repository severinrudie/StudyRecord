package y2020.oct12th

class ListNode(val `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return `val`.toString() + if (next != null) next!!.toString() else ""
    }

    override fun equals(other: Any?): Boolean {
        return this.toString() == other.toString()
    }
}

object LC2AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode? {
        val (long, short) = longShort(l1.toStr(), l2.toStr())
        val shortPadded = short.padEnd(long.length, '0')

        return zipNodes(shortPadded, long).toListNode()
    }

    fun ListNode.toStr(): String {
        return if (next == null) {
            this.`val`.toString()
        } else {
            this.`val`.toString() + (next!!.toStr())
        }
    }

    fun longShort(l1: String, l2: String): Pair<String, String> {
        return if (l1.length >= l2.length) {
            l1 to l2
        } else {
            l2 to l1
        }
    }

    fun zipNodes(s1: String, s2: String): String {
        val pairs = s1.zip(s2)
        var carry = 0
        var str = ""
        for ((c1, c2) in pairs) {
            val total = c1.toNumericValue() + c2.toNumericValue() + carry
            val onesPlace = total % 10
            carry = if (total == onesPlace) 0 else (total - onesPlace) / 10
            str += onesPlace
        }
        return str + if (carry > 0) carry.toString() else ""
    }

    fun String.toListNode(): ListNode {
        val head = ListNode(this.first())
        var tail = head
        for (i in 1..this.lastIndex) {
            tail.next = ListNode(this[i])
            tail = tail.next!!
        }
        return head
    }

    fun ListNode(c: Char) = ListNode(c.toNumericValue())

    fun Char.toNumericValue() = Character.getNumericValue(this)
}
