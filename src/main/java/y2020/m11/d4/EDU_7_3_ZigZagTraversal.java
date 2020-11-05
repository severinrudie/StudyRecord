package y2020.m11.d4;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// O(n) time, O(n) space
public class EDU_7_3_ZigZagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean traverseRight = true;

        while (!queue.isEmpty()) {
            int rowLen = queue.size();
            List<Integer> nextRow = new LinkedList<>();
            List<TreeNode> nodes = new LinkedList<>();

            for (int i = 0; i < rowLen; i++) {
                TreeNode node = queue.poll();
                nodes.add(node);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            for (int i = 0; i < rowLen; i++) {
                int j = i;
                if (!traverseRight) j = rowLen - 1 - i;
                nextRow.add(nodes.get(j).val);
            }
            result.add(nextRow);
            traverseRight = !traverseRight;
        }

        return result;
    }
}
