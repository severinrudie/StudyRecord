package y2020.m10.d28;

import shared.ListNode;

// O(n) time, O(1) space
public class EDU_3_4_MiddleOfLinkedList {
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) fast = fast.next;
        }

        return slow;
    }
}
