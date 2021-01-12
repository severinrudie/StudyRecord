package y2021.m01.d12;

import shared.TreeNode;

// O(n) time, O(n) space (stack)
public class EDU_8_C2_MaximumPathSum {
    static int maxSum = Integer.MIN_VALUE;

    public static int findMaximumPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        recurse(root);

        return maxSum;
    }

    static int recurse(TreeNode root) {
        if (root == null) return 0;
        int left = recurse(root.left);
        int right = recurse(root.right);
        int sum = root.val + Math.max(left, right);
        maxSum = Math.max(maxSum, root.val + left + right);
        return sum;
    }
}