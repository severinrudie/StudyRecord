package y2020.m11.d5;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// O(n) time, O(n) space
public class EDU_7_C1_ConnectAllSiblings {
    public static void connect(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode prev = null;

        while (!queue.isEmpty()) {
            TreeNode next = queue.remove();
            if (prev != null) {
                prev.left = next;
                prev.right = null;
            }
            if (next.left != null) queue.add(next.left);
            if (next.right != null) queue.add(next.right);
            prev = next;
        }
    }
}
