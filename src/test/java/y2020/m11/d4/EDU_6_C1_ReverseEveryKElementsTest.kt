package y2020.m11.d4

import org.junit.jupiter.api.Test
import shared.ListNode
import y2020.m11.d4.EDU_6_C1_ReverseEveryKElements.reverse
import kotlin.test.assertEquals

internal class EDU_6_C1_ReverseEveryKElementsTest {

    @Test
    fun tc1() {
        assertEquals(
                ListNode.from(2,1,3,4,6,5,7,8),
                reverse(ListNode.from(1,2,3,4,5,6,7,8),2)
        )
    }

}