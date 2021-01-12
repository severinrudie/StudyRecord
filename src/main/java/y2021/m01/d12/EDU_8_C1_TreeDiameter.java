package y2021.m01.d12;

import shared.TreeNode;

// O(n) time, O(n) space (recursion stack)
public class EDU_8_C1_TreeDiameter {
    static int maxDiameter = 0;

    public static int findDiameter(TreeNode root) {
        findHeight(root);
        return maxDiameter;
    }

    public static int findHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        int currDiameter = leftHeight + rightHeight + 1;
        maxDiameter = Math.max(maxDiameter, currDiameter);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
