package y2021.m03.d22

import kotlin.math.max
import kotlin.math.min

class LC57InsertInterval {
    // O(n) time, O(n) space
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        // insert range into list at i
        // for i..end, find rightmost value where start <= i.end
        // merge i..rightmost into i.start + max(i.end, new.end)
        // for i downTo 0, find leftmost value where end >= i.start
        // merge
        // remove everything else



        // [1,2],[3,5],[6,7],[8,10],[12,16] // 4,8
        // [1,2],[3,5],[4,8],[6,7],[8,10],[12,16]
        //                i           r
        //         l
        // newInterval = start: min(l.start, i.start), end: max(r.end, i.end)
        //    3,10
        // [1,2],[3,10],[12,16]

        var insertionPoint = intervals.toList().binarySearchBy(newInterval[0]) { it[0] }
        if (insertionPoint < 0) insertionPoint = -insertionPoint - 1

        var r = -1
        for (i in intervals.lastIndex downTo insertionPoint) {
            if (intervals[i][0] <= newInterval[1]) {
                r = i
                break
            }
        }

        var l = -1
        for (i in 0 until insertionPoint) {
            if (intervals[i][1] >= newInterval[0]) {
                l = i
                break
            }
        }

        val mergeLeft = intervals.getOrNull(l) ?: intArrayOf(newInterval[0], newInterval[1])
        val mergeRight = intervals.getOrNull(r) ?: intArrayOf(newInterval[0], newInterval[1])

        val merged = intArrayOf(
            min(newInterval[0], min(mergeLeft[0], mergeRight[0])),
            max(newInterval[1], max(mergeLeft[1], mergeRight[1]))
        )

        val head = when {
            l == -1 -> intervals.slice(0 until insertionPoint)
            l == 0 -> emptyList()
            else -> intervals.slice(0 until insertionPoint - 1)
        }
        val tail = when {
            r == -1 -> intervals.slice(insertionPoint..intervals.lastIndex)
            r == intervals.lastIndex -> emptyList()
            else -> intervals.slice(r + 1..intervals.lastIndex)
        }

        return (head + listOf(merged) + tail).toTypedArray()
    }
}