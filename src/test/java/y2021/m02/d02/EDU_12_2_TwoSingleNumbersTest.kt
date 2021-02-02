package y2021.m02.d02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_12_2_TwoSingleNumbersTest {

    val c = EDU_12_2_TwoSingleNumbers()

    @Test
    fun tc1() {
        assertEquals(5 to 6, c.findSingleNumbers(intArrayOf(1,2,3,4,5,6,1,2,3,4)))
    }

    @Test
    fun tc2() {
        assertEquals(3 to 1, c.findSingleNumbers(intArrayOf(1,2,2,3)))
    }
}
