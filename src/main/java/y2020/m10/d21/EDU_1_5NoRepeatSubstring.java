package y2020.m10.d21;

import java.util.HashMap;
import java.util.Map;

// O(n) time, O(k) space (where k == distinct chars in str)
public class EDU_1_5NoRepeatSubstring {
    public static int findLength(String str) {
        int maxLen = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap();

        for (int right = 0; right < str.length(); right++) {
            char rightC = str.charAt(right);
            map.put(rightC, map.getOrDefault(rightC, 0) + 1);

            while (
                map.values()
                    .stream()
                    .anyMatch(val -> val > 1)
            ) {
                char leftC = str.charAt(left);
                map.put(leftC, map.get(leftC) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
