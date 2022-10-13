package main.com.ljg.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC232 {
}

class MyQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public MyQueue() {
        this.stack1 = new LinkedList<>();
        this.stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int returnValue = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return returnValue;
    }

    /**
     * 这个也要注意
     * @return
     */
    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int returnValue = stack2.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return returnValue;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
