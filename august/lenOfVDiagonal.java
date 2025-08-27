//day-17 of java


class Solution {
    private static final int[][] DIRS = {
        {1, 1},   // ↘ down-right
        {-1, -1}, // ↖ up-left
        {1, -1},  // ↙ down-left
        {-1, 1}   // ↗ up-right
    };

    // Clockwise turn mapping: from dir index → new dir index
    private static final int[] CLOCKWISE_TURN = {2, 3, 1, 0};

    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;

        // Check all possible starting cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // Try all 4 diagonal directions
                    for (int d = 0; d < 4; d++) {
                        ans = Math.max(ans, dfs(grid, i, j, d, true, 0));
                    }
                }
            }
        }
        return ans;
    }

    // DFS to explore diagonal path
    private int dfs(int[][] grid, int r, int c, int dir, boolean canTurn, int step) {
        int n = grid.length, m = grid[0].length;

        // Expected value according to sequence
        int expected = (step == 0) ? 1 : (step % 2 == 1 ? 2 : 0);
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] != expected) {
            return step;
        }

        int best = step + 1;

        // Continue in same direction
        int nr = r + DIRS[dir][0];
        int nc = c + DIRS[dir][1];
        best = Math.max(best, dfs(grid, nr, nc, dir, canTurn, step + 1));

        // Try turning clockwise (only once)
        if (canTurn) {
            int newDir = CLOCKWISE_TURN[dir];
            nr = r + DIRS[newDir][0];
            nc = c + DIRS[newDir][1];
            best = Math.max(best, dfs(grid, nr, nc, newDir, false, step + 1));
        }

        return best;
    }
}
