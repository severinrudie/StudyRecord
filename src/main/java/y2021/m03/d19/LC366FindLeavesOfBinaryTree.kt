package y2021.m03.d19

import shared.TreeNode
import kotlin.math.max

// O(n) time, O(n) space
class LC366FindLeavesOfBinaryTree {
    val nodeLevels = mutableListOf<List<Int>>()

    fun findLeaves(root: TreeNode?): List<List<Int>> {
        getMaxHeight(root)
        return nodeLevels
    }

    fun getMaxHeight(root: TreeNode?): Int {
        if (root == null) return 0

        val thisMax = max(getMaxHeight(root.left), getMaxHeight(root.right))

        while (nodeLevels.lastIndex < thisMax) { nodeLevels += emptyList<Int>() }

        nodeLevels[thisMax] = nodeLevels[thisMax] + root.`val`

        return thisMax + 1
    }
}