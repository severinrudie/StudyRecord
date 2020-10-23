package y2020.m10.d23;

// O(n) time, O(1) space
public class EDU_2_2_RemoveDuplicates {
    public static int remove(int[] arr) {
        int nextGood = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[nextGood] = arr[i];
                nextGood++;
            }
        }

        return nextGood;
    }
}
