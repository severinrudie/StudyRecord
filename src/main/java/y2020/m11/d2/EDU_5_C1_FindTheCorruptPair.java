package y2020.m11.d2;

// O(n) time, O(1) space
public class EDU_5_C1_FindTheCorruptPair {
    public static int[] findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            if (nums[i] == nums[j - 1]) {
                i++;
            } else {
                swap(nums, i, j - 1);
            }
        }

        int[] result = new int[2];
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                System.out.println("" + nums[k] + " " + k);
                result[0] = nums[k];
                result[1] = k + 1;
                break;
            }
        }
        return result;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
