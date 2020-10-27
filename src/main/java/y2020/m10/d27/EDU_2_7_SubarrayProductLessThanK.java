package y2020.m10.d27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// O(n^3) time, O(n^2) space
public class EDU_2_7_SubarrayProductLessThanK {
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        if (arr.length == 0) return subarrays;

        for (int left = 0; left < arr.length; left++) {
            int currTotal = arr[left];

            for (int right = left; right < arr.length; right++) {
                if (right != left) currTotal *= arr[right];

                if (currTotal >= target) break;

                List<Integer> sublist = Arrays.stream(Arrays.copyOfRange(arr, left, right + 1))
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new));

                subarrays.add(sublist);
            }
        }

        return subarrays;
    }
}
