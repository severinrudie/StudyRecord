import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ScratchTest {

    @Test
    fun t() {

        println(Scratch.t().takeWhile { it < 100 }.toList())
    }


}