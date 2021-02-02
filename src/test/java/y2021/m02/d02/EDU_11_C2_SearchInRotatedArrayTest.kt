package y2021.m02.d02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.asserter

internal class EDU_11_C2_SearchInRotatedArrayTest {

    val c = EDU_11_C2_SearchInRotatedArray()

    @Test
    fun tc1() {
        assertEquals(1, c.search(intArrayOf(10, 15, 1, 3, 8), 15))
    }

    @Test
    fun tc2() {
        assertEquals(4, c.search(intArrayOf(4, 5, 7, 9, 10, -1, 2), 10))
    }

    @Test
    fun m1() {
        assertEquals(3, c.findStart(intArrayOf(5,6,7,1,2)))
    }

    @Test
    fun m2() {
        assertEquals(0, c.findStart(intArrayOf(0,1,2)))
    }

    @Test
    fun m3() {
        assertEquals(0, c.findStart(intArrayOf(0,1,2,3)))
    }

    @Test
    fun m4() {
        assertEquals(1, c.findStart(intArrayOf(3,1,2)))
    }

    @Test
    fun m5() {
        assertEquals(3, c.findStart(intArrayOf(2,3,4,1)))
    }

    @Test
    fun m6() {
        assertEquals(4, c.findStart(intArrayOf(2,3,4,5,1)))
    }
}
