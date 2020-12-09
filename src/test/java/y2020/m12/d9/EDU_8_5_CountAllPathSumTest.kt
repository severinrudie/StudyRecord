package y2020.m12.d9

import org.junit.jupiter.api.Test
import shared.TreeNode
import y2020.m12.d9.EDU_8_5_CountAllPathSum.countPaths
import kotlin.test.assertEquals

internal class EDU_8_5_CountAllPathSumTest {
    @Test
    fun tc1() {
        val root = TreeNode(12,
                TreeNode(7,
                        TreeNode(4, null, null), null),
                TreeNode(1,
                        TreeNode(10, null, null),
                        TreeNode(5, null, null)
                )
        )

        assertEquals(2, countPaths(root, 11))
    }
}
