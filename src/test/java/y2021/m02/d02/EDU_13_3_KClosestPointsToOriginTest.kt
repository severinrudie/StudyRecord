package y2021.m02.d02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import y2021.m02.d02.EDU_13_3_KClosestPointsToOrigin.Point

internal class EDU_13_3_KClosestPointsToOriginTest {

    val c = EDU_13_3_KClosestPointsToOrigin()

    @Test
    fun tc1() {
        val input = listOf(Point(1, 2), Point(1,3))
        val k = 1
        val expect = listOf(Point(1,2))
        assertEquals(expect, c.findClosestPoints(input, k))
    }

    @Test
    fun tc2() {
        val input = listOf(Point(1, 3), Point(3, 4), Point(2, -1))
        val k = 2
        val expect = listOf(Point(1, 3), Point(2, -1))
        assertEquals(expect, c.findClosestPoints(input, k))
    }
}
