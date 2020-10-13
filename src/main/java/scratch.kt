import java.lang.Integer.max
import kotlin.math.abs

object Scratch {
fun t() = generateSequence(listOf(0)) { t -> listOf(t.last() + 3, t.last() + 3 + 2) }
        .flatten()





    fun x() {

        (0 until 5).map { listOf(it) }
                .flatten()


        val diagonalOffset = 5
        val columnOffset = 5

        abs(5)


        generateSequence(listOf(0)) {
            listOf(it.last() + diagonalOffset, it.last() + columnOffset)
        }
            .flatten()
    }
}
