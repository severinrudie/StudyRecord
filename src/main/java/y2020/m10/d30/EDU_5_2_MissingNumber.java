package y2020.m10.d30;

// O(n) time, O(1) space
public class EDU_5_2_MissingNumber {
    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            if (nums[i] == nums.length) {
                // too big, get rid of it
                i++;
            } else if (i == j) {
                // already in the right place
                i++;
            } else {
                // keep i where it is to follow up
                swap(nums, i, j);
            }
        }

        for (int k = 1; k < nums.length; k++) {
            if (nums[k - 1] != nums[k] - 1) return nums[k - 1] + 1;
        }
        return nums.length;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
