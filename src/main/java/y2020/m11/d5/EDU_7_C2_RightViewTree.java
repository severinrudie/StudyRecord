package y2020.m11.d5;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// O(n) time, O(n) space
public class EDU_7_C2_RightViewTree {
    public static List<TreeNode> traverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int rowLen = queue.size();
            for (int i = 0; i < rowLen; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (i == rowLen - 1) result.add(node);
            }
        }

        return result;
    }

}
