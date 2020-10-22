package y2020.m10.d21;

// O(n) time, O(1) space
public class EDU7ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int longest = 0;
        int currZeros = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) currZeros++;

            while (currZeros > k && left < right) {
                if (arr[left] == 0) currZeros--;
                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
