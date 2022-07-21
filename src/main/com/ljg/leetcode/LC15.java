package main.com.ljg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class LC15 {
    /**
     * 排序 + 双指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int l = i + 1, r = nums.length - 1;
            int rest = - nums[i];
            while (l < r) {
                if (nums[i] + nums[l] > 0) break; // 前两个数如果已经大于0，没有计算的必要
                if (nums[l] + nums[r] == rest) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) l++; // 对于重复的左指针指向的数
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) r--; // 对于重复的右指针指向的数
                } else if (nums[l] + nums[r] < rest) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
