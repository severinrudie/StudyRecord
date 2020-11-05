package y2020.m11.d5

import org.junit.jupiter.api.Test
import shared.TreeNode
import y2020.m11.d5.EDU_8_3_SumOfPathNumbers.findSumOfPathNumbers
import kotlin.test.assertEquals

internal class EDU_8_3_SumOfPathNumbersTest {
    @Test
    fun tc1() {
        assertEquals(
                408,
                findSumOfPathNumbers(TreeNode.from(listOf(1), listOf(9,7), listOf(2, 9)))
        )
    }

    @Test
    fun tc2() {
        assertEquals(
                332,
                findSumOfPathNumbers(TreeNode.from(listOf(1), listOf(1,0), listOf(6,5,1)))
        )
    }
}