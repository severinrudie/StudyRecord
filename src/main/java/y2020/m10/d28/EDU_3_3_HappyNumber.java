package y2020.m10.d28;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// EDU has an answer in O(log n) time, O(1) space
// O(??) time, O(n) space
public class EDU_3_3_HappyNumber {
    public static boolean find(int num) {
        Set<Integer> nums = new HashSet<>();

        while (true) {
            if (num == 1) return true;
            else if (nums.contains(num)) return false;
            nums.add(num);
            num = sumOfDigitsSquared(num);
        }
    }

    static int sumOfDigitsSquared(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            int ones = num % 10;
            digits.add(ones);
            num = (num - ones) / 10;
        }

        for (int i = 0; i < digits.size(); i++) {
            digits.set(i, digits.get(i) * digits.get(i));
        }

        int total = 0;
        for (Integer digit : digits) {
            total += digit;
        }
        return total;
    }
}
