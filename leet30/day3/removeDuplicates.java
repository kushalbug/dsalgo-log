package day3;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // pointer for the last unique element
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;            // move i forward
                nums[i] = nums[j]; // overwrite duplicate
            }
        }
        return i + 1; // number of unique elements
    }
}

