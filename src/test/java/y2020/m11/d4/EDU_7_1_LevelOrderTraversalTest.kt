package y2020.m11.d4

import org.junit.jupiter.api.Test
import shared.TreeNode
import y2020.m11.d4.EDU_7_1_LevelOrderTraversal.traverse
import kotlin.test.assertEquals

internal class EDU_7_1_LevelOrderTraversalTest {

    @Test
    fun tc1() {
        val list = listOf(listOf(12), listOf(7, 1), listOf(9, 10, 5))

        assertEquals(
                list,
                traverse(TreeNode.from(list))
        )
    }

    @Test
    fun tc2() {
        val list = listOf(listOf(12), listOf(7, 1), listOf(9, 10, 5))

        assertEquals(
                list,
                traverse(TreeNode.from(list))
        )
    }
}