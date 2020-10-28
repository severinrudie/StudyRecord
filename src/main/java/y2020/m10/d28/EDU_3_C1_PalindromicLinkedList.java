package y2020.m10.d28;

import shared.ListNode;

// O(n) time, O(1) space
public class EDU_3_C1_PalindromicLinkedList {
    public static boolean isPalindrome(ListNode head) {
        int len = 1;
        ListNode node = head;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        int midpoint = (len - 1) / 2;

        int distance = 0;
        node = head;
        for (int i = 0; i <= midpoint; i++) {
            if (!assertFromEnd(node, distance)) return false;
            node = node.next;
            distance++;
        }
        return true;
    }

    static boolean assertFromEnd(ListNode node, int fromEnd) {
        ListNode fast = node;
        ListNode slow = node;

        for (int i = 0; i < fromEnd; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.val == node.val;
    }
}
