package y2021.m01.d28;

import java.util.*;

public class EDU_10_6_UniqueGeneralizedAbbreviations {
    // O(n 2^n) time, O(n 2^n) space
    public static List<String> generateGeneralizedAbbreviation(String target) {
        return generateGeneralizedAbbreviation(target, "");
    }

    public static List<String> generateGeneralizedAbbreviation(String target, String curr) {
        if (target.length() == curr.length()) {
            List<String> result = new LinkedList<>();
            result.add(withUnderscoresCounted(curr));
            return result;
        }

        String withNum = curr + '_';
        curr += target.charAt(curr.length());

        List<String> result = generateGeneralizedAbbreviation(target, curr);
        result.addAll(generateGeneralizedAbbreviation(target, withNum));

        return result;
    }

    static String withUnderscoresCounted(String input) {
        StringBuilder result = new StringBuilder();
        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '_') {
                num += 1;
            } else {
                if (num > 0) {
                    result.append(num);
                    num = 0;
                }
                result.append(input.charAt(i));
            }
        }
        if (num > 0) result.append(num);

        return result.toString();
    }
}
