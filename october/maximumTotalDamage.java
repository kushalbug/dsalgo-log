//day62 of daily log 
import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        TreeMap<Long, Long> occ = new TreeMap<>();
        for (int x : power) {
            occ.put((long)x, occ.getOrDefault((long)x, 0L) + 1);
        }

        List<Long> v = new ArrayList<>();
        List<Long> c = new ArrayList<>();
        for (Map.Entry<Long, Long> e : occ.entrySet()) {
            v.add(e.getKey());
            c.add(e.getValue());
        }

        int n = v.size();
        long[] dp = new long[n];
        dp[0] = v.get(0) * c.get(0);

        for (int i = 1; i < n; i++) {
            long take = v.get(i) * c.get(i);
            int j = i - 1;
            while (j >= 0 && v.get(i) - v.get(j) <= 2) j--;
            if (j >= 0) take += dp[j];
            dp[i] = Math.max(dp[i - 1], take);
        }

        return dp[n - 1];
    }
}