package y2021.m02.d02

import java.util.*


class EDU_13_3_KClosestPointsToOrigin {

    data class Point(val x: Int, val y: Int) {
        fun distFromOrigin(): Int {
            // ignoring sqrt
            return x * x + y * y
        }
    }

    // O(n log k) time, O(k) space
    fun findClosestPoints(points: List<Point>, k: Int): List<Point> {
        val maxHeap = PriorityQueue<Point> { a,b -> b.distFromOrigin() - a.distFromOrigin() }

        for (point in points) {
            if (maxHeap.size < k) {
                maxHeap.offer(point)
            } else if (maxHeap.peek().distFromOrigin() > point.distFromOrigin()) {
                maxHeap.poll()
                maxHeap.offer(point)
            }
        }
        return maxHeap.toList()
    }
}
