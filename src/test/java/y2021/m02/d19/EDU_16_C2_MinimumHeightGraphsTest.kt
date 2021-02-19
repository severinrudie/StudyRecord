package y2021.m02.d19

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class EDU_16_C2_MinimumHeightGraphsTest {

    val c = EDU_16_C2_MinimumHeightGraphs()

    @Test
    fun tc1() {
        val verts = 5
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 4))
        val expect = setOf(1,2)

        assertEquals(expect, c.findTrees(verts, edges).toSet())
    }

    @Test
    fun tc2() {
        val verts = 4
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0,2), intArrayOf(2, 3))
        val expect = setOf(0,2)

        assertEquals(expect, c.findTrees(verts, edges).toSet())
    }

    @Test
    fun tc3() {
        val verts = 4
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1,2), intArrayOf(1, 3))
        val expect = setOf(1)

        assertEquals(expect, c.findTrees(verts, edges).toSet())
    }

    @Test
    fun tc4() {
        val verts = 8
        val edges = arrayOf(
            intArrayOf(0,1),intArrayOf(0,2),intArrayOf(0,3),intArrayOf(0,4),intArrayOf(0,5),intArrayOf(0,6),intArrayOf(0,7)
        )
        val expect = setOf(0)

        assertEquals(expect, c.findTrees(verts, edges).toSet())
    }
}
