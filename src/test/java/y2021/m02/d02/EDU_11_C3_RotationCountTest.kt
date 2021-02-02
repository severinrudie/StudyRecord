package y2021.m02.d02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_11_C3_RotationCountTest {

    val c = EDU_11_C3_RotationCount()

    @Test
    fun tc1() {
        assertEquals(2, c.countRotations(intArrayOf(10, 15, 1, 3, 8)))
    }

    @Test
    fun tc2() {
        assertEquals(5, c.countRotations(intArrayOf(4, 5, 7, 9, 10, -1, 2)))
    }

    @Test
    fun tc3() {
        assertEquals(0, c.countRotations(intArrayOf(1, 3, 8, 10)))
    }
}
