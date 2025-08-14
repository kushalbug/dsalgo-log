// day-4 

class Solution {
    public String largestGoodInteger(String num) {
        String maxGood = ""; // store best found

        for (int i = 0; i <= num.length() - 3; i++) {
            char a = num.charAt(i);
            char b = num.charAt(i + 1);
            char c = num.charAt(i + 2);

            // Check if all three are equal
            if (a == b && b == c) {
                String candidate = num.substring(i, i + 3);
                if (maxGood.equals("") || candidate.compareTo(maxGood) > 0) {
                    maxGood = candidate;
                }
            }
        }
        return maxGood;
    }
}
