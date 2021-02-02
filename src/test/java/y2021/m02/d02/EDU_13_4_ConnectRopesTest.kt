package y2021.m02.d02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_13_4_ConnectRopesTest {

    val c = EDU_13_4_ConnectRopes()

    @Test
    fun tc1() {
        val input = intArrayOf(1, 3, 11, 5)
        val expect = 33
        assertEquals(expect, c.minimumCostToConnectRopes(input))
    }

    @Test
    fun tc2() {
        val input = intArrayOf(3, 4, 5, 6)
        val expect = 37
        assertEquals(expect, c.minimumCostToConnectRopes(input))
    }

    @Test
    fun tc3() {
        val input = intArrayOf(1, 3, 11, 5, 2)
        val expect = 42
        assertEquals(expect, c.minimumCostToConnectRopes(input))
    }
}
