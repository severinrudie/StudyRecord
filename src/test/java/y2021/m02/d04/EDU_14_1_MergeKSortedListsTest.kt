package y2021.m02.d04

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import shared.ListNode

internal class EDU_14_1_MergeKSortedListsTest {

    val c = EDU_14_1_MergeKSortedLists()

    fun nodeOf(vararg nums: Int) = ListNode.from(*nums)!!

    @Test
    fun tc1() {
        val input = arrayOf(
            nodeOf(2,6,8),
            nodeOf(3,6,7),
            nodeOf(1,3,4)
        )
        val expect = nodeOf(1, 2, 3, 3, 4, 6, 6, 7, 8)
        assertEquals(expect, c.merge(input))
    }

    @Test
    fun tc2() {
        val input = arrayOf(
            nodeOf(5,8,9),
            nodeOf(1,7),
        )
        val expect = nodeOf(1,5,7,8,9)
        assertEquals(expect, c.merge(input))
    }
}
