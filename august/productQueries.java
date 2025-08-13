//day 1

class Solution {
    static final long MOD = 1_000_000_007;

    private long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Extract powers of 2 in ascending order
        long bit = 1;
        int temp = n;
        java.util.List<Long> powers = new java.util.ArrayList<>();
        while (temp > 0) {
            if ((temp & 1) == 1) powers.add(bit);
            temp >>= 1;
            bit <<= 1;
        }

        int m = powers.size();
        long[] prefix = new long[m];
        long[] invPrefix = new long[m];

        // Step 2: Prefix products and inverse prefix products
        prefix[0] = powers.get(0) % MOD;
        for (int i = 1; i < m; i++) {
            prefix[i] = (prefix[i - 1] * powers.get(i)) % MOD;
        }
        invPrefix[0] = modPow(prefix[0], MOD - 2);
        for (int i = 1; i < m; i++) {
            invPrefix[i] = modPow(prefix[i], MOD - 2);
        }

        // Step 3: Answer queries in O(1)
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0) {
                ans[i] = (int) prefix[r];
            } else {
                ans[i] = (int) ((prefix[r] * invPrefix[l - 1]) % MOD);
            }
        }
        return ans;
    }
}
