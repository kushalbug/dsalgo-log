//day-11

class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] heights = new int[m][n];

        // Step 1: Build histogram heights
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (mat[i][j] == 0) heights[i][j] = 0;
                else heights[i][j] = (i == 0 ? 1 : heights[i - 1][j] + 1);
            }
        }

        int result = 0;

        // Step 2: For each row, count rectangles using monotonic stack
        for (int i = 0; i < m; i++) {
            result += countRectangles(heights[i]);
        }

        return result;
    }

    private int countRectangles(int[] heights) {
        int n = heights.length;
        int[] sum = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int res = 0;

        for (int j = 0; j < n; j++) {
            // maintain increasing stack
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[j]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                int prev = stack.peek();
                sum[j] = sum[prev] + heights[j] * (j - prev);
            } else {
                sum[j] = heights[j] * (j + 1);
            }

            stack.push(j);
            res += sum[j];
        }

        return res;
    }
}