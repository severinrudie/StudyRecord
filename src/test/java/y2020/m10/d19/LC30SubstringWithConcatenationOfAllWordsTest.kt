package y2020.m10.d19

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LC30SubstringWithConcatenationOfAllWordsTest {

    @Test
    fun tc1() {


        println(listOf("hi", "there", "hi").groupingBy { it }.eachCount())

        assertEquals(
                listOf("hi", "there", "hi").groupingBy { it }.eachCount(),
                listOf("hi", "there", "hi").groupingBy { it }.eachCount()
        )
    }


}