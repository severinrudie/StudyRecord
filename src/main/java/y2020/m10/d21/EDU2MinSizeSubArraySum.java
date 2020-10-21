package y2020.m10.d21;

// O(n) time, O(1) space
class EDU2MinSizeSubArraySum {
    public static int findMinSubArray(int target, int[] arr) {
        if (arr.length == 0) return -1;

        int left = 0;
        int right = 0;

        int narrowestWindow = Integer.MAX_VALUE;
        int currTotal = arr[0];

        while (true) {
            if (currTotal >= target) {
                narrowestWindow = Math.min(narrowestWindow, right - left + 1);

                System.out.println("Left: " + left + " Right: " + right + " Window: " + narrowestWindow + " CurrTotal: " + currTotal);
            }

            if (
                    left > right ||
                    left >= arr.length ||
                    (right >= arr.length - 1 && currTotal < target)
            ) {
                break;
            }

            if (currTotal >= target) {
                currTotal -= arr[left];
                left++;
            } else {
                right++;
                currTotal += arr[right];
            }
        }

        if (narrowestWindow == Integer.MAX_VALUE) return -1;
        else return narrowestWindow;
    }
}
