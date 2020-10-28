package y2020.m10.d28

import org.junit.jupiter.api.Test
import shared.ListNode
import y2020.m10.d28.EDU_3_1_LinkedListCycle.hasCycle
import kotlin.test.assertEquals

internal class EDU_3_1_LinkedListCycleTest {

    @Test
    fun tc1() {
        assertEquals(false, hasCycle(ListNode.from(shouldCycle = false, 1,2,3,4,5)))
    }

    @Test
    fun tc2() {
        assertEquals(true, hasCycle(ListNode.from(shouldCycle = true, 1,2,3,4,5)))
    }

    @Test
    fun tc3() {
        assertEquals(false, hasCycle(ListNode.from(shouldCycle = false, 1,2,3,4)))
    }

    @Test
    fun tc4() {
        assertEquals(true, hasCycle(ListNode.from(shouldCycle = true, 1,2,3,4)))
    }

    @Test
    fun tc5() {
        assertEquals(false, hasCycle(ListNode.from(shouldCycle = false, 1)))
    }

    @Test
    fun tc6() {
        assertEquals(true, hasCycle(ListNode.from(shouldCycle = true, 1,2,3)))
    }
}