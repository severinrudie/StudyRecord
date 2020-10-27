package y2020.m10.d27;

import java.util.HashSet;
import java.util.Set;

// EDU has a O(n + m) time, O(1) solution
// O(n + m) time, O(n) space
public class EDU_2_C2_BackspaceCompare {
    public static boolean compare(String str1, String str2) {
        Set<Integer> s1Ignore = getIgnored(str1);
        Set<Integer> s2Ignore = getIgnored(str2);

        int i1 = 0;
        int i2 = 0;

        while (true) {
            while (s1Ignore.contains(i1)) {
                i1++;
            }
            while (s2Ignore.contains(i2)) {
                i2++;
            }
            if (i1 >= str1.length() || i2 >= str2.length()) break;
            if (str1.charAt(i1) != str2.charAt(i2)) {
                return false;
            } else {
                i1++;
                i2++;
            }
        }

        return i1 == str1.length() && i2 == str2.length();
    }

    static Set<Integer> getIgnored(String str) {
        Set<Integer> hashes = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                hashes.add(i);
                int lower = i - 1;
                while (hashes.contains(lower)) {
                    lower--;
                }
                hashes.add(lower);
            }
        }
        return hashes;
    }
}
