package y2020.m10.d13

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import y2020.m10.d13.L4MedianOfTwoSortedArraysTry2.findMedianSortedArrays

internal class L4MedianOfTwoSortedArraysTry2Test {

    @Test
    fun tc1() {
        assertEquals(2.0, findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2)))
    }

    @Test
    fun tc2() {
        assertEquals(2.5, findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2, 4)))
    }
}
