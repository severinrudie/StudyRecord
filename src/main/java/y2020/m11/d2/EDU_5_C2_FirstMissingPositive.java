package y2020.m11.d2;

// O(n) time, O(1) space
public class EDU_5_C2_FirstMissingPositive {
    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (j >= 0 && j < nums.length && j != i) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] - 1 != k) {
                return k + 1;
            }
        }
        return -1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
