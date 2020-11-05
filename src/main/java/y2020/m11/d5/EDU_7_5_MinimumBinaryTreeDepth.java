package y2020.m11.d5;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// O(n) time, O(n) space
// If our 'tree' is actually a cyclical graph, this will spin
public class EDU_7_5_MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currDepth = 0;

        while (!queue.isEmpty()) {
            int rowLen = queue.size();
            currDepth++;
            for (int i = 0; i < rowLen; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return currDepth;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return -1;
    }

}
