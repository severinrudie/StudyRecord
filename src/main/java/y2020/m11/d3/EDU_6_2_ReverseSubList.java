package y2020.m11.d3;

import shared.ListNode;

// O(n) time, O(1) space
public class EDU_6_2_ReverseSubList {
    public static ListNode reverse(ListNode head, int p, int q) {
        ListNode before;
        if (p == 1) before = null;
        else before = iterate(head, p - 2);
        ListNode after = iterate(head, q);

        ListNode newTail = before != null ? before.next : null;
        ListNode newHead = iterate(head, q - 1);
        reverse(null, newTail, q - p);

        if (before != null) before.next = newHead;
        if (after != null && newTail != null) newTail.next = after;

        return head;
    }


    static ListNode iterate(ListNode head, int distance) {
        if (distance == 0) return head;
        if (head == null) return head;
        return iterate(head.next, distance - 1);
    }

    static ListNode reverse(ListNode prev, ListNode curr, int distance) {
        if (curr == null) return curr;
        ListNode next = curr.next;
        curr.next = prev;
        if (distance == 0) return curr;
        return reverse(curr, next, distance - 1);
    }
}
