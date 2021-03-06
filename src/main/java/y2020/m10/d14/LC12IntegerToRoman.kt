package y2020.m10.d14

import java.lang.StringBuilder

// Medium, 55%
// O(n)
object LC12IntegerToRoman {
    fun intToRoman(num: Int): String {
        var num = num
        val result = StringBuilder()

        Numeral.values().forEach {
            while (num >= it.value) {
                result.append(it.name)
                num -= it.value
            }
        }
        return result.toString()
    }

    enum class Numeral(val value: Int) {
        M(1000),
        CM(900),
        D(500),
        CD(400),
        C(100),
        XC(90),
        L(50),
        XL(40),
        X(10),
        IX(9),
        V(5),
        IV(4),
        I(1)
    }
}
