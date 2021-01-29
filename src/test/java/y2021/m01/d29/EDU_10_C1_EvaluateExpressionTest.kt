package y2021.m01.d29

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_10_C1_EvaluateExpressionTest {

    val c = EDU_10_C1_EvaluateExpression()

    @Test
    fun tc1() {
        assertEquals(
            listOf(7, 9).sorted(),
            c.diffWaysToEvaluateExpression("1+2*3").sorted()
        )
    }

    @Test
    fun tc2() {
        assertEquals(
            listOf(8, -12, 7, -7, -3).sorted(),
            c.diffWaysToEvaluateExpression("2*3-4-5").sorted()
        )
    }
}
