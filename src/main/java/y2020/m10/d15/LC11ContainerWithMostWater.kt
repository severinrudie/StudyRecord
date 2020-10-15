package y2020.m10.d15

object LC11ContainerWithMostWater {

    /**
     * Medium, 51%
     * O(n) time, O(1) space
     *
     * Greedy algorithm.  For any given pair of walls, the max height is determined by the
     * shorter one.  Moving the walls closer together decreases the width, and so requires
     * higher walls in order to result in a larger container.  Therefore, for any given
     * pair of walls, it is impossible to get a larger container by moving the higher wall
     * inward.  We move the smaller wall until left has passed right, storing the max
     * possible height.
     */
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var max = 0

        while (left < right) {
            val currMax = Math.min(height[left], height[right]) * (right - left)
            max = Math.max(max, currMax)

            if (height[left] < height[right]) left++
            else right--
        }

        return max
    }
}
