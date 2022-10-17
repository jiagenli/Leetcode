package main.com.ljg.leetcode;

public class LC300 {
    /**
     * 快手考我的一道题，当时心态不太冷静，遇到没见过的题就不想做，而且还是个动态规划的
     * 其实不难，就是笨方法，查找i之前比i小的数有几个
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 核心公式
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
