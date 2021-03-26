package y2021.m03.d26

import shared.TreeNode

class LC951FlipEquivalentBinaryTrees {
    // O(n) time, O(d) space [recursion stack, could be made O(1) iteratively]
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        reorder(root1)
        reorder(root2)
        return equals(root1, root2)
    }

    fun reorder(node: TreeNode?) {
        node ?: return
        val left = node.left
        val right = node.right
        val (l, r) = when {
                left == null && right == null -> null to null
                left == null -> right to null
                right == null -> left to null
                left.`val` <= right.`val` -> left to right
                else -> right to left
            }
        node.left = l
        node.right = r

        reorder(l)
        reorder(r)
    }

    fun equals(n1: TreeNode?, n2: TreeNode?): Boolean {
        if (n1 == null && n2 == null) return true
        if (n1 == null || n2 == null) return false
        if (n1.`val` != n2.`val`) return false

        return equals(n1.left, n2.left) && equals(n1.right, n2.right)
    }
}
