package y2021.m03.d28

import shared.TreeNode

class IK_LargestSubtreePair {
    // O(n) time, O(n) space
    fun largestPair(root: TreeNode?): Pair<TreeNode, TreeNode>? {
        // construct a HM of string representations of each TreeNode
        // be careful to do this efficiently
        // loop over HM, find the longest value where count >= 2
        val map = mutableMapOf<String,List<TreeNode>>()
        loadMap(root, map)


        val bestValue = map.filter { (k,v) -> v.size > 1 }
            .maxBy { (k,v) -> k.length } // gives incorrect answer if nodes have multiple digits
                // TODO instead of max by length, split strings according to loadMap pattern and count
            ?.value

        if (bestValue == null) return null

        return bestValue[0] to bestValue[1]
    }

    fun loadMap(root: TreeNode?, map: MutableMap<String, List<TreeNode>>): String {
        if (root == null) return "_"
        val str = "${root.`val`}:L:${loadMap(root.left, map)}R:${loadMap(root.right, map)}"

        map[str] = (map[str] ?: emptyList()) + root
        return str
    }
}
