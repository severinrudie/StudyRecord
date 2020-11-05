package y2020.m11.d5;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

// O(n log n) time, O(n log n) space [For a balanced tree. Time and space improves with fewer leaves.  O(n) time and O(n) space for a perfectly unbalanced one]
public class EDU_8_2_FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int target) {
        List<List<Integer>> solutions = new ArrayList<>();
        findPaths(root, target, new ArrayList<>(), solutions);
        return solutions;
    }

    static void findPaths(
            TreeNode curr,
            int target,
            List<Integer> currPath,
            List<List<Integer>> allSolutions
    ) {
        if (curr == null) return;
        currPath.add(curr.val);
        if (target - curr.val == 0) allSolutions.add(new ArrayList<>(currPath));

        findPaths(curr.left, target - curr.val, currPath, allSolutions);
        findPaths(curr.right, target - curr.val, currPath, allSolutions);

        currPath.remove(currPath.size() - 1);
    }
}
