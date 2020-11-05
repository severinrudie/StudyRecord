package y2020.m11.d5

import org.junit.jupiter.api.Test
import shared.TreeNode
import y2020.m11.d5.EDU_7_7_ConnectLevelOrderSiblings.connect
import kotlin.test.assertEquals

internal class EDU_7_7_ConnectLevelOrderSiblingsTest {


    @Test
    fun tc1() {
        val tn = TreeNode.from(listOf(1), listOf(2,3), listOf(4,5,6))

        val heads = listOf(tn, tn.left, tn.left!!.left)
        connect(tn)

        assertEquals(
                TreeNode.from(listOf(1)),
                heads[0]
        )
        assertEquals(
                TreeNode.from(listOf(2),listOf(3)),
                heads[1]
        )
        assertEquals(
                TreeNode.from(listOf(4),listOf(5),listOf(6)),
                heads[2]
        )
    }
}
