package y2021.m02.d02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_12_1_SingleNumberTest {

    val c = EDU_12_1_SingleNumber()

    @Test
    fun tc1() {
        assertEquals(3, c.findSingleNumber(intArrayOf(1, 2, 1, 3, 2)))
    }
}