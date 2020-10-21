package y2020.m10.d21;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// O(nk) time, O(k) space (where k == distinct chars in str)
// Note that the (better) provided solution was O(n), O(k)
public class EDU6CharacterReplacement {
    public static int findLength(String str, int k) {
        int longest = 0;
        int left = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < str.length(); right++) {
            char rC = str.charAt(right);
            map.put(rC, map.getOrDefault(rC, 0) + 1);

            while(differentCount(map) > k) {
                char lC = str.charAt(left);
                map.put(lC, map.get(lC) - 1);
                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }

    static int differentCount(Map<Character, Integer> map) {
        char biggest = map.keySet()
                      .stream()
                      .max((a1, a2) -> map.get(a1) - map.get(a2))
                      .get();

        return map.keySet()
                .stream()
                .filter(key -> key != biggest)
                .map(map::get)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
