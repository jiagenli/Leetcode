package main.com.ljg.leetcode;

public class LC169 {
    /**
     * 摩尔投票法，相同元素count++，不同元素count--，count为0时就换一个元素。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == major) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    major = nums[i];
                    count = 1;
                }
            }
        }
        return major;
    }
}
