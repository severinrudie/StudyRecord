package y2021.m03.d05

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import y2021.m03.d05.LC1057CampusBikes.Pairing
import java.util.*

internal class LC1057CampusBikesTest {

    val c = LC1057CampusBikes()

    @Test
    fun tc1() {
        val queue = PriorityQueue<Pairing> { a, b ->
            when {
                a.distance != b.distance -> a.distance - b.distance
                a.workerIndex != b.workerIndex -> a.workerIndex - b.workerIndex
                else -> a.bikeIndex - b.bikeIndex
            }
        }

        val orderedInputs = listOf(
            Pairing(distance = 0, workerIndex = 0, bikeIndex = 1),
            Pairing(distance = 0, workerIndex = 1, bikeIndex = 0),
            Pairing(distance = 0, workerIndex = 1, bikeIndex = 1),
            Pairing(distance = 1, workerIndex = 0, bikeIndex = 1),
            Pairing(distance = 1, workerIndex = 1, bikeIndex = 0),
            Pairing(distance = 1, workerIndex = 1, bikeIndex = 1)
        )

        orderedInputs.forEach { queue += it }

        for (i in orderedInputs.indices) {
            assertEquals(queue.poll(), orderedInputs[i])
        }
    }

    @Test
    fun tc2() {
        val workers = arrayOf(intArrayOf(0,0),intArrayOf(2,1))
        val bikes = arrayOf(intArrayOf(1,2),intArrayOf(3,3))
        val expect = intArrayOf(1,0)

        assertEquals(expect.toList(), c.assignBikes(workers, bikes).toList())
    }

    @Test
    fun tc3() {
        val workers = arrayOf(intArrayOf(0,0),intArrayOf(1,1),intArrayOf(2,0))
        val bikes = arrayOf(intArrayOf(1,0),intArrayOf(2,2),intArrayOf(2,1))
        val expect = intArrayOf(0,2,1)

        assertEquals(expect.toList(), c.assignBikes(workers, bikes).toList())
    }
}
