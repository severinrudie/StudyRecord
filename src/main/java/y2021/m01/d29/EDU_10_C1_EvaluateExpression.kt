package y2021.m01.d29

import java.lang.IllegalArgumentException
import java.lang.Integer.parseInt
import java.util.ArrayList


class EDU_10_C1_EvaluateExpression {

    val mem = mutableMapOf<String, List<Int>>()

    // O(n 2^n) time, O(n 2^n) space
    fun diffWaysToEvaluateExpression(input: String): List<Int> {
        mem[input]?.let { memoized -> return memoized }

        val result = mutableListOf<Int>()
        if (input.none { it.isOperator() }) {
            result += parseInt(input)
            return result
        }

        for (i in input.indices) {
            if (input[i].isOperator()) {
                val pre = diffWaysToEvaluateExpression(input.substring(0, i))
                val post = diffWaysToEvaluateExpression(input.substring(i + 1, input.length))

                for (preNum in pre) {
                    for (postNum in post) {
                        result += when (input[i]) {
                            '+' -> preNum + postNum
                            '-' -> preNum - postNum
                            '*' -> preNum * postNum
                            else -> throw IllegalArgumentException()
                        }
                    }
                }
            }
        }

        mem[input] = result

        return result
    }

    fun Char.isOperator() = this == '+' || this == '-' || this == '*'
}
