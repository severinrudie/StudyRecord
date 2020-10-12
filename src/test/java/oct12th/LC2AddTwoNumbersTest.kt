package oct12th

import oct12th.LC2AddTwoNumbers.addTwoNumbers
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LC2AddTwoNumbersTest {

    @Test
    fun tc1() {
        assertEquals(ln(0,0,0,0,0,0,0,0,0,0,1), addTwoNumbers(ln(9), ln(1,9,9,9,9,9,9,9,9,9)))
    }

    @Test
    fun tc2() {
        assertEquals(ln(7,0,8), addTwoNumbers(ln(2,4,3),ln(5,6,4)))
    }

    fun ln(vararg list: Int): ListNode {
        val head = ListNode(list.first())
        var tail = head

        for (i in 1..list.lastIndex) {
            tail.next = ListNode(list[i])
            tail = tail.next!!
        }
        return head
    }

}