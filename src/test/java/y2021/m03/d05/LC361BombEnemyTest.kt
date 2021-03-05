package y2021.m03.d05

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LC361BombEnemyTest {

    val c = LC361BombEnemy()

    @Test
    fun tc1() {
        val input = arrayOf(charArrayOf('0','E','0','0'),charArrayOf('E','0','W','E'),charArrayOf('0','E','0','0'))
        val expect = 3

        assertEquals(expect, c.maxKilledEnemies(input))
    }
    
    @Test
    fun tc2() {
        val input = arrayOf(charArrayOf('W'),charArrayOf('E'),charArrayOf('W'),charArrayOf('0'),charArrayOf('E'))
        val expect = 1

        assertEquals(expect, c.maxKilledEnemies(input))
    }

}