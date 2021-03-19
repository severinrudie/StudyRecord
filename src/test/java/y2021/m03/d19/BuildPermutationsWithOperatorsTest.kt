package y2021.m03.d19

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BuildPermutationsWithOperatorsTest {

    val c = BuildPermutationsWithOperators()

    @Test
    fun tc1() {
        assertEquals(listOf("1+2","2+1","1-2","2-1","1*2","2*1","1/2","2/1").sorted(), c.buildPermutations(listOf(1,2)).sorted())
    }
    
    @Test
    fun tc2() {
        val expectStart = listOf("1+2+3", "1-2-3", "1*2/3", "1/2*3", "2+1+3", "2-1*3", "2*1/3", "2/1+3")
        val actual = c.buildPermutations(listOf(1,2,3))

        expectStart.forEach {
            assertTrue { it in actual }
        }
    }
}
