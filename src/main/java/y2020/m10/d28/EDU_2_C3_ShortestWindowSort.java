package y2020.m10.d28;

import java.util.Arrays;

public class EDU_2_C3_ShortestWindowSort {
    public static int sort(int[] arr) {
        if (arr.length < 2) return 0;
        int left = 0;
        int right = arr.length - 1;

        while(left < right && arr[left] < arr[left + 1]) {
            left++;
        }
        while (left < right && arr[right] > arr[right - 1]) {
            right--;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(max, arr[i]);
        }
        for (int i = left; i >= 0; i--) {
            if (arr[i] > min) left = i;
        }
        for (int i = right; i < arr.length; i++) {
            if (arr[i] < max) right = i;
        }

        if (left >= right) return 0;
        return right - left + 1;
    }
}
