package y2021.m01.d28;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EDU_10_6_UniqueGeneralizedAbbreviations {
    // O(n 2^n) time, O(n 2^n) space
    public static List<String> generateGeneralizedAbbreviation(String word) {
        Set<String> result = new HashSet<String>(); // TODO how can I do this without cheating by using a set?
        result.add(word);

        List<String> lastRun = new ArrayList<>(result);
        while (!lastRun.isEmpty()) {
            String next = lastRun.remove(0);

            for (int i = 0; i < next.length(); i++) {
                if (Character.isDigit(next.charAt(i))) continue;
                boolean preNum = i > 0 && Character.isDigit(next.charAt(i - 1));
                boolean postNum = i < next.length() - 1 && Character.isDigit(next.charAt(i + 1));
                int preI = i;
                if (preNum) preI--;
                if (preI < 0) preI = 0;
                int postI = i + 1;
                if (postNum) postI++;

                String pre = next.substring(0, preI);
                int code = 1;
                if (preNum) code += Character.getNumericValue(next.charAt(i - 1));
                if (postNum) code += Character.getNumericValue(next.charAt(i + 1));
                String post = "";
                if (postI < next.length()) post = next.substring(postI);

                String newStr = pre +
                        code +
                        post;

                result.add(newStr);
                if (newStr.length() > 1) lastRun.add(newStr);
            }
        }

        return new ArrayList<>(result);
    }
}
