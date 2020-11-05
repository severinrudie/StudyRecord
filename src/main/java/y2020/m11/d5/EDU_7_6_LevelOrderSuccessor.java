package y2020.m11.d5;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// O(n) time, O(n) space
public class EDU_7_6_LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean lastWasTarget = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (lastWasTarget) return node;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (node.val == key) lastWasTarget = true;
        }

        return null;
    }
}
