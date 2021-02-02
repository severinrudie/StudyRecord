package y2021.m02.d02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_12_3_ComplementOfABaseTenNumberTest {

    val c = EDU_12_3_ComplementOfABaseTenNumber()

    @Test
    fun tc1() {
        assertEquals(7, c.bitwiseComplement(8))
    }

    @Test
    fun tc2() {
        assertEquals(5, c.bitwiseComplement(10))
    }
}
