package y2021.m03.d28

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class IK_CoinCombinationsTest {

    val c = IK_CoinCombinations()

    @Test
    fun tc1() {
        val coins = listOf(1,2,5)
        val target = 3
        val expect = 2

        assertEquals(expect, c.coins(coins, target))
    }


}