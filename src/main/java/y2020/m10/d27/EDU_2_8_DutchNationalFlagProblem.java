package y2020.m10.d27;

// Note: this is exactly O(3n) time, and the EDU example is O(1n)
// O(n) time, O(1) space
public class EDU_2_8_DutchNationalFlagProblem {
    public static void sort(int[] arr) {
        int lastGood = 0;
        for (int num = 0; num <= 2; num++) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == num) {
                    swap(arr, lastGood, i);
                    lastGood++;
                }
            }
        }
    }

    public static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i2];
        arr[i2] = arr[i1];
        arr[i1] = temp;
    }
}
