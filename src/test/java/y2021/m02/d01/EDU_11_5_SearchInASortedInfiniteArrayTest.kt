package y2021.m02.d01

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import y2021.m02.d01.EDU_11_5_SearchInASortedInfiniteArray.ArrayReader

internal class EDU_11_5_SearchInASortedInfiniteArrayTest {

    val c = EDU_11_5_SearchInASortedInfiniteArray()

    @Test
    fun tc1() {
        val reader = ArrayReader(intArrayOf(4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30))
        assertEquals(6, c.search(reader,16))
    }

    @Test
    fun tc2() {
        val reader = ArrayReader(intArrayOf(4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30))
        assertEquals(-1, c.search(reader,11))
    }

    @Test
    fun tc3() {
        val reader = ArrayReader(intArrayOf(1, 3, 8, 10, 15))
        assertEquals(4, c.search(reader,15))
    }

    @Test
    fun tc4() {
        val reader = ArrayReader(intArrayOf(1, 3, 8, 10, 15))
        assertEquals(-1, c.search(reader,200))
    }
}
