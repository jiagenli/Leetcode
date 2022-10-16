package main.com.ljg.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC78 {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList());
        return res;
    }

    private void dfs(int[] nums, int cur, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        if (cur > nums.length - 1) {
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
