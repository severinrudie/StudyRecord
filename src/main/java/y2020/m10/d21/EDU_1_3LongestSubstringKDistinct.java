package y2020.m10.d21;

import java.util.HashMap;
import java.util.Map;

// O(n) time, O(k) space
public class EDU_1_3LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        int longest = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;

        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (getUniques(map) <= k) {
                longest = Math.max(longest, right - left + 1);
            }

            while (getUniques(map) > k) {
                char leftChar = str.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
        }

        return longest;
    }

    static <T> long getUniques(Map<T, Integer> map) {
        return map.keySet().stream().filter( key -> map.get(key) > 0).count();
    }
}
