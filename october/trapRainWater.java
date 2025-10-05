//day 54 of daily log
import java.util.PriorityQueue;

class Solution {

    /**
     * Calculates the total amount of rainwater that can be trapped in a 2D height map.
     * @param heightMap A 2D array representing the height of each cell in the landscape.
     * @return The total volume of trapped rainwater.
     */
    public int trapRainWater(int[][] heightMap) {
        // --- Step 1: Handle Edge Cases ---
        // If the height map is null, empty, or has no rows, no water can be trapped. Return 0.
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        
        // Get the dimensions of the height map.
        int m = heightMap.length;    // Number of rows.
        int n = heightMap[0].length; // Number of columns.
        
        // --- Step 2: Initialize Data Structures ---
        // `pq`: A PriorityQueue to store boundary cells.
        // It will store cells as `int[]{row, col, height}`.
        // The PriorityQueue is ordered by height (ascending), so `pq.poll()` always gives the cell with the minimum height on the current boundary.
        // This is crucial for our "water level" simulation.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // Lambda for custom comparator: sort by height (index 2).
        
        // `visited`: A 2D boolean array to keep track of cells we have already processed or added to the boundary.
        // This prevents us from processing the same cell multiple times and ensures we move inwards.
        boolean[][] visited = new boolean[m][n];
        
        // `directions`: An array to easily iterate through the four possible adjacent cells (up, down, left, right).
        // {{0,1} is right, {1,0} is down, {0,-1} is left, {-1,0} is up}.
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        // `water`: This variable will accumulate the total amount of trapped rainwater.
        int water = 0;

        // --- Step 3: Add Boundary Cells to the PriorityQueue ---
        // We initialize our "boundary" with all the cells on the outer edges of the height map.
        // These cells form the initial "walls" that contain the water.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check if the current cell (i, j) is on any of the four borders:
                // top row (i == 0), bottom row (i == m-1), left column (j == 0), or right column (j == n-1).
                if (i == 0 || i == m-1 || j == 0 || j == n-1) {
                    // If it's a boundary cell:
                    // 1. Add it to the PriorityQueue with its coordinates and height.
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    // 2. Mark this cell as visited, so we don't process it again.
                    visited[i][j] = true;
                }
            }
        }

        // --- Step 4: Process Cells from the Boundary Inwards ---
        // We continue as long as there are cells in our boundary (PriorityQueue) to process.
        while (!pq.isEmpty()) {
            // Get the cell with the minimum height from the current boundary.
            // This cell `(x, y)` with height `h` is our current "water level" reference.
            int[] cell = pq.poll(); // `poll()` removes and returns the element with the smallest height.
            int x = cell[0], y = cell[1], h = cell[2]; // Extract coordinates and height.

            // Explore the neighbors of this minimum boundary cell.
            for (int[] dir : directions) {
                // Calculate the coordinates of the neighbor cell.
                int nx = x + dir[0];
                int ny = y + dir[1];

                // Check if the neighbor is within the grid boundaries AND has not been visited yet.
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    // Mark the neighbor as visited, as we are now considering it.
                    visited[nx][ny] = true;
                    
                    // --- Calculate Trapped Water ---
                    // If the neighbor's height is LESS than the current boundary height `h`,
                    // it means water can be trapped at this neighbor's position.
                    if (heightMap[nx][ny] < h) {
                        // The amount of water trapped at this specific neighbor cell is the difference: `h - heightMap[nx][ny]`.
                        // Add this amount to our total `water` count.
                        water += h - heightMap[nx][ny];
                    }
                    
                    // --- Add Neighbor to the New Boundary ---
                    // Add the neighbor cell to the PriorityQueue to become part of the new boundary.
                    // Its height in the queue should be the *maximum* of its own height and the current boundary height `h`.
                    // This is because the water level cannot be lower than the lowest wall that contains it.
                    // If the neighbor is taller than `h`, it becomes a new, higher wall. If it's shorter, the water level `h` from the previous cell dictates the minimum height.
                    pq.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], h)});
                }
            }
        }

        // --- Step 5: Return Total Water ---
        // After processing all reachable cells, `water` will hold the total volume of trapped rainwater.
        return water;
    }
}