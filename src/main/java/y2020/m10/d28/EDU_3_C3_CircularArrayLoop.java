package y2020.m10.d28;

// O(n^2) time, O(1) space
public class EDU_3_C3_CircularArrayLoop {
    public static boolean loopExists(int[] arr) {
        int fast = 0;
        int slow = 0;
        int len = arr.length;

        do {
            fast = moveBy(fast, arr[fast], len);
            fast = moveBy(fast, arr[fast], len);
            slow = moveBy(slow, arr[slow], len);
        } while (fast != slow);

        int cycleLen = 0;
        do {
            fast = moveBy(fast, arr[fast], len);
            cycleLen++;
        } while (fast != slow);

        if (cycleLen == 1) return false;

        boolean isPositive = arr[fast] >= 0;
        for (int i = 0; i < cycleLen; i++) {
            fast = moveBy(fast, arr[fast], len);
            if (isPositive != arr[fast] >= 0) return false;
        }
        return true;
    }

    static int moveBy(int start, int moveBy, int len) {
        int result = (start + moveBy) % len;
        if (result < 0) result = len + result;
        return result;
    }
}
