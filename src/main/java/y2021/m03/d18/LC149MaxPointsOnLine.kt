package y2021.m03.d18

import kotlin.math.*

class LC149MaxPointsOnLine {
    fun maxPoints(points: Array<IntArray>): Int {
        if (points.size < 2) return points.size

        var maxPoints = 0

        for (p1 in points) {
            val x1 = p1[0]
            val y1 = p1[1]

            // k: (slope to yIntersect) v: count
            val slopes = mutableMapOf<Pair<Double, Double>, Int>()
            for (p2 in points) {
                val x2 = p2[0]
                val y2 = p2[1]

                if (x1 == x2 && y1 == y2) continue

                val (left, right) = if (x1 <= x2) (x1 to y1) to (x2 to y2)
                else (x2 to y2) to (x1 to y1)

                val rise = left.second.toDouble() - right.second
                val run = left.first.toDouble() - right.first

                val slope = rise / run
                val slopeRounded = round(slope * 100_000_000) / 100_000_000
                val yIntersect = round((left.second - (slope * left.first)) * 100_000_000) / 100_000_000
                slopes[slopeRounded to yIntersect] =
                    (slopes[slopeRounded to yIntersect] ?: 1) + 1
            }
            maxPoints = max(maxPoints, slopes.map { (k,v) -> v }.max()!!)
        }
        return maxPoints
    }
}