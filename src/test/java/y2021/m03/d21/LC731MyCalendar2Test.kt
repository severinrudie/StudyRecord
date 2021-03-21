package y2021.m03.d21

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class LC731MyCalendar2Test {

    val tm = TreeMap<Int, Int>()

    @Test
    fun tc1() {
        tm[2] = 2
        tm[3] = 3
        println(tm.subMap(1, 4))
    }

}