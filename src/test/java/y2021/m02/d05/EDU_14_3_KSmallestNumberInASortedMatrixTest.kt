package y2021.m02.d05

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_14_3_KSmallestNumberInASortedMatrixTest {

    val c = EDU_14_3_KSmallestNumberInASortedMatrix()

    @Test
    fun tc1() {
        val arr = arrayOf(
                intArrayOf(2, 6, 8),
                intArrayOf(3, 7, 10),
                intArrayOf(5, 8, 11)
        )
        val k = 5
        val expect = 7
        assertEquals(7, c.findKthSmallest(arr, k))
    }
}
