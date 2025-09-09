//day 29 

class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (!hasZero(a) && !hasZero(b)) {
                return new int[]{a, b};
            }
        }
        return new int[]{}; // won't reach here since solution always exists
    }

    private boolean hasZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) return true; // check if last digit is 0
            num /= 10;
        }
        return false;
    }
}
