package y2020.m10.d23;

import java.util.Arrays;
import java.util.Collections;

// O(n) time, O(n) space
public class EDU_2_3_MakeSquares {
    public static int[] makeSquares(int[] arr) {
        int positiveIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                positiveIndex = i;
                break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }

        if (positiveIndex == 0) return arr;
        if (positiveIndex == -1) {
            Collections.reverse(Arrays.asList(arr));
            return arr;
        }

        int negativeIndex = positiveIndex - 1;

        int squaresIndex = 0;
        int[] squares = new int[arr.length];

        while (positiveIndex < arr.length && negativeIndex >= 0) {
            if (arr[positiveIndex] < arr[negativeIndex]) {
                squares[squaresIndex] = arr[positiveIndex];
                positiveIndex++;
            } else {
                squares[squaresIndex] = arr[negativeIndex];
                negativeIndex--;
            }
            squaresIndex++;
        }

        while (positiveIndex < arr.length) {
            squares[squaresIndex] = arr[positiveIndex];
            squaresIndex++;
            positiveIndex++;
        }

        while (negativeIndex >= 0) {
            squares[squaresIndex] = arr[negativeIndex];
            squaresIndex++;
            negativeIndex--;
        }

        return squares;
    }
}
