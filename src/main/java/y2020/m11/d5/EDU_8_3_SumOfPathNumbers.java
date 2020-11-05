package y2020.m11.d5;

import shared.TreeNode;

// O(n) time, O(n) space for a perfectly unbalanced tree, down to O(log n) space for a perfectly balanced one
public class EDU_8_3_SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        return sumOfAllPaths(root, 0);
    }

    static int sumOfAllPaths(TreeNode curr, int currTotal) {
        if (curr == null) return 0;
        currTotal = currTotal * 10 + curr.val;
        if (curr.left == null && curr.right == null) return currTotal;
        return sumOfAllPaths(curr.left, currTotal) + sumOfAllPaths(curr.right, currTotal);
    }
}
