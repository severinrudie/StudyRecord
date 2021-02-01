package y2021.m01.d29

import shared.TreeNode

class EDU_10_C2_StructurallyUniqueBinarySearchTrees {
    fun findUniqueTrees(n: Int): List<TreeNode?> {
        val memoizer = mutableMapOf<Pair<Int, Int>, List<TreeNode?>>()
        return findUniqueTrees(1, n, memoizer)
    }

    // O(n 2^n) time, O(2^n) space
    fun findUniqueTrees(start: Int, end: Int, memoizer: MutableMap<Pair<Int, Int>, List<TreeNode?>>): List<TreeNode?> {
        if (memoizer.containsKey(start to end)) return memoizer[start to end]!!
        if (end < start) return listOf(null)

        val result = mutableListOf<TreeNode?>()

        for (i in start..end) {
            val smaller = findUniqueTrees(start, i - 1, memoizer)
            val larger = findUniqueTrees(i + 1, end, memoizer)

            for (small in smaller) {
                for (large in larger) {
                    result += TreeNode(i, small, large)
                }
            }
        }
        memoizer[start to end] = result
        return result
    }
}
