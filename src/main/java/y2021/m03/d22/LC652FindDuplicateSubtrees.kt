package y2021.m03.d22

import shared.TreeNode
import java.util.*

class LC652FindDuplicateSubtrees {
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        val result = mutableListOf<TreeNode>()

        val visited = mutableMapOf<String, Int>()

        val processing = LinkedList<TreeNode?>()
        processing.add(root)
        while (processing.isNotEmpty()) {
            val next = processing.removeAt(0) ?: continue
            val str = next.str()
            if (visited[str] == 1) result += next
            visited[str] = (visited[str] ?: 0) + 1
            processing += next.left
            processing += next.right
        }

        return result
    }

    val stringReps = mutableMapOf<TreeNode?, String>()

    fun TreeNode?.str(): String {
        if (this == null) return "_"

        var lStr = stringReps[this.left]
        if (lStr == null) {
            lStr = this.left.str()
            stringReps[this.left] = lStr
        }
        var rStr = stringReps[this.right]
        if (rStr == null) {
            rStr = this.right.str()
            stringReps[this.right] = rStr
        }

        return "${`val`},$lStr,$rStr,"
    }
}
