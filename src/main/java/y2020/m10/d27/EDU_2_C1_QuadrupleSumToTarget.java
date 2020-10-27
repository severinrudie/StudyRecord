package y2020.m10.d27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(n^3) time, ?? space
public class EDU_2_C1_QuadrupleSumToTarget {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (arr.length < 4) return quadruplets;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i -1]) continue;

            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int sum = arr[i] + arr[j];
                int left = j + 1;
                int right = arr.length - 1;

                while (left < right) {
                    int total = sum + arr[left] + arr[right];
                    if (total == target) {
                        quadruplets.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;
                        while (left < right && arr[left] == arr[left - 1]) {
                            left++;
                        }
                        while (left < right && arr[right] == arr[right + 1]) {
                            right--;
                        }
                    } else if (total < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}
