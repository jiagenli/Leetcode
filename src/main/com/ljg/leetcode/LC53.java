package main.com.ljg.leetcode;

public class LC53 {
    /**
     * 我的第一遍做法，思路是动态规划
     * 可优化的点是dp可以不是数组
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    /**
     * 第二遍做法，100%
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int dp = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            res = Math.max(dp, res);
        }
        return res;
    }
}
