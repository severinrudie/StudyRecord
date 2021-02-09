package y2021.m02.d08

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_14_C1_KPairsWithLargestSumsTest {

    val c = EDU_14_C1_KPairsWithLargestSums()

    @Test
    fun tc1() {
        val l1 = intArrayOf(9,8,2)
        val l2 = intArrayOf(6,3,1)
        val k = 3
        val expect = listOf(9 to 3, 9 to 6, 8 to 6).sortedBy { "${it.first}:${it.second}" }
        assertEquals(expect, c.findKLargestPairs(l1, l2, k).sortedBy { "${it.first}:${it.second}" })
    }

    @Test
    fun tc2() {
        val l1 = intArrayOf(5,2,1)
        val l2 = intArrayOf(2,-1)
        val k = 3
        val expect = listOf(5 to 2, 2 to 2, 5 to -1).sortedBy { "${it.first}:${it.second}" }
        assertEquals(expect, c.findKLargestPairs(l1, l2, k).sortedBy { "${it.first}:${it.second}" })
    }
}
