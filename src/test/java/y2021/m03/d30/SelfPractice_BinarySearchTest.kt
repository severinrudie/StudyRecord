package y2021.m03.d30

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SelfPractice_BinarySearchTest {

    @Test
    fun tc1() {
        val bs = SelfPractice_BinarySearch(listOf(0,1,2,3,4,5))

        assertEquals(2, bs.any(2))
        assertEquals(2, bs.first(2))
        assertEquals(2, bs.last(2))
        assertEquals(1, bs.lastLessThan(2))
        assertEquals(3, bs.firstGreaterThan(2))
    }

    @Test
    fun tc2() {
        val bs = SelfPractice_BinarySearch(listOf())

        assertEquals(null, bs.any(2))
        assertEquals(null, bs.first(2))
        assertEquals(null, bs.last(2))
        assertEquals(null, bs.lastLessThan(2))
        assertEquals(null, bs.firstGreaterThan(2))
    }

    @Test
    fun tc3() {
        val bs = SelfPractice_BinarySearch(listOf(2,2,3,4,5))

        assertTrue {
            bs.any(2) == 0 || bs.any(2) == 1
        }
        assertEquals(0, bs.first(2))
        assertEquals(1, bs.last(2))
        assertEquals(null, bs.lastLessThan(2))
        assertEquals(2, bs.firstGreaterThan(2))
    }

    @Test
    fun tc4() {
        val bs = SelfPractice_BinarySearch(listOf(0,1,2,2))

        assertTrue {
            bs.any(2) == 2 || bs.any(2) == 3
        }
        assertEquals(2, bs.first(2))
        assertEquals(3, bs.last(2))
        assertEquals(1, bs.lastLessThan(2))
        assertEquals(null, bs.firstGreaterThan(2))
    }
}
