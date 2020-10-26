package y2020.m10.d26;

import java.util.Arrays;

// O(n) time, O(n) space [unless in place sorting is used]
public class EDU_2_6_TripletsWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        int count = -1;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {

                System.out.println("i: " + i + " l: " + left + " r: " + right);
                int sum = arr[i] + arr[left] + arr[right];
                if (sum < target) {
                    count++;
                    left++;
                } else if (arr[i] >= target) {
                    break;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}
