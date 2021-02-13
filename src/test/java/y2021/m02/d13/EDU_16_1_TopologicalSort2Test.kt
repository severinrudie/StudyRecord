package y2021.m02.d13

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_16_1_TopologicalSort2Test {

    val c = EDU_16_1_TopologicalSort2()

    @Test
    fun tc1() {
        val vertices = 4
        val edges = arrayOf(intArrayOf(3, 2), intArrayOf(3, 0), intArrayOf(2, 0), intArrayOf(2, 1))
        val expect = listOf(3,2,0,1)
        assertEquals(expect, c.sort(vertices, edges))
    }

    @Test
    fun tc2() {
        val vertices = 5
        val edges = arrayOf(intArrayOf(4, 2), intArrayOf(4, 3), intArrayOf(2, 0), intArrayOf(2, 1), intArrayOf(3, 1))
        val expect = listOf(4,2,3,0,1)
        assertEquals(expect, c.sort(vertices, edges))
    }

    @Test
    fun tc3() {
        val vertices = 7
        val edges = arrayOf(intArrayOf(6, 4), intArrayOf(6, 2), intArrayOf(5, 3), intArrayOf(5, 4), intArrayOf(3, 0), intArrayOf(3, 1), intArrayOf(3, 2), intArrayOf(4, 1))
        val expect = listOf(5,6,3,4,0,2,1)
        assertEquals(expect, c.sort(vertices, edges))
    }
}