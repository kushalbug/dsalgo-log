class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        int end = n - 1;
        while (end > 0) {
            for (int i = 0; i < end; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            end--;
        }
        return nums[0];
    }
}