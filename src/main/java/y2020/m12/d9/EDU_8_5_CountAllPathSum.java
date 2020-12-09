package y2020.m12.d9;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class EDU_8_5_CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {
        return countPaths(root, S, new ArrayList<>(), 0);
    }

    static int countPaths(TreeNode root, int S, List<Integer> prev, int prevSum) {
        if (root == null) return 0;

        int currSum = prevSum + root.val;

        prev = new ArrayList<>(prev);
        while (prev.size() > 0 && currSum > S) {
            int removed = prev.remove(0);
            currSum -= removed;
        }


        int curr = currSum == S ? 1 : 0;
        prev.add(root.val);

        return curr + countPaths(root.left, S, prev, currSum) + countPaths(root.right, S, prev, currSum);
    }
}
