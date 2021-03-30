package y2021.m03.d30

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Pramp_FlattenADictionaryTest {

    val c = Pramp_FlattenADictionary()

    @Test
    fun tc1() {
        val input = mapOf(
            "Key1" to "1",
            "Key2" to mapOf(
                "a" to "2",
                "b" to "3",
                "c" to mapOf(
                    "d" to "3",
                    "e" to mapOf(
                        "" to "1"
                    )
                )
            )
        )

        val expect = mapOf(
            "Key1" to "1",
            "Key2.a" to "2",
            "Key2.b" to "3",
            "Key2.c.d" to "3",
            "Key2.c.e" to "1",
        )

        assertEquals(expect, c.flattenDictionary(input))
    }
}
