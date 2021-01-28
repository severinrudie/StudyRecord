package y2021.m01.d28;

import java.util.ArrayList;
import java.util.List;

public class EDU_10_3_Permutations {
    // O(n n!) time, O(n n!) space
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList());

        for (int num : nums) {
            List<List<Integer>> newSublist = new ArrayList<>();
            for (List<Integer> sublist : result) {
                for (int i = 0; i <= sublist.size(); i++) {
                    List<Integer> newList = new ArrayList<>(sublist);
                    newList.add(i, num);
                    newSublist.add(newList);
                }
            }
            result = newSublist;
        }

        return result;
    }
}
