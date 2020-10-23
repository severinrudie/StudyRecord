package y2020.m10.d21;

// https://www.educative.io/courses/grokking-the-coding-interview/JPKr0kqLGNP
// Easy
// O(n) time, O(1) space
class EDU_1_1MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int start = 0;
        int end = 0;
        int max = 0;
        int currTotal = 0;
        while (end < arr.length - 1) {
            currTotal += arr[end];
            if (end > k - 1) {
                currTotal -= arr[start];
                start++;
            }
            end++;
            max = Math.max(currTotal, max);
        }
        return max;
    }
}
