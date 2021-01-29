package y2021.m01.d28

import org.junit.jupiter.api.Test
import y2021.m01.d28.EDU_10_6_UniqueGeneralizedAbbreviations.generateGeneralizedAbbreviation
import kotlin.test.assertEquals

internal class EDU_10_6_UniqueGeneralizedAbbreviations_Test {

    @Test
    fun tc1() {
        val expect = listOf("BAT", "BA1", "B1T", "B2", "1AT", "1A1", "2T", "3").sorted()
        val actual = generateGeneralizedAbbreviation("BAT").sorted()
        assertEquals(expect, actual)
    }

    @Test
    fun tc2() {
        val expect = listOf("code", "cod1", "co1e", "co2", "c1de", "c1d1", "c2e", "c3", "1ode", "1od1", "1o1e", "1o2",
            "2de", "2d1", "3e", "4").sorted()
        val actual = generateGeneralizedAbbreviation("code").sorted()
        assertEquals(expect, actual)
    }
}
