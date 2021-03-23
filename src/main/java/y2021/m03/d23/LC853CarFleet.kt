package y2021.m03.d23

import kotlin.math.*

class LC853CarFleet {

    // O(n log n) time, O(n) space
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        return position.zip(speed)
            .sortedByDescending { it.first }
            .map { (pos, spd) -> // to arrival time
                (target - pos).toDouble() / spd
            }.fold (0 to 0.0) { (fleets, lastTime), time ->
                if (time > lastTime) {
                    fleets + 1 to time
                } else {
                    fleets to lastTime
                }
            }.first
    }
}
