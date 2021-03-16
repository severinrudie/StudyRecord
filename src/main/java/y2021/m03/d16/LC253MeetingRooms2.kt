package y2021.m03.d16

import java.util.*
import kotlin.math.max

class LC253MeetingRooms2 {
    class Solution {

        fun minMeetingRooms(intervals: Array<IntArray>): Int {
            if (intervals.isEmpty()) return 0
            if (intervals.size == 1) return 1
            // find the max overlap between all intervals

            // grab every interval that overlaps
            // try to expand group
            // when any does not overlap all, drop it out of group
            // count

            // sorting, heap

            // overlap cases (for any two intervals)
            // full overlap:: next start >= old start && next end <= old end
            // partial front:: next start < old start && next end in old start..old end
            // partial back:: next start in old start until old end && next end > old end

            // for existing list
            // maintain narrowest overlap (largest start, smallest end)
            // two heaps?
            // check next interval
            // if fits any of above cases, add to list
            // update narrowest
            // update best overlap
            // else, drop interval with lowest end time
            // update narrowest
            val intervals = intervals.map { it[0]..it[1] }.sortedBy { it.start }

            var i = 1
            // maxheap of start
            val biggestStart = PriorityQueue<IntRange> { a,b -> b.start - a.start }
            // minheap of end
            val smallestEnd = PriorityQueue<IntRange> { a,b -> a.endInclusive - b.endInclusive }
            biggestStart += intervals[0]
            smallestEnd += intervals[0]

            var bestOverlap = 1
            while (i < intervals.size) {
                val next = intervals[i]
                lateinit var narrowest: IntRange

                fun fullOverlap() = next.start >= narrowest.start &&
                        next.endInclusive <= narrowest.endInclusive
                fun startOverlap() = next.start < narrowest.start &&
                        next.endInclusive in narrowest.start..narrowest.endInclusive
                fun endOverlap() = next.start in narrowest.start until narrowest.endInclusive &&
                        next.endInclusive > narrowest.endInclusive

                fun overlaps(): Boolean {
                    narrowest = biggestStart.peek().start..smallestEnd.peek().endInclusive
                    return fullOverlap() || startOverlap() || endOverlap()
                }

                while (biggestStart.isNotEmpty() && !overlaps()) {
                    val toRemove = smallestEnd.poll()
                    biggestStart -= toRemove
                }
                biggestStart += next
                smallestEnd += next
                bestOverlap = max(bestOverlap, biggestStart.size)
                i++
            }
            return bestOverlap
        }
    }
}