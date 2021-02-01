package y2021.m01.d29

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import y2021.m02.d01.EDU_11_4_NumberRange

internal class EDU_11_4_NumberRangeTest {

    val c = EDU_11_4_NumberRange()

    @Test
    fun tc1() {
        assertEquals(listOf(1,3), c.findRange(listOf(4, 6, 6, 6, 9), 6))
    }

    @Test
    fun tc2() {
        assertEquals(listOf(3,3), c.findRange(listOf(1, 3, 8, 10, 15), 10))
    }

    @Test
    fun tc3() {
        assertEquals(listOf(-1,-1), c.findRange(listOf(1, 3, 8, 10, 15), 12))
    }
}
