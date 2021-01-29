package y2021.m01.d28

import org.junit.jupiter.api.Test
import y2021.m01.d28.EDU_10_6_UniqueGeneralizedAbbreviations.generateGeneralizedAbbreviation
import kotlin.test.assertEquals

internal class EDU_10_6_UniqueGeneralizedAbbreviations_Test {

    @Test
    fun tc1() {
        val expect = listOf("BAT", "BA1", "B1T", "B2", "1AT", "1A1", "2T", "3", "hi").sorted()
        val actual = generateGeneralizedAbbreviation("BAT").sorted()
        assertEquals(expect, actual)
    }
}
