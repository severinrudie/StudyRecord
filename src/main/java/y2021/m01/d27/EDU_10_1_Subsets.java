package y2021.m01.d27;

import java.util.ArrayList;
import java.util.List;

public class EDU_10_1_Subsets {
    // O(n 2^n) time, O(n 2^n)
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSets = new ArrayList<>();
            for (List<Integer> list : subsets) {
                List<Integer> copy = new ArrayList<>(list);
                copy.add(num);
                newSets.add(copy);
            }
            subsets.addAll(newSets);
        }

        return subsets;
    }
}
