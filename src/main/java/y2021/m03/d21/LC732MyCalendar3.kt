package y2021.m03.d21

import java.util.*
import kotlin.math.max

class LC732MyCalendar3 {
    val tm = TreeMap<Int, Int>()
    var globalMax = 0

    init {
        tm[0] = 0
    }

    // O(n log n) time, O(1) space [per call]
    fun book(start: Int, end: Int): Int {
        tm[start] = tm.floorEntry(start)!!.value
        tm[end] = tm.floorEntry(end)!!.value
        for ((k,v) in tm.subMap(start, end)) {
            val inc = v + 1
            globalMax = max(globalMax, inc)
            tm[k] = inc
        }

        return globalMax
    }
}