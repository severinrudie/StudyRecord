package y2020.m11.d2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// O(n + k) time, O(n) space
public class EDU_5_C3_FirstKMissingPositive {
    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int j = 1;
        while (missingNumbers.size() < k) {
            if (!numSet.contains(j)) missingNumbers.add(j);
            j++;
        }

        return missingNumbers;
    }
}
