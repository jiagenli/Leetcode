package main.com.ljg.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            // 从小到大判断
            if (!set.contains(nums[i] - 1)) {
                int len = 0;
                int cur = nums[i];
                while (set.contains(cur)) {
                    len++;
                    cur++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
