package y2020.m10.d28

import org.junit.jupiter.api.Test
import y2020.m10.d28.EDU_2_C3_ShortestWindowSort.sort
import kotlin.test.assertEquals

internal class EDU_2_C3_ShortestWindowSortTest {

    @Test
    fun tc1() {
        assertEquals(5, sort(intArrayOf(1,3,2,0,-1,7,10)))
    }
    @Test
    fun tc2() {
        assertEquals(5, sort(intArrayOf(1, 2, 5, 3, 7, 10, 9, 12)))
    }
    @Test
    fun tc3() {
        assertEquals(0, sort(intArrayOf(1,2,3)))
    }
    @Test
    fun tc4() {
        assertEquals(3, sort(intArrayOf(3,2,1)))
    }
}
