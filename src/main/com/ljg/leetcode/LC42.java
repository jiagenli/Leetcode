package main.com.ljg.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC42 {
    /**
     * 从左扫描一遍，从右扫描一遍，再计算左右差值
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[len - 1] = height[len - 1];
        for (int j = len - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * 这个版本取消了左边最高点的遍历，但是提交结果来看和上一个方法没有区别。
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int len = height.length;
        int maxLeft = 0;
        int[] maxRight = new int[len];

        maxRight[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 1; i < len; i++) {
            maxLeft = Math.max(height[i - 1], maxLeft);
            int minus = Math.min(maxLeft, maxRight[i]);
            if (minus > height[i]) {
                sum += minus - height[i];
            }
        }
        return sum;
    }

    /**
     * 以为这个方法会更快，结果更慢了
     * 思路是用栈保存前面的高度，比栈顶低则入栈，比栈顶高则出栈
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int len = height.length;
        Deque<Integer> stack = new LinkedList<>();
        int i = 0, sum = 0;
        while (i < len) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // pop stack
                int h = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                // 假如说有几个同水平面的箱子，只算上一个不会重复计算吗?
                int distance = i - stack.peek() - 1;
                // 不会，因为在这里用的是stack.peek()，如果同一水平面在下一行相减为0
                int min = Math.min(height[stack.peek()], height[i]);
                sum += distance * (min - h);
            }
            stack.push(i);
            i++;
        }
        return sum;
    }

}
