package y2020.m10.d30;

// O(n) time, O(1) space
public class EDU_5_1_CyclicSort {
    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int temp = nums[i];
            if (temp == i + 1) {
                // no swap needed
                i++;
            } else {
                // swap, and keep i where it is to follow up
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
    }
}
