package y2021.m03.d21

import java.util.*

class LC729MyCalendar1 {
    private val cal = TreeSet<IntRange> { a, b -> a.start - b.start }

    // O(log n) time, O(1) space [per call]
    fun book(start: Int, end: Int): Boolean {
        val floor = cal.floor(start..end)
        val ceil = cal.ceiling(start..end)

        val exists = floor == start..end || ceil == start..end
        val conflictDown = floor != null && floor.endInclusive > start
        val conflictUp = ceil != null && ceil.start < end

        return if (
            exists ||
            conflictDown ||
            conflictUp
        ) {
            false
        } else {
            cal.add(start..end)
            true
        }
    }
}