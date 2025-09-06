//day- 27

class Solution {
    // F(n) = sum_{x=1..n} f(x), where f(x) = floor(log4 x) + 1 for x>=1
    private long prefix(long n) {
        if (n <= 0) return 0;
        long res = 0;
        long base = 1; // 4^(k-1)
        int k = 1;     // steps for numbers in [base, 4*base-1]

        // add full 4-ary blocks
        while (base <= n / 4) {         // avoid overflow: base*4 <= n
            res += (base * 3) * (long) k; // count in block = 3*base
            base *= 4;
            k++;
        }
        // add partial tail [base, n]
        res += (n - base + 1) * (long) k;
        return res;
    }

    // max f(x) for x in [1..r] = floor(log4 r) + 1 (for r >= 1)
    private int maxSteps(long r) {
        if (r <= 0) return 0;
        int k = 1;      // for [1,3]
        long base = 1;  // 4^(k-1)
        while (base <= r / 4) { // base*4 <= r
            base *= 4;
            k++;
        }
        return k;
    }

    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            long l = q[0], r = q[1];
            long totalSteps = prefix(r) - prefix(l - 1);
            long pairBound = (totalSteps + 1) / 2; // ceil(total/2)
            long chainBound = maxSteps(r);
            ans += Math.max(pairBound, chainBound);
        }
        return ans;
    }
}
//day- 27