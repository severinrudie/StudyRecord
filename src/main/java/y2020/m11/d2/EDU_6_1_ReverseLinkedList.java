package y2020.m11.d2;

import shared.ListNode;

public class EDU_6_1_ReverseLinkedList {
    public static ListNode reverse(ListNode head) {
        return reverse(null, head);
    }

    // Eventually blows up the stack.  If in Kt, use tailrec
    static ListNode reverse(ListNode prev, ListNode curr) {
        if (curr == null) return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return reverse(curr, next);
    }
}
