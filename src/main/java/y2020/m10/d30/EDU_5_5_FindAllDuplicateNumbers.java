package y2020.m10.d30;

import java.util.ArrayList;
import java.util.List;

// O(n) time, O(1) space
public class EDU_5_5_FindAllDuplicateNumbers {
    public static List<Integer> findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (nums[num - 1] == num) {
                i++;
            } else {
                swap(nums, i, num - 1);
            }
        }

        List<Integer> duplicateNumbers = new ArrayList<>();

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) duplicateNumbers.add(nums[j]);
        }
        return duplicateNumbers;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
