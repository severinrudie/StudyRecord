package y2021.m01.d29

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_10_C2_StructurallyUniqueBinarySearchTreesTest {

    val c = EDU_10_C2_StructurallyUniqueBinarySearchTrees()

    @Test
    fun tc1() {
        val nodes = c.findUniqueTrees(2)

        assertEquals(2, nodes.size)
    }

    @Test
    fun tc2() {
        val nodes = c.findUniqueTrees(3)

        assertEquals(5, nodes.size)
    }

    @Test
    fun tc3() {
        val nodes = c.findUniqueTrees(15)

        assertEquals(9694845, nodes.size)
    }
}
