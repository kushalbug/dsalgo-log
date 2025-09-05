package day11;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // push opening brackets
            } else {
                if (stack.isEmpty()) return false; // no opener for this closer
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false; // mismatch
                }
            }
        }
        
        return stack.isEmpty(); // valid only if nothing is left
    }
}
