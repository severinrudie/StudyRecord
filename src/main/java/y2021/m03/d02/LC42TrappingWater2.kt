package y2021.m03.d02

import kotlin.math.max

class LC42TrappingWater2 {
    // Two pointer solution
    // O(n) time, O(1) space
    fun trap(height: IntArray): Int {
        if (height.isEmpty()) return 0
        var r = height.lastIndex
        var l = 0
        var rMax = height[r]
        var lMax = height[l]
        var total = 0

        while (l < r) {
            if (height[l] < height[r]) {
                lMax = max(lMax, height[l])
                total += lMax - height[l]
                l++
            } else {
                rMax = max(rMax, height[r])
                total += rMax - height[r]
                r--
            }
        }
        return total
    }
}
