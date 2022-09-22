package main.com.ljg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 也是用深度优先遍历来做
 */
public class LC46 {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int cur) {
        if (cur == nums.length - 1) {
            Integer[] numlist = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                numlist[i] = nums[i];
            }
            List<Integer> temp = Arrays.asList(numlist);
            result.add(temp);
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            swap(nums, cur, i);
            dfs(nums, cur + 1);
            swap(nums, cur, i);
        }

    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
