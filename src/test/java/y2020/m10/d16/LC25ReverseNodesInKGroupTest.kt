package y2020.m10.d16

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import shared.ListNode
import y2020.m10.d19.LC25ReverseNodesInKGroup.reverseKGroup

internal class LC25ReverseNodesInKGroupTest {

    @Test
    fun tc1() {
        assertEquals(ListNode.from(2,1,4,3,5), reverseKGroup(ListNode.from(1,2,3,4,5), 2))
    }

    @Test
    fun tc2() {
        assertEquals(ListNode.from(1,2,3,4,5), reverseKGroup(ListNode.from(1,2,3,4,5), 6))
    }

    @Test
    fun tc3() {
        assertEquals(ListNode.from(5,4,3,2,1), reverseKGroup(ListNode.from(1,2,3,4,5), 5))
    }

    @Test
    fun tc4() {
        assertEquals(ListNode.from(), reverseKGroup(ListNode.from(), 2))
    }

    @Test
    fun tc5() {
        assertEquals(ListNode.from(4,3,2,1,5,6), reverseKGroup(ListNode.from(1,2,3,4,5,6), 4))
    }
}
