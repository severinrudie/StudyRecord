package y2021.m01.d29

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_11_1_OrderAgnosticBinarySearchTest {

    val c = EDU_11_1_OrderAgnosticBinarySearch()

    @Test
    fun tc1() {
        assertEquals(2, c.search(intArrayOf(4,6,10), 10))
    }

    @Test
    fun tc2() {
        assertEquals(4, c.search(intArrayOf(1, 2, 3, 4, 5, 6, 7), 5))
    }

    @Test
    fun tc3() {
        assertEquals(0, c.search(intArrayOf(10, 6, 4), 10))
    }

    @Test
    fun tc4() {
        assertEquals(2, c.search(intArrayOf(10, 6, 4), 4))
    }

}