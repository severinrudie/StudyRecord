package oct12th

import oct12th.LC1TwoSum.twoSum
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LC1TwoSumTest {
    @Test
    fun tc1() {
        check(intArrayOf(0,1), twoSum(intArrayOf(2,7,11,15), 9))
    }

    private fun check(arr1: IntArray, arr2: IntArray) {
        assertEquals(arr1.toSet(), arr2.toSet())
    }
}
