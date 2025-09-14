//day-35 of daily log

import java.util.*;

public class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitiveMap = new HashMap<>();
        Map<String, String> vowelErrorMap = new HashMap<>();

        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            caseInsensitiveMap.putIfAbsent(lower, word);

            String devoweled = devowel(lower);
            vowelErrorMap.putIfAbsent(devoweled, word);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (exactWords.contains(query)) {
                result[i] = query;
            } else {
                String lower = query.toLowerCase();
                if (caseInsensitiveMap.containsKey(lower)) {
                    result[i] = caseInsensitiveMap.get(lower);
                } else {
                    String devoweled = devowel(lower);
                    result[i] = vowelErrorMap.getOrDefault(devoweled, "");
                }
            }
        }

        return result;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}
