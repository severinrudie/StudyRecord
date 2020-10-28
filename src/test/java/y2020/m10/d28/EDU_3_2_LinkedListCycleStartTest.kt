package y2020.m10.d28

import org.junit.jupiter.api.Test
import shared.ListNode
import y2020.m10.d28.EDU_3_2_LinkedListCycleStart.findCycleStart
import kotlin.test.assertEquals

internal class EDU_3_2_LinkedListCycleStartTest {
    @Test
    fun tc1() {
        assertEquals(2, findCycleStart(ListNode.from(cycleFrom = 2, 1,2,3,4,5,6)).`val`)
    }

    @Test
    fun tc2() {
        assertEquals(3, findCycleStart(ListNode.from(cycleFrom = 3, 1,2,3,4,5,6)).`val`)
    }

    @Test
    fun tc3() {
        assertEquals(0, findCycleStart(ListNode.from(cycleFrom = 0, 1,2,3,4,5,6)).`val`)
    }
}
