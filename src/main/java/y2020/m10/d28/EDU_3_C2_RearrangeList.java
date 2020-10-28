package y2020.m10.d28;

import shared.ListNode;

// O(n) time, O(1) space
public class EDU_3_C2_RearrangeList {
    public static void reorder(ListNode head) {
        int len = getLen(head);
        int mid = (len - 1) / 2;
        ListNode midpoint = head;
        for (int i = 0; i < mid; i++) {
            midpoint = midpoint.next;
        }

        ListNode newTail = midpoint.next;
        ListNode secondHead = reverse(newTail);
        newTail.next = null;
        midpoint.next = null;

        ListNode n1 = head;
        ListNode n2 = secondHead;
        while (n1 != null && n2 != null) {
            ListNode n1Next = n1.next;
            ListNode n2Next = n2.next;

            n1.next = n2;
            n2.next = n1Next;

            n1 = n1Next;
            n2 = n2Next;
        }
    }

    static int getLen(ListNode node) {
        int len = 1;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    static ListNode reverse(ListNode prev) {
        ListNode curr = prev.next;
        if (curr == null) return prev;

        ListNode newHead = reverse(curr);
        curr.next = prev;
        return newHead;
    }
}
