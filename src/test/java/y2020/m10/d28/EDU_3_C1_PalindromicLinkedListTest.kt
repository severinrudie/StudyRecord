package y2020.m10.d28

import org.junit.jupiter.api.Test
import shared.ListNode
import y2020.m10.d28.EDU_3_C1_PalindromicLinkedList.isPalindrome
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class EDU_3_C1_PalindromicLinkedListTest {
    @Test
    fun tc1() {
        assertTrue(isPalindrome(ListNode.from(1,2,3,2,1)))
    }

    @Test
    fun tc2() {
        assertTrue(isPalindrome(ListNode.from(1,2,3,3,2,1)))
    }

    @Test
    fun tc3() {
        assertFalse(isPalindrome(ListNode.from(1,2,3,2,1,1)))
    }

    @Test
    fun tc4() {
        assertFalse(isPalindrome(ListNode.from(2,1,2,3,2,1)))
    }

}