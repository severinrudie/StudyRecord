package y2021.m02.d03

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_13_7_KthLargestNumberInAStreamTest {

    @Test
    fun tc1() {
        val c = EDU_13_7_KthLargestNumberInAStream(intArrayOf(3, 1, 5, 12, 2, 11), 4)

        assertEquals(5, c.add(6))
        assertEquals(6, c.add(13))
        assertEquals(6, c.add(4))
    }
}
