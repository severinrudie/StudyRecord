package y2020.m10.d23;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// O(n) [O(n + k), but k is guaranteed to be smaller than n] time
// O(k) space [technically O(n) in the case that str is an anagram of pattern, since the return string will be n long]
public class EDU_C3MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        if (pattern.length() > str.length()) return "";

        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            charSet.add(pattern.charAt(i));
        }
        HashMap<Character, Integer> chars = new HashMap<>();
        int shortest = Integer.MAX_VALUE;
        String shortestStr = "";

        int left = 0;
        for (int right = 0; right < str.length(); right++) {
            char rightC = str.charAt(right);
            if (charSet.contains(rightC)) {
                chars.put(rightC, chars.getOrDefault(rightC, 0) + 1);
            }

            if (right >= pattern.length()) {
                while (chars.size() >= pattern.length()) {
                    if (right - left + 1 < shortest) {
                        shortest = right - left + 1;
                        shortestStr = str.substring(left, right + 1);
                    }

                    char leftC = str.charAt(left);
                    if (charSet.contains(leftC)) {
                        if (chars.get(leftC) == 1) {
                            chars.remove(leftC);
                        } else {
                            chars.put(leftC, chars.get(leftC) - 1);
                        }
                    }
                    left++;
                }
            }
        }
        return shortestStr;
    }
}
