package y2020.oct14th

// Hard, 27% acceptance
// O(n^2)
object LC10RegularExpressionMatching {
    fun isMatch(s: String, p: String): Boolean {
        if (s.isEmpty() && p.isEmpty()) return true
        if (p.isEmpty() && !s.isEmpty()) return false

        return when (val symbol = getLeadSymbol(p)) {
            is Symbol.None -> none(s)
            is Symbol.Star -> star(s, p, symbol)
            is Symbol.Dot -> dot(s, p)
            is Symbol.HangingStar -> false
            is Symbol.Character -> character(s, p, symbol)
        }
    }

    fun none(s: String) = when {
        s.isEmpty() -> true
        else -> false
    }

    fun star(s: String, p: String, star: Symbol.Star): Boolean {
        val c = star.c
        return when {
            s.isEmpty() -> isMatch(s, p.drop(2))
            c == s.first() || c == '.' -> isMatch(s.drop(1), p) || isMatch(s, p.drop(2))
            else -> isMatch(s, p.drop(2))
        }
    }

    fun dot(s: String, p: String): Boolean {
        return if (s.isEmpty()) false
        else isMatch(s.drop(1), p.drop(1))
    }

    fun character(s: String, p: String, character: Symbol.Character): Boolean {
        return when {
            s.isEmpty() -> false
            s.first() == character.c -> isMatch(s.drop(1), p.drop(1))
            else -> false
        }
    }

    fun getLeadSymbol(p: String): Symbol {
        return when {
            p.isEmpty() -> Symbol.None
            p.length >= 2 && p[1] == '*' -> Symbol.Star(p.first())
            p.first() == '.' -> Symbol.Dot
            p.first() == '*' -> Symbol.HangingStar
            else -> Symbol.Character(p.first())
        }
    }

    sealed class Symbol {
        object Dot : Symbol()
        object HangingStar : Symbol()
        object None: Symbol()
        data class Star(val c: Char) : Symbol()
        data class Character(val c: Char) : Symbol()
    }
}
