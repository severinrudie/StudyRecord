package y2021.m03.d23

import shared.TreeNode

class LC1110DeleteNodesAndReturnForest {
    // O(n) time, O(n) space
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        return delNodes(root, null, to_delete.toSet())
    }

    fun delNodes(root: TreeNode?, parent: TreeNode?, toDelete: Set<Int>): List<TreeNode> {
        root ?: return emptyList()
        val start = if (
            root.`val` !in toDelete &&
            (parent == null || parent.`val` in toDelete)
        ) {
            listOf(root)
        }else {
            emptyList()
        }

        val left = root.left
        if (left != null && left.`val` in toDelete) {
            root.left = null
        }
        val right = root.right
        if (right != null && right.`val` in toDelete) {
            root.right = null
        }

        return start + delNodes(left, root, toDelete) + delNodes(right, root, toDelete)
    }
}