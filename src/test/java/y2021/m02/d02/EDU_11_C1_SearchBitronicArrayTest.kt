package y2021.m02.d02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_11_C1_SearchBitronicArrayTest {

    val c = EDU_11_C1_SearchBitronicArray()

    @Test
    fun tc1() {
        assertEquals(3, c.search(intArrayOf(1, 3, 8, 4, 3), 4))
    }

    @Test
    fun tc2() {
        assertEquals(1, c.search(intArrayOf(3, 8, 3, 1), 8))
    }

    @Test
    fun tc3() {
        assertEquals(3, c.search(intArrayOf(1, 3, 8, 12), 12))
    }

    @Test
    fun tc4() {
        assertEquals(0, c.search(intArrayOf(10, 9, 8), 10))
    }
}
