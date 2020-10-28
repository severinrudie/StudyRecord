package y2020.m10.d28;

import shared.ListNode;

// Note that EDU has a O(n) time solution
// O(nk) time [where k is the length of the cycle], O(1) space
public class EDU_3_2_LinkedListCycleStart {
    public static ListNode findCycleStart(ListNode head) {
        int cycleLen = findCycleLength(head);

        ListNode curr = head;

        while (true) {
            ListNode runner = curr;
            for (int i = 0; i < cycleLen; i++) {
                runner = runner.next;
            }
            if (curr == runner) return curr;
            curr = curr.next;
        }
    }

    static int findCycleLength(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (fast == slow) break;
            fast = fast.next;
            if (fast == slow) break;
        }

        int len = 0;
        fast = fast.next;
        while (fast != slow) {
            len++;
            fast = fast.next;
        }
        return len;
    }
}
