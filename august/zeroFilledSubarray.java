//day-9

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;      // answer
        long streak = 0;     // current run of zeros

        for (int n : nums) {
            if (n == 0) {
                streak++;          // extend zero streak
                count += streak;   // add all subarrays ending here
            } else {
                streak = 0;        // reset streak
            }
        }
        return count;
    }
}
