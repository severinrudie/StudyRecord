package y2021.m01.d28;

import java.util.ArrayList;
import java.util.List;

public class EDU_10_4_FindLetterCaseStringPermutations {
    // O(n 2^n) time, O(n 2^n) space
    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str.toLowerCase());

        int a = (int) 'a';
        int z = (int) 'z';

        for (int i = 0; i < str.length(); i++) {
            int cInt = (int) str.charAt(i);
            if (cInt < a || cInt > z) continue;

            int end = permutations.size();
            for (int j = 0; j < end; j++) {
                String perm = permutations.remove(0);
                String newPerm = perm.substring(0, i) +
                        Character.toUpperCase(perm.charAt(i)) +
                        perm.substring(i + 1);
                permutations.add(perm);
                permutations.add(newPerm);
            }
        }
        return permutations;
    }
}


