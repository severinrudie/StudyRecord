package y2021.m03.d24

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import y2021.m03.d24.Pramp_ShortestCellPath.Pos

internal class Pramp_ShortestCellPathTest {
    
    val c = Pramp_ShortestCellPath()
    
    @Test
    fun tc1() {
        val grid = arrayOf(
            intArrayOf(1,1,1,1,),
            intArrayOf(0,0,0,1,),
            intArrayOf(1,1,1,1,),
        )
        val expect = 8
        val start = Pos(0,0)
        val target = Pos(2,0)

        assertEquals(expect, c.shortestCellPath(grid, start, target))
    }
    
}