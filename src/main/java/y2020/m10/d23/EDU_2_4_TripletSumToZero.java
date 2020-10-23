package y2020.m10.d23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(n^2) time, O(n) space
// Only handles lists w/o duplicates.  To handle dupes, it would have to skip them
public class EDU_2_4_TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 3; i++) {
            int start = i + 1;
            int end = arr.length - 1;

            while (start < end) {
                int total = arr[i] + arr[start] + arr[end];
                if (total == 0) {
                    triplets.add(Arrays.asList(arr[i], arr[start], arr[end]));
                    start++;
                    end--;
                } else if (total > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return triplets;
    }
}
