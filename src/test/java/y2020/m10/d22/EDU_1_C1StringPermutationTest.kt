package y2020.m10.d22

import org.junit.jupiter.api.Test
import y2020.m10.d22.EDU_1_C1StringPermutation.findPermutation
import kotlin.test.assertTrue

internal class EDU_1_C1StringPermutationTest {


    @Test
    fun tc1() {
        assertTrue(findPermutation("oidbcaf", "abc"))
    }
}