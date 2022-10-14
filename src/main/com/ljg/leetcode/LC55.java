package main.com.ljg.leetcode;

public class LC55 {
    /**
     * 一开始我以为应该用双指针做这道题，其实动态规划就可以
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxPos) {
                maxPos = Math.max(maxPos, i + nums[i]);
                if (maxPos >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
