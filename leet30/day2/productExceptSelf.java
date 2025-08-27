package leet30.day2;

public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // Calculate left products
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Calculate right products and final output
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return output;
    }
    
}
