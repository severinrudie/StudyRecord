package y2021.m02.d09

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_15_1_Knapsack2Test {
    val c = EDU_15_1_Knapsack()

    @Test
    fun tc1() {
        val profits = intArrayOf(4,5,3,7)
        val weights = intArrayOf(2,3,1,4)
        val capacity = 5
        assertEquals(10, c.solveKnapsack(profits, weights, capacity))
    }
}