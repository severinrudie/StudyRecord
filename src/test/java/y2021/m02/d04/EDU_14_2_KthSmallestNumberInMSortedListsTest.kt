package y2021.m02.d04

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_14_2_KthSmallestNumberInMSortedListsTest {

    val c = EDU_14_2_KthSmallestNumberInMSortedLists()

    @Test
    fun tc1() {
        val lists = listOf(
            arrayOf(2,6,8),
            arrayOf(3,6,7),
            arrayOf(1,3,4)
        )
        val k = 5
        val expect = 4
        assertEquals(expect, c.findKthSmallest(lists, k))
    }

    @Test
    fun tc2() {
        val lists = listOf(
            arrayOf(5,8,9),
            arrayOf(1,7),
        )
        val k = 3
        val expect = 7
        assertEquals(expect, c.findKthSmallest(lists, k))
    }
}
