package y2020.m11.d5;

import shared.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EDU_8_4_PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        List<Integer> list = Arrays.stream(sequence).boxed().collect(Collectors.toList());
        return findPath(root, list);
    }

    static boolean findPath(TreeNode curr, List<Integer> sequence) {
        if (curr == null) return false;
        if (curr.left == null && curr.right == null) {
            return sequence.size() == 1 && sequence.get(0) == curr.val;
        }
        if (sequence.size() == 0) return false;
        int sequenceStart = sequence.get(0);
        if (sequenceStart != curr.val) return false;
        sequence.remove(0);
        boolean didFind = findPath(curr.left, sequence) || findPath(curr.right, sequence);
        sequence.add(sequenceStart);
        return didFind;
    }

}
