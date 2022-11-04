package main.com.ljg.leetcode;

public class LC152 {
    public int maxProduct(int[] nums) {
        int maxRes = nums[0], minRes = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = maxRes, mn = minRes;
            maxRes = Math.max(mx * nums[i], Math.max(mn * nums[i], nums[i]));
            minRes = Math.min(mn * nums[i], Math.min(mx * nums[i], nums[i]));
            ans = Math.max(ans, maxRes);
        }
        return ans;
    }
}
