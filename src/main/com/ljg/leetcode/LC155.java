package main.com.ljg.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC155 {
}

class MinStack {

    private Deque<Integer> s1;
    private Deque<Integer> minS;

    public MinStack() {
        s1 = new LinkedList<>();
        minS = new LinkedList<>();
    }

    public void push(int val) {
        s1.push(val);
        if (minS.isEmpty() || val <= minS.peek()) {
            minS.push(val);
        }
    }

    public void pop() {
        int out = s1.pop();
        if (out == minS.peek()) {
            minS.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return minS.peek();
    }
}
