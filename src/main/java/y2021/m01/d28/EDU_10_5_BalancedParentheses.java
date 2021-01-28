package y2021.m01.d28;

import java.util.ArrayList;
import java.util.List;

public class EDU_10_5_BalancedParentheses {
    static class Parens {
        int openCount;
        String str;

        Parens(String str, int openCount) {
            this.openCount = openCount;
            this.str = str;
        }
    }

    // O(n * 2^n) time, O(n * 2^n) space
    public static List<String> generateValidParentheses(int num) {
        List<Parens> building = new ArrayList<>();
        building.add(new Parens("", 0));

        while (building.get(0).str.length() < num * 2) {
            Parens p = building.remove(0);
            building.add(new Parens(p.str + "(", p.openCount + 1));
            if (p.str.length() < p.openCount * 2) {
                building.add(new Parens(p.str + ")", p.openCount));
            }
        }

        List<String> result = new ArrayList<>();
        for (Parens p: building) {
            result.add(p.str);
        }
        return result;
    }
}
