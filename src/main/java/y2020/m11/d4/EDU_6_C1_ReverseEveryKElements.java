package y2020.m11.d4;

import shared.ListNode;

// O(n) time, O(1) space
public class EDU_6_C1_ReverseEveryKElements {
    public static ListNode reverse(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);

        ListNode prevTail = null;
        ListNode curr = head;
        ListNode prev = dummy;
        prev.next = head;
        ListNode next = null;

        while (curr != null) {
            prevTail = prev;
            // reverse as many as possible, up to k
            for (int i = 0; i < k; i++) {
                if (curr == null) break;
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // attach prev & next
            prevTail.next.next = curr;
            prevTail.next = prev;
            // iterate k
            for (int i = 0; i < k; i++) {
                if (curr == null) break;
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }

}
