package y2020.m11.d5;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// O(n) time, O(n) space
public class EDU_7_7_ConnectLevelOrderSiblings {
    public static void connect(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int rowLen = queue.size();
            TreeNode prev = null;

            for (int i = 0; i < rowLen; i++) {
                TreeNode node = queue.remove();
                if (prev != null) {
                    prev.left = node;
                    prev.right = null;
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (i == rowLen - 1) {
                    node.left = null;
                    node.right = null;
                }
                prev = node;
            }
        }
    }
}
