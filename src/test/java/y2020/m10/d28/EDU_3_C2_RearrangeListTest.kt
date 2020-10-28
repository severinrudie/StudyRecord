package y2020.m10.d28

import org.junit.jupiter.api.Test
import shared.ListNode
import y2020.m10.d28.EDU_3_C2_RearrangeList.reorder
import kotlin.test.assertEquals

internal class EDU_3_C2_RearrangeListTest {
    @Test
    fun tc1() {
        val input = ListNode.from(2,4,6,8,10,12)
        reorder(input)
        assertEquals(
                ListNode.from(2,12,4,10,6,8),
                input
        )
    }

    @Test
    fun tc2() {
        val input = ListNode.from(2,4,6,8,10)
        reorder(input)
        assertEquals(
                ListNode.from(2,10,4,8,6),
                input
        )
    }
}
