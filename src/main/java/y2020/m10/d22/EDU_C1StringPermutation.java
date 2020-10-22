package y2020.m10.d22;

import java.util.HashMap;

// Note, EDU solution is O(n + k) time and O(k) space
// O(nk) time, O(k) space, where k == length of pattern
public class EDU_C1StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        if (str.length() == 0 || pattern.length() > str.length()) return false;

        HashMap<Character, Integer> strChars = new HashMap<>();
        HashMap<Character, Integer> patternChars = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            patternChars.put(c, patternChars.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        for (int right = 0; right < str.length(); right++) {
            char rightC = str.charAt(right);
            strChars.put(rightC, strChars.getOrDefault(rightC, 0) + 1);

            if (right >= pattern.length()) {
                char leftC = str.charAt(left);
                if (strChars.get(leftC) == 1) {
                    strChars.remove(leftC);
                } else {
                    strChars.put(leftC, strChars.get(leftC) - 1);
                }
                left++;
            }
            if (strChars.equals(patternChars)) return true;
        }

        return false;
    }
}
