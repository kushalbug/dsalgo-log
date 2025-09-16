//day37 of daily log

import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();

        for (int num : nums) {
            int cur = num;

            // Merge backwards while top and cur are non-coprime
            while (!stack.isEmpty()) {
                int prev = stack.get(stack.size() - 1);
                int g = gcd(prev, cur);

                if (g == 1) break; // coprime, stop merging

                // merge into LCM
                cur = lcm(prev, cur, g);
                stack.remove(stack.size() - 1); // pop prev
            }

            stack.add(cur);
        }

        return stack;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private int lcm(int a, int b, int g) {
        // avoid overflow by dividing first
        return (int)((long)a / g * b);
    }
}
