package y2021.m03.d05

import shared.TreeNode
import kotlin.math.max

class LC298BinaryTreeLongestConsecutiveSequence {
    // O(n) time, O(n) space
    fun longestConsecutive(root: TreeNode, prevCount: Int = 0): Int {
        val left = root.left
        val leftCount = when {
            left == null -> 0
            left.`val` == root.`val` + 1 -> longestConsecutive(left, prevCount + 1)
            else -> longestConsecutive(left, 0)
        }
        val right = root.right
        val rightCount = when {
            right == null -> 0
            right.`val` == root.`val` + 1 -> longestConsecutive(right, prevCount + 1)
            else -> longestConsecutive(right, 0)
        }

        return max(prevCount + 1, max(leftCount, rightCount))
    }
}
