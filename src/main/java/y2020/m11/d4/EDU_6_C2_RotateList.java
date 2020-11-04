package y2020.m11.d4;

import shared.ListNode;

// O(n) time, O(1) space
public class EDU_6_C2_RotateList {
    public static ListNode rotate(ListNode head, int rotations) {
        if (head == null || rotations == 0) return head;

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < rotations; i++) {
            if (fast.next == null) fast = head;
            else fast = fast.next;
        }
        while (fast.next != null) {
            if (slow.next == null) slow = head;
            else slow = slow.next;

            fast = fast.next;
        }

        // attach last node to first
        fast.next = head;
        // make pivot head
        if (slow.next != null) head = slow.next;
        // set pivot - 1 .next to null
        slow.next = null;

        return head;
    }
}
