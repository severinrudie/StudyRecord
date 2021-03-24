package y2021.m03.d24

import kotlin.math.sqrt

class Pramp_HTreeConstruction {
    // https://www.pramp.com/challenge/EmYgnOgVd4IElnjAnQqn

    data class Point(val x: Int, val y: Int)

    // O(4 ^ n) time, O(n) space
    fun drawHs(maxDepth: Int, currDepth: Int = 1, prevLen: Int = 1000, center: Point) {
        if (currDepth > maxDepth) return
        val len = getLen(prevLen)
        val newPoints = drawH(center, len)

        newPoints.forEach { drawHs(maxDepth, currDepth + 1, len, it) }
    }

    fun getLen(prevLen: Int): Int { // ignoring rounding errors for now
        return (prevLen/ sqrt(2.0)).toInt()
    }

    // Draws H around this centerpoint, then returns the four corner points (top/bottom of vertical lines)
    fun drawH(center: Point, len: Int): List<Point> {
        val halfLen = len/2
        val left = center.x - halfLen
        val right = center.x + halfLen
        val top = center.y + halfLen
        val bot = center.y - halfLen

        // horizontal line
        drawLine(Point(x = left, y = center.y), Point(x = right, y = center.y))
        // left vertical
        drawLine(Point(x = left, y = top), Point(x = left, y = bot))
        // right vertical
        drawLine(Point(x = right, y = top), Point(x = right, y = bot))

        return listOf(
            Point(x = left, y = top),
            Point(x = right, y = top),
            Point(x = left, y = bot),
            Point(x = right, y = bot)
        )
    }

    fun drawLine(from: Point, to: Point) {
        // provided
    }
}
