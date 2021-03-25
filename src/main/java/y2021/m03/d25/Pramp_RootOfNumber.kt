package y2021.m03.d25

import java.lang.Math.pow
import kotlin.math.abs

class Pramp_RootOfNumber {
    // https://www.pramp.com/challenge/jKoA5GAVy9Sr9jGBjzN4

    // O(log n) time, O(1) space
    fun root(target: Double, exp: Double): Double {
        var floor = 1.0
        var ceiling = target
        while (true) {
            val root = (ceiling - floor) / 2 + floor

            val result = pow(root, exp)

            if (result.isWithin(target, .001)) { //come back
                return root
            } else if (result > target) {
                ceiling = root
            } else {
                floor = root
            }
        }
    }

    fun Double.isWithin(other: Double, margin: Double): Boolean {
        return abs(this - other) < margin
    }
}