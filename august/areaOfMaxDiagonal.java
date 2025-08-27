//day-16 of leetcoding 

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagSq = -1;
        int maxArea = -1;
        
        for (int[] rect : dimensions) {
            int length = rect[0];
            int width = rect[1];
            
            int diagSq = length * length + width * width; // diagonal squared
            int area = length * width;
            
            if (diagSq > maxDiagSq) {
                maxDiagSq = diagSq;
                maxArea = area;
            } else if (diagSq == maxDiagSq && area > maxArea) {
                maxArea = area;
            }
        }
        
        return maxArea;
    }
}
