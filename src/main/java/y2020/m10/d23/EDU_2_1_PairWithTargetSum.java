package y2020.m10.d23;

// O(n) time, O(1) space
public class EDU_2_1_PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int total = arr[left] + arr[right];
            if (total == targetSum) return new int[] { left, right };
            else if (total > targetSum) {
                right--;
            } else {
                left++;
            }
        }
        return new int[] { -1, -1 };
    }
}
