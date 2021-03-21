package y2021.m03.d21

import java.util.*

class LC731MyCalendar2 {
    class MyCalendarTwo() {

        val tm = TreeMap<Int, Int>()

        // O(n) time, O(1) space [per call]
        fun book(start: Int, end: Int): Boolean {
            tm[start] = (tm[start] ?: 0) + 1
            tm[end] = (tm[end] ?: 0) - 1

            var total = 0
            for ((k,v) in tm.subMap(0, end)) {
                total += v
                if (total > 2) {
                    tm[start] = tm[start]!! - 1
                    tm[end] = tm[end]!! + 1
                    return false
                }
            }
            return true
        }
    }
}
