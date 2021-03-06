package y2021.m03.d05

import shared.TreeNode

class LC222CountCompleteTreeNodes {
    // O(n) time, O(n) space
    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0

        return 1 + countNodes(root.left) + countNodes(root.right)
    }
}