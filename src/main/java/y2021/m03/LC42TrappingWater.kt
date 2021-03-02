package y2021.m03

import kotlin.math.max
import kotlin.math.min

class LC42TrappingWater {
    // O(n) time, O(n) space
    fun trap(height: IntArray): Int {
        val leftHeight = IntArray(height.size)
        val rightHeight = IntArray(height.size)

        var lMax = Int.MIN_VALUE
        for (i in 0..height.lastIndex) {
            lMax = max(lMax, height[i])
            leftHeight[i] = lMax
        }

        var rMax = Int.MIN_VALUE
        for (i in height.lastIndex downTo 0) {
            rMax = max(rMax, height[i])
            rightHeight[i] = rMax
        }

        var total = 0
        for (i in 1 until height.lastIndex) {
            val currHeight = height[i]
            val rim = min(leftHeight[i - 1], rightHeight[i + 1])
            val currDepth = rim - currHeight
            if (currDepth > 0) total += currDepth
        }
        return total
    }
}
