//day 24 number of pairs II

class Solution {
    public int numberOfPairs2(int[][] points) {
        int n = points.length;
        
        // Sort by x ascending, if tie -> y descending
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int res = 0;

        // For each Alice candidate
        for (int i = 0; i < n; i++) {
            int xa = points[i][0];
            int ya = points[i][1];

            int minY = Integer.MIN_VALUE; // track lowest allowed y for Bob

            // Iterate Bob candidates to the right
            for (int j = i + 1; j < n; j++) {
                int xb = points[j][0];
                int yb = points[j][1];

                if (yb > ya) continue;   // Bob must be below or equal

                if (yb <= minY) continue; // would enclose another point

                // This pair is valid
                res++;

                // Update minY to tighten rectangle
                minY = yb;
            }
        }

        return res;
    }
}
