package y2020.m11.d3;

import shared.ListNode;

// O(n) time, O(1) space
public class EDU_6_3_ReverseEveryKElements {
    public static ListNode reverse(ListNode head, int k) {
        ListNode last = new ListNode(-1);
        last.next = head;
        ListNode dummy = last;

        while (last != null) {
            ListNode nextHead = last.next;
            for (int i = 0; i < k; i++) {
                if (nextHead == null) break;
                nextHead = nextHead.next;
            }
            last = reverse(last, last.next, nextHead, last, last.next);
        }

        return dummy.next;
    }

    static ListNode reverse(ListNode lastTail,
                            ListNode newTail,
                            ListNode nextHead,
                            ListNode prev,
                            ListNode curr) {
        if (newTail == null) return null;
        if (curr.next == null) {
            curr.next = prev;
            lastTail.next = curr;
            newTail.next = null;
            return null;
        }
        if (curr.next == nextHead) {
            curr.next = prev;
            lastTail.next = curr;
            newTail.next = nextHead;
            return newTail;
        }

        ListNode next = curr.next;
        curr.next = prev;
        return reverse(lastTail, newTail, nextHead, curr, next);
    }
}
