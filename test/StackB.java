import java.util.*;

public class StackB {
    public static void pushAtBottom(Stack<Integer> stack , int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }

    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){    
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        // Stack<Integer> stack = new Stack<>();
        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        
        // pushAtBottom(stack , 4);
        // while(!stack.isEmpty()){
        //     System.out.println(stack.pop());
        // }

        String str = "abcd";
        String result = reverseString(str);
        System.out.println(result);
    }
}
