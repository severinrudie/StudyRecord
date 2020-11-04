package y2020.m11.d4;

import shared.TreeNode;

import java.util.*;

// O(n) time, O(n) space [where w is the max width of the tree]
public class EDU_7_1_LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int rowSize = queue.size();
            List<Integer> rowVals = new ArrayList<>();

            for (int i = 0; i < rowSize; i++) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                rowVals.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (rowVals.size() != 0) result.add(rowVals);
        }

        return result;
    }
}
