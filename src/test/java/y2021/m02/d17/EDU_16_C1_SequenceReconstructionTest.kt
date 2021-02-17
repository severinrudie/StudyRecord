package y2021.m02.d17

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_16_C1_SequenceReconstructionTest {

    val c = EDU_16_C1_SequenceReconstruction()

    @Test
    fun tc1() {
        val orig = intArrayOf(1,2,3,4)
        val subseqs = arrayOf(
            intArrayOf(1,2),
            intArrayOf(2,3),
            intArrayOf(3,4)
        )
        val expect = true
        assertEquals(expect, c.canConstruct(orig, subseqs))
    }

    @Test
    fun tc2() {
        val orig = intArrayOf(1,2,3,4)
        val subseqs = arrayOf(
            intArrayOf(1,2),
            intArrayOf(2,3),
            intArrayOf(2,4)
        )
        val expect = false
        assertEquals(expect, c.canConstruct(orig, subseqs))
    }

    @Test
    fun tc3() {
        val orig = intArrayOf(3, 1, 4, 2, 5)
        val subseqs = arrayOf(
            intArrayOf(3,1,5),
            intArrayOf(1,4,2,5),
        )
        val expect = true
        assertEquals(expect, c.canConstruct(orig, subseqs))
    }
}
