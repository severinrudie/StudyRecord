package y2020.m10.d21;

import java.util.HashMap;
import java.util.Map;

// O(n) time, O(1) space
class EDU_1_4MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        if (arr.length == 0) return 0;
        int longest = 0;
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            char rightChar = arr[right];
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while (map.size() > 2) {
                char leftChar = arr[left];
                if (map.get(leftChar) == 1) {
                    map.remove(leftChar);
                } else {
                    map.put(leftChar, map.get(leftChar) - 1);
                }
                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
