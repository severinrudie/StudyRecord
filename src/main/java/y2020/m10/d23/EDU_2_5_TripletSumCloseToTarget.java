package y2020.m10.d23;

import java.util.Arrays;

// O(n^2) time, space depends on sorting algorithm [probably O(n)]
public class EDU_2_5_TripletSumCloseToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        if (arr.length < 3) return -1;
        Arrays.sort(arr);
        int closestSum = arr[0] + arr[1] + arr[2];

        for (int i = 0; i <= arr.length - 3; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int total = arr[left] + arr[right] + arr[i];
                int diff = Math.abs(targetSum - total);
                int bestDiff = Math.abs(targetSum - closestSum);

                if (diff == bestDiff) {
                    closestSum = Math.min(closestSum, total);
                } else if (diff < bestDiff) {
                    closestSum = total;
                }

                if (total > targetSum) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return closestSum;
    }
}
