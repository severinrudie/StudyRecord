package y2021.m03.d16

import shared.TreeNode

class PrampLargestSmallerBst {

    // O(n) time, O(n) space [in the worst case, height can be n]
    fun findLargestSmallerKey(root: TreeNode, num: Int): Int {
        val nextBiggest = getSmallestBigger(root, num)
        val returnVal = getNextSmallest(nextBiggest) ?: return -1
        return returnVal.`val`
    }

    fun getSmallestBigger(root: TreeNode?, num: Int): TreeNode? {
        if (root == null) return null
        val value = root.`val`
        return when {
            num == value -> root
            num < value -> {
                val smaller = getSmallestBigger(root.left, num)
                smaller ?: return root
                if (smaller.`val` < num) return root
                return smaller
            }
            else -> {
                val bigger = getSmallestBigger(root.right, num)
                bigger ?: return root
                if (bigger.`val` > num) return root
                return bigger
            }
        }
    }

    fun getNextSmallest(root: TreeNode?): TreeNode? {
        if (root == null || root.left == null) return null
        var node = root.left
        while (node!!.right != null) node = node.right
        return node
    }
}
