//day 2 

class Solution {
    static final int MOD = 1_000_000_007;
    long[][] dp;

    public int numberOfWays(int n, int x) {
        dp = new long[n + 1][n + 1]; // dp[remaining][curr]
        for (long[] row : dp) Arrays.fill(row, -1);
        return (int) dfs(n, x, 1);
    }

    private long dfs(int remaining, int power, int curr) {
        if (remaining == 0) return 1; // Found valid combination
        if (Math.pow(curr, power) > remaining) return 0; // Can't use curr anymore
        
        if (dp[remaining][curr] != -1) return dp[remaining][curr];

        int val = (int) Math.pow(curr, power);
        long ways = 0;

        // Include curr
        ways = (ways + dfs(remaining - val, power, curr + 1)) % MOD;

        // Skip curr
        ways = (ways + dfs(remaining, power, curr + 1)) % MOD;

        return dp[remaining][curr] = ways;
    }
}
