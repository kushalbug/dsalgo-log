//day 32 of daily log

class Solution {
    public String sortVowels(String s) {
        // Step 1: Collect vowels
        List<Character> vowels = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowels.add(ch);
            }
        }

        // Step 2: Sort vowels by ASCII
        Collections.sort(vowels);

        // Step 3: Rebuild the string
        StringBuilder result = new StringBuilder();
        int idx = 0; // pointer for vowels list
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                result.append(vowels.get(idx++));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    // Helper to check vowels
    private boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}
