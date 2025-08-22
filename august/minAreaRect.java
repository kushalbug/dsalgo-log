//day-12

class Solution { 
    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int minRow = m, maxRow = -1, minCol = n, maxCol = -1;

        // Step 1: Find bounds of all 1's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        // Step 2: If no 1's exist, return 0
        if (maxRow == -1) return 0;

        // Step 3: Compute area
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;

        return height * width;
    }
}
