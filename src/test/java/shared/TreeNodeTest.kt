package shared

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TreeNodeTest {
    @Test
    fun tc1() {
        val tn = TreeNode.from(
                listOf(1),
                listOf(2,3),
                listOf(4,5,6,7),
                listOf(8,9,10),
                listOf(11)
        )

        assertEquals(4, tn.maxWidth())
    }

    @Test
    fun tc2() {
        val tn = TreeNode.from(
                listOf(1),
                listOf(2,3),
                listOf(4,5,6,7),
                listOf(8,9,10),
                listOf(11)
        )

        assertEquals(5, tn.maxDepth())
    }

    @Test
    fun tc3() {

        val tn = TreeNode.from(
                listOf(1),
                listOf(2,3),
                listOf(4,5,6,7),
                listOf(8,9,10),
                listOf(11)
        )

        assertEquals(
                """
                |                1                
                |        2               3        
                |    4       5       6       7    
                |  8   9   10  
                | 11 
                |
                """.trimMargin()
                ,
                tn.toString()
        )
    }

    @Test
    fun tc4() {
        val tn = TreeNode.from(
                listOf(1),
                listOf(2,3),
                listOf(4,5,6,7),
                listOf(8,9,10),
                listOf(11)
        ).toList()

        val lists = listOf(
                listOf(1),
                listOf(2,3),
                listOf(4,5,6,7),
                listOf(8,9,10),
                listOf(11)
        )

        assertEquals(lists, tn)
    }
}
