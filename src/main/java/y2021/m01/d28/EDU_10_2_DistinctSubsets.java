package y2021.m01.d28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EDU_10_2_DistinctSubsets {
    // O(n 2^n) time, O(n 2^n) space
    public static List<List<Integer>> findSubsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        List<List<Integer>> lastSubset = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<List<Integer>> newSets = new ArrayList<>();
            List<List<Integer>> baseSets;
            if (i > 0 && nums[i] == nums[i - 1]) {
                baseSets = lastSubset;
            } else {
                baseSets = subsets;
            }

            for (List<Integer> l : baseSets) {
                List<Integer> copy = new ArrayList<>(l);
                copy.add(num);
                newSets.add(copy);
            }
            subsets.addAll(newSets);
            lastSubset = newSets;
        }

        return subsets;
    }
}
