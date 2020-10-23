package y2020.m10.d22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Note that EDU's solution is O(n + k) time and O(k) space
// O(nk) time, O(k) space
public class EDU_1_C2StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        HashMap<Character, Integer> patCount = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            patCount.put(c, patCount.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> windowCount = new HashMap<>();
        int left = 0;
        for (int right = 0; right < str.length(); right++) {
            char rightC = str.charAt(right);
            windowCount.put(rightC, windowCount.getOrDefault(rightC, 0) + 1);

            if (right >= pattern.length()) {
                char leftC = str.charAt(left);
                if (windowCount.get(leftC) == 1) {
                    windowCount.remove(leftC);
                } else {
                    windowCount.put(leftC, windowCount.get(leftC) - 1);
                }
                left++;
            }
            if (windowCount.equals(patCount)) resultIndices.add(left);
        }

        return resultIndices;
    }
}
