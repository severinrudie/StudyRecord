package y2020.m11.d4;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// O(n) time, O(n) space
public class EDU_7_2_ReverseOrderLevelTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int rowSize = queue.size();
            List<Integer> nextRow = new LinkedList<>();

            for (int i = 0; i < rowSize; i++) {
                TreeNode node = queue.poll();
                nextRow.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(0, nextRow);
        }

        return result;
    }
}
