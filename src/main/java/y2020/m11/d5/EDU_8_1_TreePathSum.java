package y2020.m11.d5;

import shared.TreeNode;

// O(n) time, O(n) space
public class EDU_8_1_TreePathSum {
    public static boolean hasPath(TreeNode root, int sum) {
        return hasPath(root, sum, 0);
    }

    static boolean hasPath(TreeNode curr, int target, int total) {
        if (curr == null) return false;
        int newSum = total + curr.val;
        if (
                newSum == target &&
                        curr.left == null &&
                        curr.right == null
        ) return true;

        return hasPath(curr.left, target, newSum) || hasPath(curr.right, target, newSum);
    }
}
