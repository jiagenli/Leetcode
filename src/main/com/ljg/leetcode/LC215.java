package main.com.ljg.leetcode;

import java.util.PriorityQueue;

public class LC215 {
    /**
     * 第一个想法是优先队列
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}
