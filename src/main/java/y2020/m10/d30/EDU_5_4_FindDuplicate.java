package y2020.m10.d30;

// O(n) time, O(1) space
public class EDU_5_4_FindDuplicate {
    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (i + 1 == num) {
                i++;
            } else if (num == nums[num - 1]) {
                return num;
            } else {
                swap(nums, i, num - 1);
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
