package main.com.ljg.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC347 {
    /**
     * 通过堆来实现的一种笨方法
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
            return map.get(x) - map.get(y);
        });

        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(key);
            } else if (map.get(pq.peek()) < map.get(key)) {
                pq.remove();
                pq.offer(key);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
