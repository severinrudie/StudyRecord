package y2020.m11.d5;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// O(n) time, O(d + w) space [d == max depth of tree, w == max width of tree] [effectively O(n). Width can never be > n/2, height will never be > n [in an unbalanced tree/LL]]
public class EDU_7_4_LevelAveragesInBinaryTree {
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int rowLen = queue.size();
            int sum = 0;

            for (int i = 0; i < rowLen; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add((double) sum / rowLen);
        }

        return result;
    }
}
