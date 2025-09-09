//day 30

class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];  // dp[i] = people who learn secret on day i
        dp[1] = 1;
        
        long share = 0;  // running number of people who can share today

        for (int day = 2; day <= n; day++) {
            // People who start sharing today
            if (day - delay >= 1) {
                share = (share + dp[day - delay]) % MOD;
            }
            // People who forget today
            if (day - forget >= 1) {
                share = (share - dp[day - forget] + MOD) % MOD;
            }
            // People who learn today
            dp[day] = share;
        }

        // Count all people who still remember secret on day n
        long ans = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) {
                ans = (ans + dp[day]) % MOD;
            }
        }
        return (int) ans;
    }
}
