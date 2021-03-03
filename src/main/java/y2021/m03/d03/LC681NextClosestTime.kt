package y2021.m03.d03

class LC681NextClosestTime {
    fun nextClosestTime(time: String): String {
        val result = listOf(time[0], time[1], time[3], time[4])
            .map { Character.getNumericValue(it) }
            .toMutableList()
        val sorted = result.sorted()
        val lowest = sorted[0]

        fun List<Int>.toVal() = "${this[0]}${this[1]}:${this[2]}${this[3]}"

        for (num in sorted) {
            if (num in result[3] + 1 .. 9) {
                result[3] = num
                return result.toVal()
            }
        }
        result[3] = lowest

        for (num in sorted) {
            if (num in result[2] + 1 .. 5) {
                result[2] = num
                return result.toVal()
            }
        }
        result[2] = lowest

        for (num in sorted) {
            if (
                (result[0] < 2 && num in result[1] + 1 .. 9) ||
                        num in result[1] + 1 .. 3
            ) {
                result[1] = num
                return result.toVal()
            }
        }
        result[1] = lowest

        for (num in sorted) {
            if (num in result[0] + 1 .. 2) {
                result[0] = num
                return result.toVal()
            }
        }
        result[0] = lowest

        return result.toVal()
    }
}
