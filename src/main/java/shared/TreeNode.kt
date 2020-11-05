package shared

import kotlin.math.max

data class TreeNode(
        @JvmField val `val`: Int,
        @JvmField var left: TreeNode?,
        @JvmField var right: TreeNode?
) {
    companion object {
        fun from(list: List<List<Int>>): TreeNode = from(*list.toTypedArray())

        fun from(vararg list: List<Int>): TreeNode {
            val last = mutableListOf<TreeNode>()
            val next = mutableListOf<TreeNode>()

            for (row in list.asList().asReversed()) {
                for (num in row) {
                    val left = last.removeFirstOrNull()
                    val right = last.removeFirstOrNull()

                    next += TreeNode(num, left, right)
                }
                last.clear()
                last.addAll(next)
                next.clear()
            }
            return last.first()
        }
    }

    fun maxWidth() = toList().maxOf { it.size }

    fun toList(): List<List<Int>> = toList(mutableMapOf(), 1)

    private fun toList(
            lists: MutableMap<Int, List<Int>>,
            currDepth: Int
    ): List<List<Int>> {
        lists[currDepth] = lists.getOrDefault(currDepth, emptyList()) + `val`

        left?.toList(lists, currDepth + 1)
        right?.toList(lists, currDepth + 1)

        return lists.values.toList()
    }

    fun maxDepth() = maxDepth(1)

    private fun maxDepth(currDepth: Int): Int = max(
        left?.maxDepth(currDepth + 1) ?: currDepth,
        right?.maxDepth(currDepth + 1) ?: currDepth
        )

    // TODO does not handle numbers with multiple digits well
    override fun toString(): String {
        val list = toList()
        val maxDepth = maxDepth()

        var result = ""

        for (i in maxDepth - 1 downTo 0) {
            val lead = 2.pow(i)
            val buffer = " ".repeat(lead - 1)
            result += list[list.lastIndex - i].map { "$buffer$it$buffer" }
                    .joinToString(separator = " ", prefix = " ", postfix = " ") +
                    "\n"
        }

        return result
    }
}

/**
 * Can easily overflow
 */
private fun Int.pow(exp: Int): Int {
    var result = 1
    for (i in 1..exp) {
        result *= this
    }
    return result
}
