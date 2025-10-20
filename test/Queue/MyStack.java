//leetcode - 225
import java.util.*;

class MyStack {

    public MyStack() {
        private Queue<Integer> q1;
        private Queue<Integer> q2;

        public MyStack(){
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }

        
    }
    
    public int top() {
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
    }
    
    public boolean empty() {
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */