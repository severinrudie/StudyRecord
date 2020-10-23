package y2020.m10.d23;

import java.util.*;

// O(nkl) time, where k == words.length and l == length of words in k
// O(n + m) space, where m == space used by words
public class EDU_1_C4WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        if (words.length == 0 || str.length() == 0) return new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Set<String> windowWords = new HashSet<>();
        List<Integer> resultIndices = new ArrayList<>();
        final int windowSize = words.length * words[0].length();

        for (int i = 0; i < str.length() - (windowSize - 1); i++) {
            windowWords.clear();
            for (int j = 0; j < words.length; j++) {
                int offset = j * words[0].length();
                String word = str.substring(i + offset, i + offset + words[0].length());
                if (wordSet.contains(word)) {
                    windowWords.add(word);
                }
            }
            if (windowWords.size() == words.length) resultIndices.add(i);
        }

        return resultIndices;
    }
}
