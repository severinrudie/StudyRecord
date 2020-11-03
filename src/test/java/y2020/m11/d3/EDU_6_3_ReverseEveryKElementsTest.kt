package y2020.m11.d3

import org.junit.jupiter.api.Test
import shared.ListNode
import y2020.m11.d3.EDU_6_3_ReverseEveryKElements.reverse
import kotlin.test.assertEquals

internal class EDU_6_3_ReverseEveryKElementsTest {
    @Test
    fun tc1() {
        assertEquals(
                ListNode.from(3,2,1,6,5,4,8,7),
                reverse(ListNode.from(1,2,3,4,5,6,7,8), 3)
        )
    }
}