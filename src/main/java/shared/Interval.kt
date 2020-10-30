package shared;

// This is just a crappy IntRange, but it's used by the Educative course
data class Interval(@JvmField val start: Int, @JvmField val end: Int) {
    override fun toString(): String = "$start-$end"

    companion object {
        fun listOf(vararg ranges: IntRange): List<Interval> = ranges.map { Interval(it.first, it.last) }
    }
}

fun Interval(range: IntRange) = Interval(range.first, range.last)

// Interval with a different name...
data class Meeting(@JvmField val start: Int, @JvmField val end: Int) {
    override fun toString(): String = "$start-$end"

    companion object {
        fun listOf(vararg ranges: IntRange): List<Interval> = ranges.map { Interval(it.first, it.last) }
    }
}

fun Meeting(range: IntRange) = Interval(range.first, range.last)
