//day-18
import java.util.*;
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Map for diagonals (key = row - col)
        Map<Integer, List<Integer>> diagonals = new HashMap<>();

        // Step 1: Collect diagonals
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                diagonals.putIfAbsent(key, new ArrayList<>());
                diagonals.get(key).add(grid[i][j]);
            }
        }

        // Step 2: Sort diagonals
        for (int key : diagonals.keySet()) {
            List<Integer> diag = diagonals.get(key);
            if (key >= 0) {
                // Bottom-left → non-increasing
                diag.sort(Collections.reverseOrder());
            } else {
                // Top-right → non-decreasing
                Collections.sort(diag);
            }
        }

        // Step 3: Write back into matrix
        Map<Integer, Integer> idxMap = new HashMap<>(); // track position in each diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                int idx = idxMap.getOrDefault(key, 0);
                grid[i][j] = diagonals.get(key).get(idx);
                idxMap.put(key, idx + 1);
            }
        }

        return grid;
    }
}
