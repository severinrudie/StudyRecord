package y2020.m10.d16

import java.util.ArrayDeque

// Easy, 39%
// O(n) time, O(n) space
object LC20ValidParentheses {
    fun isValid(s: String): Boolean {

        val stack = ArrayDeque<Char>()

        s.forEach { c ->
            if (c in pairs.values) {
                stack.addFirst(c)
            } else if (c in pairs.keys) {
                if (stack.pollFirst() == pairs[c]) {
                    // continue
                } else {
                    return false
                }
            } else {
                throw IllegalArgumentException()
            }
        }
        return stack.isEmpty()
    }

    val pairs = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
    )
}

// Easy, 39%
// O(n) time, O(n) space
// Try 2 immediately after 1.  Slight optimization
object LC20ValidParenthesesTry2 {
    fun isValid(s: String): Boolean {

        val stack = LightLinkedList<Char>()

        s.forEach { c ->
            if (c.isOpener()) {
                stack.add(c)
            } else if (stack.remove() == c.getMatchedOpener()) {
                // continue
            } else {
                return false
            }
        }
        return stack.isEmpty()
    }

    fun Char.isOpener() = when (this) {
        '(', '{', '[' -> true
        else -> false
    }

    fun Char.getMatchedOpener() = when (this) {
        ')' -> '('
        '}' -> '{'
        ']' -> '['
        else -> throw IllegalArgumentException()
    }
}

// O(n) time, O(n) space (micro-optimized)
class LightLinkedList<T> {
    private class Node<T>(val value: T, var next: Node<T>? = null)

    private var head: Node<T>? = null

    fun add(value: T) {
        val new = Node(value)
        new.next = head
        head = new
    }

    fun remove(): T? {
        return if (head == null) null
        else {
            val value = head?.value
            head = head?.next
            value
        }
    }

    fun isEmpty() = head == null
}