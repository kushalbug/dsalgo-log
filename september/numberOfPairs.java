//day-23 of daily log

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int Ax = points[i][0], Ay = points[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int Bx = points[j][0], By = points[j][1];

                // Check if A is on the upper-left of B
                if (Ax <= Bx && Ay >= By) {
                    boolean valid = true;

                    // Check if any other point lies inside or on border
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int x = points[k][0], y = points[k][1];

                        if (Ax <= x && x <= Bx && By <= y && y <= Ay) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) count++;
                }
            }
        }

        return count;
    }
}
